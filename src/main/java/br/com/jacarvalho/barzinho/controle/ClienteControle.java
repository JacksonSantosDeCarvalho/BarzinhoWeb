package br.com.jacarvalho.barzinho.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jacarvalho.barzinho.cliente.ClienteServico;
import br.com.jacarvalho.barzinho.modelo.RespostaModelo;
import br.com.jacarvalho.barzinho.modelo.entidade.Cliente;

@RestController
public class ClienteControle {
    @GetMapping("/")
    public String rota () {
        return "Teste da aula de Spring boot";
    }

    @Autowired
    private ClienteServico clienteServico;

    @GetMapping("/clientes")
    public Iterable<Cliente>listar(){
        return clienteServico.listar();
    }

    @PostMapping("/cliente")
    public ResponseEntity<?> salvar(@RequestBody Cliente cliente){
        return clienteServico.salvar(cliente, "Salvar");
    }

    @PutMapping("/cliente")
    public ResponseEntity<?> atualizar(@RequestBody Cliente cliente){
        return clienteServico.salvar(cliente, "Atualizar");
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id){
        return clienteServico.remover(id);
    }

}
