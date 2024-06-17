package com.vendas.services.pedido;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vendas.domain.model.Cliente;
import com.vendas.domain.model.ItemPedido;
import com.vendas.domain.model.Pedido;
import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ClienteRepository;
import com.vendas.domain.repository.ItemPedidoRepository;
import com.vendas.domain.repository.PedidoRepository;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.exception.ClienteNaoExisteException;
import com.vendas.exception.ItensVazioException;
import com.vendas.exception.ProdutoNaoExisteException;
import com.vendas.rest.dto.itemPedido.ItemPedidoPostRequestDTO;
import com.vendas.rest.dto.itemPedido.PedidoPostDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoV1CadastraService implements PedidoCadastraService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido cadastrarPedido(ItemPedidoPostRequestDTO itemPedidoPostRequestDTO) {

        Cliente cliente = clienteRepository.findById(itemPedidoPostRequestDTO.getCliente()).orElseThrow(ClienteNaoExisteException::new); 

        Pedido currentPedido = new Pedido();
        currentPedido.setCliente(cliente);
        currentPedido.setDataPedido(LocalDate.now());
        currentPedido.setTotal(itemPedidoPostRequestDTO.getTotal());

        List<ItemPedido> itensPedidos = itensPedidosPost(currentPedido, itemPedidoPostRequestDTO.getItens());
        pedidoRepository.save(currentPedido);
        itemPedidoRepository.saveAll(itensPedidos);
        currentPedido.setItens(itensPedidos);
        return currentPedido;
    }

    private List<ItemPedido> itensPedidosPost(Pedido pedido, List<PedidoPostDTO> itens){
        if(itens.isEmpty()){
            throw new ItensVazioException();
        }

        return itens.stream().map(item -> {
            Produto produto = produtoRepository.findById(item.getProduto()).orElseThrow(ProdutoNaoExisteException::new);

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setQuantidade(item.getQuantidade());
            itemPedido.setProduto(produto);
            return itemPedido;

        }).collect(Collectors.toList());
    }

}
