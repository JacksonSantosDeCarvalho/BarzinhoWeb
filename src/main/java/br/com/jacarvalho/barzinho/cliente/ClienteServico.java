package br.com.jacarvalho.barzinho.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jacarvalho.barzinho.modelo.RespostaModelo;
import br.com.jacarvalho.barzinho.modelo.entidade.Cliente;
import br.com.jacarvalho.barzinho.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Iterable<Cliente> listar(){
        return clienteRepositorio.findAll();
    }

    @Autowired
    private RespostaModelo respostaModelo;

    public ResponseEntity<?> salvar(Cliente cliente, String acao){
        if (cliente.getNome().equals("")){
            respostaModelo.setMensagem("Nome é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.BAD_REQUEST);
        }else if (cliente.getNumero().equals("")){
            respostaModelo.setMensagem("Número é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (cliente.getRua().equals("")){
            respostaModelo.setMensagem("Rua é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else if (cliente.getBairro().equals("")){
            respostaModelo.setMensagem("Bairro é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else if (cliente.getTelefone().equals("")){
            respostaModelo.setMensagem("Telefone é obrigatorio");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }
        else{
            if(acao.equals("Salvar")){
                return new ResponseEntity<Cliente>(clienteRepositorio.save(cliente), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Cliente>(clienteRepositorio.save(cliente), HttpStatus.OK);
            }
           
        }

        
    }

    public ResponseEntity<RespostaModelo> remover(Long id){
        clienteRepositorio.deleteById(id);
        respostaModelo.setMensagem("Removido com sucesso");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
