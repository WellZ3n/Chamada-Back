package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class PresencasDTO {

    private Long id;

    private boolean presente;

}
