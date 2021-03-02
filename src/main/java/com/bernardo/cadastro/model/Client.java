package com.bernardo.cadastro.model;

import com.bernardo.cadastro.dto.ClientDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENT")
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String email;

    private String password;

    public static Client create(ClientDto clientDto){
        return new ModelMapper().map(clientDto,Client.class);
    }
}
