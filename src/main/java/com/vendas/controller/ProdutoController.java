package com.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.domain.dto.produto.ProdutoPostRequestDTO;
import com.vendas.domain.dto.produto.ProdutoPutRequestDTO;
import com.vendas.services.produto.ProdutoCadastraService;
import com.vendas.services.produto.ProdutoDeleteService;
import com.vendas.services.produto.ProdutoGetServices;
import com.vendas.services.produto.ProdutoUpdateService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "v1/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    @Autowired
    private ProdutoCadastraService produtoCadastraService;
    @Autowired
    private ProdutoGetServices produtoGetServices;
    @Autowired
    private ProdutoUpdateService produtoUpdateService;
    @Autowired
    private ProdutoDeleteService produtoDeleteService;


    @PostMapping("/")
    @Operation(summary = "Criar", description = "Metodo que cadastra um produto", tags = "Produto")
    public ResponseEntity<?> createProduto(@RequestBody @Valid ProdutoPostRequestDTO produtoPostRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoCadastraService.cadastrarProduto(produtoPostRequestDTO));
    }

    @GetMapping("/produtoId/{id}")
    @Operation(summary = "Buscar", description = "Metodo para buscar um produto pelo id", tags = "Produto")
    public ResponseEntity<?> getProdutoId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoGetServices.getProdutoId(id));
    }

    @GetMapping("/produto/name/{name}")
    @Operation(summary = "Buscar", description = "Metodo para buscar um produto pelo name", tags = "Produto")
    public ResponseEntity<?> getProdutoName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoGetServices.getProdutoName(name));
    }


    @PutMapping("/updateProdutoId/{id}")
    @Operation(
        summary = "Atualizar",
        description = "Metodo para atualizar um Produto",
        tags = "Produto"
    )
    public ResponseEntity<?> putProdutoId(@PathVariable("id") Long id, @RequestBody @Valid ProdutoPutRequestDTO produtoPutResquetDTO){
        return ResponseEntity.status(HttpStatus.OK).body(produtoUpdateService.putProdutoId(id, produtoPutResquetDTO));
    }

    @DeleteMapping("/deleteProdutoId/{id}")
    @Operation(summary = "Deletar", description = "Metodo para deletar um produto pelo id", tags = "Produto")
    public ResponseEntity<?> deleteProdutoId(@PathVariable("id") Long id){
        produtoDeleteService.deleteProdutoId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
    
}
