package br.com.senai.domain.service;

import br.com.senai.domain.model.Alunos;
import br.com.senai.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Transactional
    public Alunos cadastrar(Alunos alunos){
        return alunoRepository.save(alunos);
    }

    @Transactional
    public void excluir(Long alunoId){
        alunoRepository.deleteById(alunoId);
    }

}
