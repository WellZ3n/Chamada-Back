package br.com.senai.api.controller;

import br.com.senai.api.assembler.AlunoAssembler;
import br.com.senai.api.model.AlunoDTO;
import br.com.senai.api.model.input.AlunoInputDTO;
import br.com.senai.domain.model.Alunos;
import br.com.senai.domain.repository.AlunoRepository;
import br.com.senai.domain.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoRepository alunoRepository;
    private AlunoService alunoService;
    private AlunoAssembler alunoAssembler;

    @GetMapping()
    public List<AlunoDTO> listar(){
        return alunoAssembler.toCollectionModel(alunoRepository.findAll());
    }

    @PostMapping
    public AlunoDTO cadastrar(@Valid @RequestBody AlunoInputDTO pessoaInputDTO){
        Alunos newAlunos = alunoAssembler.toEntity(pessoaInputDTO);

        Alunos alunos = alunoService.cadastrar(newAlunos);

        return alunoAssembler.toModel(alunos);
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<Alunos> editar(
            @Valid @PathVariable Long alunoId,
            @RequestBody Alunos alunos
    ){
        if(!alunoRepository.existsById(alunoId)){
            return ResponseEntity.notFound().build();
        }

        alunos.setId(alunoId);
        alunos = alunoRepository.save(alunos);

        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Alunos> remover(@PathVariable Long alunoId){
        if(!alunoRepository.existsById(alunoId)){
            return ResponseEntity.notFound().build();
        }

        alunoService.excluir(alunoId);

        return ResponseEntity.noContent().build();
    }
}