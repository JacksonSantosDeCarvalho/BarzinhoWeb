/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jacarvalho.barzinho.modelo.entidade;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jk-Sa
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String telefone;
    
}
