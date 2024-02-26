package br.com.bank.bankCrud.repositorios;

import br.com.bank.bankCrud.modelos.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioClientes extends JpaRepository<Clientes, Integer> {

}
