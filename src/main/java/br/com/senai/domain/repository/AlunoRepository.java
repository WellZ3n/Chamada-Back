package br.com.senai.domain.repository;

import br.com.senai.domain.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long> {

    List<Alunos> findByNome(String nome);
    List<Alunos> findByNomeContaining(String nome);
}
