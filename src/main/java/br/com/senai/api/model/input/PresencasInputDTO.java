package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class PresencasInputDTO {

    private Long id;

    @NotNull
    private boolean presente;

    }
