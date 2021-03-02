package com.bernardo.cadastro.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String name;

    private String email;

    private String password;
}
