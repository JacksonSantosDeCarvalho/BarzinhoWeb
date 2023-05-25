package br.com.jacarvalho.barzinho.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.jacarvalho.barzinho.modelo.entidade.Comanda;

public interface ComandaRepositorio extends CrudRepository<Comanda, Long> {
    
}
