package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository enderecoRepo;

    @Autowired
    private PessoaRepository pessoaRepo;
    @GetMapping
    public List<Endereco> findAll(){
        return enderecoRepo.findAll();
    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco e){
        return enderecoRepo.save(e);
    }

    @GetMapping(value = "/cep/{cep}")
    public Endereco findByCep(@PathVariable String cep) {
        return enderecoRepo.findByCep(cep).orElseThrow();
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public Pessoa findById(@PathVariable Long idPessoa){
        return pessoaRepo.findById(idPessoa).orElseThrow();

    }
}
