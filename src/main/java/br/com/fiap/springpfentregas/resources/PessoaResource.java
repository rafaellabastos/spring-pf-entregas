package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepo;

    @GetMapping
    public List<Pessoa> findAll(){
        return pessoaRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id){
        return pessoaRepo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa p){
        return  pessoaRepo.save(p);
    }
}
