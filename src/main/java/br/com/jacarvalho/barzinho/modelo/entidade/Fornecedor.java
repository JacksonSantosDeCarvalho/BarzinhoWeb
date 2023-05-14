package br.com.jacarvalho.barzinho.modelo.entidade;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    private long id;
    private String nome;
    private String cnpj;
    private String contato;

}
