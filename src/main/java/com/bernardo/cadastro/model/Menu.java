package com.bernardo.cadastro.model;

import com.bernardo.cadastro.dto.MenuDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name ="TB_MENU")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;


    public static Menu create(MenuDto menuDto){
        return new ModelMapper().map(menuDto,Menu.class);
    }

}
