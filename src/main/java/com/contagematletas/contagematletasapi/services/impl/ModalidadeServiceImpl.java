package com.contagematletas.contagematletasapi.services.impl;

import com.contagematletas.contagematletasapi.exceptions.EntityNotFoundException;
import com.contagematletas.contagematletasapi.exceptions.ObjectNotFoundException;
import com.contagematletas.contagematletasapi.model.Modalidade;
import com.contagematletas.contagematletasapi.repositories.ModalidadeRepository;
import com.contagematletas.contagematletasapi.services.ModalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service(value = "modalidadeService")
@Transactional
public class ModalidadeServiceImpl implements ModalidadeService {

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @Override
    public void delete(Long idmodalidade) throws EntityNotFoundException{

        try {
            modalidadeRepository.deleteById(idmodalidade);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("A modalidade com o ID " + idmodalidade + " não foi encontrada.");
        }
    }

    @Override
    public Modalidade findById(Long idmodalidade) {

        Optional<Modalidade> modalidade = modalidadeRepository.findById(idmodalidade);
        return modalidade.orElseThrow(() -> new ObjectNotFoundException("Modalidade não encontrada! Id: " + idmodalidade));
    }

    @Override
    public Page<Modalidade> findAll( Integer numberPages, Integer numberResults,String orderDir, String order) {

        Pageable pageable = PageRequest.of(numberPages,numberResults, Sort.Direction.valueOf(orderDir),order);
        return modalidadeRepository.findAll(pageable);
    }



    @Override
    public List<Modalidade> findList(){

        return this.findAll(0,Integer.MAX_VALUE,"ASC","id").getContent();
    }

    @Override
    public Modalidade save(Modalidade modalidade) {

        return modalidadeRepository.save(modalidade);
    }
}
