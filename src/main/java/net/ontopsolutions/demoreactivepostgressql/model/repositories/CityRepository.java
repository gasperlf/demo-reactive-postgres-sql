package net.ontopsolutions.demoreactivepostgressql.model.repositories;

import net.ontopsolutions.demoreactivepostgressql.model.entities.City;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CityRepository extends ReactiveCrudRepository<City,Integer> {
}
