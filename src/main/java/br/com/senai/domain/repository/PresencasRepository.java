package br.com.senai.domain.repository;

import br.com.senai.domain.model.Presencas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresencasRepository extends JpaRepository<Presencas, Long> {

    List<Presencas> findPresencaById(Long id);
}
