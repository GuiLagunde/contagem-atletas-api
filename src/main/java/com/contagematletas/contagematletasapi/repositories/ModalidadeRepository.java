package com.contagematletas.contagematletasapi.repositories;

import com.contagematletas.contagematletasapi.model.Modalidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade,Long> {

    Page<Modalidade> findAll(Pageable pageable);
}
