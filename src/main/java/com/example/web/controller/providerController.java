package com.example.web.controller;

import com.example.repository.providerRepository;
import com.example.web.domain.models.tb_provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/provider")
@RestController
public class providerController {

    @Autowired
    private providerRepository providerRepository;

    @GetMapping
    public List findAll(){
        return providerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return providerRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public tb_provider create(@RequestBody tb_provider tbFornecedores) {
        return providerRepository.save(tbFornecedores);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_provider tbFornecedores) {
        return providerRepository.findById(id).map(record ->{
            record.setName(tbFornecedores.getName());
            record.setEIN(tbFornecedores.getEIN());
            record.setEmail(tbFornecedores.getEmail());
            record.setPhone(tbFornecedores.getPhone());
            record.setCelphone(tbFornecedores.getCelphone());
            record.setAddress(tbFornecedores.getAddress());
            record.setNumber(tbFornecedores.getNumber());
            record.setComplement(tbFornecedores.getComplement());
            record.setNeighborhood(tbFornecedores.getNeighborhood());
            record.setCity(tbFornecedores.getCity());
            record.setState(tbFornecedores.getState());
            tb_provider upDated = providerRepository.save(record);
            return ResponseEntity.ok().body(upDated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return providerRepository.findById(id)
                .map(record -> {
                    providerRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
