package com.contagematletas.contagematletasapi.services;

import com.contagematletas.contagematletasapi.model.Modalidade;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ModalidadeService {

    void delete(Long idmodalidade);
    Modalidade findById(Long idmodalidade);
    Page<Modalidade> findAll(Integer numberPages, Integer numberResults,String oderDir, String order);
    List<Modalidade> findList();
    Modalidade save(Modalidade modalidade);
}
