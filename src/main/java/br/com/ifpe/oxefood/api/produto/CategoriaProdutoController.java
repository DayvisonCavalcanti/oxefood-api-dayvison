package br.com.ifpe.oxefood.api.produto;

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
import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.produto.CategoriaProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin

public class CategoriaProdutoController {
    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @Operation(summary = "Serviço responsável por salvar um produto no sistema.", description = "Exemplo de descrição de um endpoint responsável por inserir um produto no sistema.")
    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {

        CategoriaProduto categoriaProduto = categoriaProdutoService.save(request.build());
        return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
    }

    @Operation(summary = "Serviço responsável por listar os produtos do sistema.", description = "Exemplo de descrição de um endpoint responsável por listar os produtos no sistema.")
    @GetMapping // passar todos os dados para api
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }

    @Operation(
       summary = "Serviço responsável por listar um produto no sistema por id.",
       description = "Exemplo de descrição de um endpoint responsável por listar um produto no sistema pelo id."
   )
    @GetMapping("/{id}") // passar dados para api por id
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }

    @Operation(
       summary = "Serviço responsável por alterar um produto no sistema por id.",
       description = "Exemplo de descrição de um endpoint responsável por alterar um produto no sistema po id."
   )
    @PutMapping("/{id}")// alterar registro do cliente por id
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {

        categoriaProdutoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(
        summary = "Serviço responsável por deletar um produto do sistema por id.",
        description = "Exemplo de descrição de um endpoint responsável por deletar um produto no sistema por id."
    )
    @DeleteMapping("/{id}")  // deletar registro por id
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        categoriaProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
