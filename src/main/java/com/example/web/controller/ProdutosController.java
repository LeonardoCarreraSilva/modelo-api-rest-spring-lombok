package com.example.web.controller;

import com.example.repository.ProdutosRepository;
import com.example.web.domain.models.tb_funcionarios;
import com.example.web.domain.models.tb_produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping
    public List findAll(){
        return produtosRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return produtosRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public tb_produtos create(@RequestBody tb_produtos tbProdutos) {
        return produtosRepository.save(tbProdutos);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_produtos tbProdutos) {
        return produtosRepository.findById(id).map(record ->{
            record.setDescricao(tbProdutos.getDescricao());
            record.setPreco(tbProdutos.getPreco());
            record.setQtd_estoque(tbProdutos.getQtd_estoque());
            tb_produtos upDated = produtosRepository.save(record);
            return ResponseEntity.ok().body(upDated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return produtosRepository.findById(id)
                .map(record -> {
                    produtosRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
