package Turn2C.Teste.cliente;

import Turn2C.Teste.endereco.Endereco;

public record DadosListagemCliente(Long id, String nome, String email, String cpf, Endereco endereco) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getEndereco());
    }

}