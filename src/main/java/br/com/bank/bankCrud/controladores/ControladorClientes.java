package br.com.bank.bankCrud.controladores;

import br.com.bank.bankCrud.excepitions.NotFound;
import br.com.bank.bankCrud.modelos.Clientes;
import br.com.bank.bankCrud.repositorios.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorClientes {

    @Autowired
    private RepositorioClientes repositorio;

    @PostMapping("/cadastrar")
    public Clientes cadastrarClientes(@RequestParam String nome, @RequestParam Double saldo) {
        Clientes clientes = new Clientes();
        clientes.setNome(nome);
        clientes.setSaldo(saldo);

        return repositorio.save(clientes);
    }

    @GetMapping("/listar")
    public List<Clientes> clientesLista() {
        return repositorio.findAll();
    }

    @PutMapping("/alterar")
    public Clientes alterarClientes(@RequestParam Integer id, @RequestParam String novoNome, @RequestParam Double novoSaldo) {
        Optional<Clientes> clienteNuloOuNao = repositorio.findById(id);
        if (clienteNuloOuNao.isPresent()) {
            Clientes clienteAlterado = clienteNuloOuNao.get();
            clienteAlterado.setNome(novoNome);
            clienteAlterado.setSaldo(novoSaldo);

            return repositorio.save(clienteAlterado);
        }else {
            return null;
        }
    }

    @PutMapping("/alterar/{id}")
    public Clientes alterarClientes2(@PathVariable Integer id, @RequestBody Clientes novosDadosDeCliente) {
        Clientes clienteAlterado = repositorio.findById(id).orElseThrow(() -> new NotFound("nao-tem-esse-cliente"));
        clienteAlterado.setNome(novosDadosDeCliente.getNome());
        clienteAlterado.setSaldo(novosDadosDeCliente.getSaldo());
        return repositorio.save(clienteAlterado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarClientes(@PathVariable Integer id) {
        boolean naoExisteEsseCliente = !repositorio.existsById(id);

        if(naoExisteEsseCliente) {
            throw new NotFound("nao-tem-esse-cliente");
        }
        repositorio.deleteById(id);
    }

    @GetMapping("/mostrar")
    public Clientes clientes(@RequestParam Integer id) {
        return repositorio.findById(id).orElseThrow(() -> new NotFound("nao-tem-esse-cliente"));

    }


}
