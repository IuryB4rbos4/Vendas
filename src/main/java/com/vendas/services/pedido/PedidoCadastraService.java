package com.vendas.services.pedido;

import com.vendas.domain.model.Pedido;
import com.vendas.rest.dto.itemPedido.ItemPedidoPostRequestDTO;

@FunctionalInterface
public interface PedidoCadastraService {
    public Pedido cadastrarPedido(ItemPedidoPostRequestDTO itemPedidoPostRequestDTO);
}
