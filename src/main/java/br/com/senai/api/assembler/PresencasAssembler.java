package br.com.senai.api.assembler;

import br.com.senai.api.model.PresencasDTO;
import br.com.senai.api.model.input.PresencasInputDTO;
import br.com.senai.domain.model.Presencas;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PresencasAssembler {

    ModelMapper modelMapper;

    public PresencasDTO toModel(Presencas presencas){
        return modelMapper.map(presencas, PresencasDTO.class);
    }

    public Presencas toEntity(PresencasInputDTO presencasInputDTO){
        return modelMapper.map(presencasInputDTO, Presencas.class);
    }

    public List<PresencasDTO> toCollectionModel(List<Presencas> presencas){
        return presencas.stream().map(this::toModel)
                .collect(Collectors.toList());
    }

}
