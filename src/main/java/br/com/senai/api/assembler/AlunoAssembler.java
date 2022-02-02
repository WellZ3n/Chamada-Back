package br.com.senai.api.assembler;

import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.model.input.AlunoInputDTO;
import br.com.senai.domain.model.Alunos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AlunoAssembler {

    ModelMapper modelMapper;

    public AlunoDTO toModel(Alunos pessoa){
        return modelMapper.map(pessoa, AlunoDTO.class);
    }

    public Alunos toEntity(AlunoInputDTO alunoInputDTO){
        return modelMapper.map(alunoInputDTO, Alunos.class);
    }

    public List<AlunoDTO> toCollectionModel(List<Alunos> pessoas){
        return pessoas.stream().map(this::toModel)
                .collect(Collectors.toList());
    }

}
