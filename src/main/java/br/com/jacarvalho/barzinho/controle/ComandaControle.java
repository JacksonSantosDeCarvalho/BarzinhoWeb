package br.com.jacarvalho.barzinho.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jacarvalho.barzinho.comanda.ComandaServico;
import br.com.jacarvalho.barzinho.modelo.RespostaModelo;
import br.com.jacarvalho.barzinho.modelo.entidade.Comanda;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ComandaControle {
    

    @Autowired
    private ComandaServico comandaServico;

    @GetMapping("/comandas")
    public Iterable<Comanda>listar(){
        return comandaServico.listar();
    }

    @PostMapping("/comanda")
    public ResponseEntity<?> salvar(@RequestBody Comanda comanda){
        return comandaServico.salvar(comanda, "Salvar");
    }

    @PutMapping("/comanda")
    public ResponseEntity<?> atualizar(@RequestBody Comanda comanda){
        return comandaServico.salvar(comanda, "Atualizar");
    }

    @DeleteMapping("/comanda/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id){
        return comandaServico.remover(id);
    }
}
