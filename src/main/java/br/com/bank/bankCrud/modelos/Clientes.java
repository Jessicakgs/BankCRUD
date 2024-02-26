package br.com.bank.bankCrud.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "cad_clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double saldo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Clientes(String nome, Double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public Clientes() {
    }
}
