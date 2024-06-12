package com.vendas.services.pedido;

import com.vendas.domain.dto.itemPedido.ItemPedidoPostRequestDTO;
import com.vendas.domain.model.Pedido;

@FunctionalInterface
public interface PedidoCadastraService {
    public Pedido cadastrarPedido(ItemPedidoPostRequestDTO itemPedidoPostRequestDTO);
}
