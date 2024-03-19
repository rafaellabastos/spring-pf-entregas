package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    ProdutoRepository repo;

    @GetMapping
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Produto save(@RequestBody Produto p) {
        p.setId(null);
        return repo.save(p);
    }
}
