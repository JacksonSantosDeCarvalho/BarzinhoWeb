package br.com.jacarvalho.barzinho.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.jacarvalho.barzinho.modelo.entidade.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
    
}
