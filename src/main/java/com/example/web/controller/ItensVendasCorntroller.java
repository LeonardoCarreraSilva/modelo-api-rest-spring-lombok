package com.example.web.controller;

import com.example.repository.VendasItensRepository;
import com.example.web.domain.models.tb_itensvendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/itensVendas")
@RestController
public class ItensVendasCorntroller {
    @Autowired
    VendasItensRepository vendasItensRepository;

    @GetMapping
    public List findAll(){
        return vendasItensRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return vendasItensRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public tb_itensvendas create(@RequestBody tb_itensvendas tbItensvendas) {
        return vendasItensRepository.save(tbItensvendas);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_itensvendas tbItensvendas) {
        return vendasItensRepository.findById(id).map(record ->{
            record.setQtd(tbItensvendas.getQtd());
            record.setSubtotal(tbItensvendas.getSubtotal());
            tb_itensvendas upDated = vendasItensRepository.save(record);
            return ResponseEntity.ok().body(upDated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return vendasItensRepository.findById(id)
                .map(record -> {
                    vendasItensRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
