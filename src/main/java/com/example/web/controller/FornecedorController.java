package com.example.web.controller;

import com.example.repository.FornecedorRepository;
import com.example.web.domain.models.tb_fornecedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/fornecedores")
@RestController
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public List findAll(){
        return fornecedorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return fornecedorRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public tb_fornecedores create(@RequestBody tb_fornecedores tbFornecedores) {
        return fornecedorRepository.save(tbFornecedores);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_fornecedores tbFornecedores) {
        return fornecedorRepository.findById(id).map(record ->{
            record.setNome(tbFornecedores.getNome());
            record.setCnpj(tbFornecedores.getCnpj());
            record.setEmail(tbFornecedores.getEmail());
            record.setTelefone(tbFornecedores.getTelefone());
            record.setCelular(tbFornecedores.getCelular());
            record.setEndereco(tbFornecedores.getEndereco());
            record.setNumero(tbFornecedores.getNumero());
            record.setComplemento(tbFornecedores.getComplemento());
            record.setBairro(tbFornecedores.getComplemento());
            record.setCidade(tbFornecedores.getCidade());
            record.setEstado(tbFornecedores.getEstado());
            tb_fornecedores upDated = fornecedorRepository.save(record);
            return ResponseEntity.ok().body(upDated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return fornecedorRepository.findById(id)
                .map(record -> {
                    fornecedorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
