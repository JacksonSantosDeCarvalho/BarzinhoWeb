package br.com.jacarvalho.barzinho.comanda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jacarvalho.barzinho.modelo.RespostaModelo;
import br.com.jacarvalho.barzinho.modelo.entidade.Comanda;
import br.com.jacarvalho.barzinho.repositorio.ComandaRepositorio;

@Service
public class ComandaServico {

    @Autowired
    private ComandaRepositorio comandaRepositorio;

    public Iterable<Comanda> listar(){
        return comandaRepositorio.findAll();
    }

    @Autowired
    private RespostaModelo respostaModelo;

    public ResponseEntity<?> salvar(Comanda comanda, String acao){
        if (comanda.getNome().equals("")){
            respostaModelo.setMensagem("Nome é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.BAD_REQUEST);
        }
        else{
            if(acao.equals("Salvar")){
                return new ResponseEntity<Comanda>(comandaRepositorio.save(comanda), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Comanda>(comandaRepositorio.save(comanda), HttpStatus.OK);
            }
           
        }

        
    }

    public ResponseEntity<RespostaModelo> remover(Long id){
        comandaRepositorio.deleteById(id);
        respostaModelo.setMensagem("Removido com sucesso");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
