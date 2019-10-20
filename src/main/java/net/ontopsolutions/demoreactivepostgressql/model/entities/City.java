package net.ontopsolutions.demoreactivepostgressql.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "city")
public class City {

    @Id
    private Integer id;
    private String code;
    private String name;
    private Integer departmentId;

    City withId(Integer id, String code, String name, Integer departmentId){
        return new City(id,code,name,departmentId);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", stateId=" + departmentId +
                '}';
    }
}