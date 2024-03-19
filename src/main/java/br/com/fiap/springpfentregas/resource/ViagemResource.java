package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/viagem")
public class ViagemResource {

    @Autowired
    private ViagemRepository viagemRepo;

    @GetMapping
    public List<Viagem> findAll(){
        return viagemRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Viagem findById(@PathVariable Long id){
        return viagemRepo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Viagem save(@RequestBody Viagem v){
        return viagemRepo.save(v);
    }
}
