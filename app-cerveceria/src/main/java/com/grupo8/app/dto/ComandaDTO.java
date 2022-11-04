package com.grupo8.app.dto;

import com.grupo8.app.modelo.Comanda;
import com.grupo8.app.tipos.EstadoComanda;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComandaDTO {
    private List<PedidoDTO> pedidos;
    private MesaDTO mesa;
    private String id;
    private EstadoComanda estadoPedido;
    private Instant apertura;
    private Instant cierre;


    public static ComandaDTO of(Comanda comanda) {
        ComandaDTO comandaDTO = new ComandaDTO();
        List<PedidoDTO> pedidos = new ArrayList<>();
        comanda.getPedidos().forEach(pedido -> pedidos.add(PedidoDTO.of(pedido)));

        comandaDTO.setPedidos(pedidos);
        comandaDTO.setMesa(MesaDTO.of(comanda.getMesa()));
        comandaDTO.setId(comanda.getId());
        comandaDTO.setEstadoPedido(comanda.getEstadoPedido());
        comandaDTO.setApertura(comanda.getApertura());
        comandaDTO.setCierre(comanda.getCierre());

        return comandaDTO;
    }
}