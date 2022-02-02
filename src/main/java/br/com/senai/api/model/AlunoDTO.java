package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class AlunoDTO {

    private int id;
    private String nome;

}
