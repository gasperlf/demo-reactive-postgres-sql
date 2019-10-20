package net.ontopsolutions.demoreactivepostgressql.resources;

import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.demoreactivepostgressql.model.entities.City;
import net.ontopsolutions.demoreactivepostgressql.model.repositories.CityRepository;
import net.ontopsolutions.demoreactivepostgressql.utils.RestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class CityRestController {

    private final CityRepository cityRepository;

    @Autowired
    private RestTemplate restTemplate;

    public CityRestController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping(path = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<City> getCities(){
        return cityRepository.findAll();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate  restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateInterceptor());
        return restTemplate;
    }

    /**
     * Endpoint to test that traceId, SpanId, ParentSpanId and Sampled is in the header request.
     * @return List of cities.
     */
    @GetMapping(path="/callhome", produces = MediaType.APPLICATION_JSON_VALUE)
    public String callHome() {
        log.info("calling home");
        return restTemplate.getForObject("http://localhost:8081/cities", String.class);
    }
}
