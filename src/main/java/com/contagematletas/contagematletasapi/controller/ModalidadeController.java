package com.contagematletas.contagematletasapi.controller;

import com.contagematletas.contagematletasapi.exceptions.EntityNotFoundException;
import com.contagematletas.contagematletasapi.model.Modalidade;
import com.contagematletas.contagematletasapi.services.ModalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/modalidades")
public class ModalidadeController {

    @Autowired
    private ModalidadeService modalidadeService;

    @PostMapping
    public ResponseEntity<Modalidade> save(@Valid @RequestBody Modalidade modalidade){
        return ResponseEntity.ok().body(modalidadeService.save(modalidade));
    }

    @GetMapping
    public ResponseEntity<Page<Modalidade>> findAll(@RequestParam(value = "numberPages", required = false,defaultValue = "0")Integer numberPages,
                                                    @RequestParam(value = "numberResults", required = false,defaultValue = "10")Integer numberResults,
                                                    @RequestParam(value = "order",required = false,defaultValue = "id") String order,
                                                    @RequestParam(value = "orderDir",required = false, defaultValue = "ASC")String orderDir){

        return ResponseEntity.ok().body(modalidadeService.findAll(numberPages,numberResults,orderDir,order));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Modalidade>> findList(){

         return ResponseEntity.ok().body(modalidadeService.findList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Modalidade> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(modalidadeService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        try{
            modalidadeService.delete(id);
            return ResponseEntity.ok("Modalidade deletada com sucesso");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
