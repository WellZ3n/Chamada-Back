package br.com.senai.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
public class Presencas {

    @Id
    public Long id;

    public boolean presente;

}
