package com.example.web.controller;

import com.example.repository.FuncionariosRepository;
import com.example.web.domain.models.tb_fornecedores;
import com.example.web.domain.models.tb_funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/funcionarios")
@RestController
public class FuncionariosController {
    @Autowired
    FuncionariosRepository funcionariosRepository;

    @GetMapping
    public List findAll(){
        return funcionariosRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return funcionariosRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public tb_funcionarios create(@RequestBody tb_funcionarios tbFuncionarios) {
        return funcionariosRepository.save(tbFuncionarios);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_funcionarios tbFuncionarios) {
        return funcionariosRepository.findById(id).map(record ->{
            record.setNome(tbFuncionarios.getNome());
            record.setRg(tbFuncionarios.getRg());
            record.setCpf(tbFuncionarios.getCpf());
            record.setEmail(tbFuncionarios.getEmail());
            record.setSenha(tbFuncionarios.getSenha());
            record.setNivel_acesso(tbFuncionarios.getNivel_acesso());
            record.setTelefone(tbFuncionarios.getTelefone());
            record.setCelular(tbFuncionarios.getCelular());
            record.setEndereco(tbFuncionarios.getEndereco());
            record.setNumero(tbFuncionarios.getNumero());
            record.setComplemento(tbFuncionarios.getComplemento());
            record.setBairro(tbFuncionarios.getComplemento());
            record.setCidade(tbFuncionarios.getCidade());
            record.setEstado(tbFuncionarios.getEstado());
            tb_funcionarios upDated = funcionariosRepository.save(record);
            return ResponseEntity.ok().body(upDated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return funcionariosRepository.findById(id)
                .map(record -> {
                    funcionariosRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
