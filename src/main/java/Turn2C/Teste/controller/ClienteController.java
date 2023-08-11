package Turn2C.Teste.controller;


import Turn2C.Teste.cliente.Cliente;
import Turn2C.Teste.cliente.ClienteRepository;
import Turn2C.Teste.cliente.DadosCadastroCliente;
import Turn2C.Teste.cliente.DadosListagemCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")

public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }
    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosListagemCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
