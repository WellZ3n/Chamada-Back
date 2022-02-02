package br.com.senai.api.controller;

import br.com.senai.api.assembler.PresencasAssembler;
import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.model.PresencasDTO;
import br.com.senai.api.model.input.PresencasInputDTO;
import br.com.senai.domain.model.Alunos;
import br.com.senai.domain.model.Presencas;
import br.com.senai.domain.repository.AlunoRepository;
import br.com.senai.domain.repository.PresencasRepository;
import br.com.senai.domain.service.PresencasService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/chamada")
public class PresencasController {

    private PresencasRepository presencasRepository;
    private PresencasAssembler presencasAssembler;
    private PresencasService presencasService;

    @GetMapping()
    public List<PresencasDTO> listar(){
        return presencasAssembler.toCollectionModel(presencasRepository.findAll());
    }

    @PostMapping()
    public PresencasDTO cadastrar(@Valid @RequestBody PresencasInputDTO presencasInputDTO){
        Presencas newPresencas = presencasAssembler.toEntity(presencasInputDTO);

        Presencas presencas = presencasService.cadastrar(newPresencas);

        return presencasAssembler.toModel(presencas);
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Alunos> remover(@PathVariable Long alunoId){
        if(!presencasRepository.existsById(alunoId)){
            return ResponseEntity.notFound().build();
        }

        presencasService.excluir(alunoId);

        return ResponseEntity.noContent().build();
    }

}
