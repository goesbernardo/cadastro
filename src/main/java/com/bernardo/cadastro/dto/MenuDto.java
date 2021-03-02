package com.bernardo.cadastro.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    private String name;
    private String price;
    private Long restaurant;
}
