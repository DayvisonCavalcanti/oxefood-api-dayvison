package br.com.ifpe.oxefood.api.cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

       @Autowired
    private UsuarioService usuarioService;


    @Operation(
        summary = "Serviço responsável por salvar um cliente no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema.")

    @PostMapping // cadastrar dados para api pelo corpo do jason
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest clienteRequest, HttpServletRequest request) {

        Cliente cliente = clienteService.save(clienteRequest.build(), usuarioService.obterUsuarioLogado(request));
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @Operation(summary = "Serviço responsável por listar os clientes no sistema.", description = "Exemplo de descrição de um endpoint responsável por listar os cliente no sistema.")
    @GetMapping // passar todos os dados para api - listar clientes
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Serviço responsável por listar um cliente pelo id no sistema.", description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema.")
    @GetMapping("/{id}") // passar dados para api por id - listar por id
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @Operation(summary = "Serviço responsável por alterar um cliente pelo id no sistema.", description = "Exemplo de descrição de um endpoint responsável por alterar um cliente no sistema.")
    @PutMapping("/{id}") // alterar registro do cliente por id
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody @Valid ClienteRequest clienteRequest, HttpServletRequest request) {

        clienteService.update(id, clienteRequest.build(), usuarioService.obterUsuarioLogado(request));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço responsável por deletar um cliente pelo id no sistema.", description = "Exemplo de descrição de um endpoint responsável por deletar um cliente no sistema.")
    @DeleteMapping("/{id}") // deletar registro por id
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    // implemente 3 métodos, um para adicionar um endereço a um cliente, outro para
    // alterar um endereço de um cliente e outro para remover:

    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
    }

    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId,
            @RequestBody EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
    }

    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

        clienteService.removerEnderecoCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }

}
