package com.example.web.controller;

import com.example.repository.VendasRepository;
import com.example.web.domain.models.tb_vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vendas")
@RestController
public class VendasController {
    @Autowired
    VendasRepository vendasRepository;

    @GetMapping
    public List findAll(){
        return vendasRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return vendasRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public tb_vendas create(@RequestBody tb_vendas tbVendas) {
        return vendasRepository.save(tbVendas);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_vendas tbVendas) {
        return vendasRepository.findById(id).map(record ->{
            record.setData_venda(tbVendas.getData_venda());
            record.setTotal_venda(tbVendas.getTotal_venda());
            record.setClienteId(tbVendas.getClienteId());
            tb_vendas upDated = vendasRepository.save(record);
            return ResponseEntity.ok().body(upDated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        return vendasRepository.findById(id)
                .map(record -> {
                    vendasRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
