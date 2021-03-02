package com.bernardo.cadastro.model;

import com.bernardo.cadastro.dto.RestaurantDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_RESTAURANT")
@Data
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String email;

    private String password;

    public static Restaurant create(RestaurantDto restaurantDto){
        return new ModelMapper().map(restaurantDto, Restaurant.class);
    }
}
