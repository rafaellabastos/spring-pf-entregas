package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

    @Autowired
    PassageiroRepository repo;
    @GetMapping
    public List<Passageiro> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Passageiro findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }
    @Transactional
    @PostMapping
    public Passageiro save(@RequestBody Passageiro p) {
        p.setId(null);
        return repo.save(p);
    }
}
