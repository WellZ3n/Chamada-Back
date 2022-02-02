package br.com.senai.domain.service;

import br.com.senai.domain.model.Presencas;
import br.com.senai.domain.repository.PresencasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PresencasService {

    private PresencasRepository presencasRepository;

    @Transactional
    public Presencas cadastrar(Presencas presencas){
        return presencasRepository.save(presencas);
    }

    @Transactional
    public void excluir(Long alunoId){
        presencasRepository.deleteById(alunoId);
    }

}
