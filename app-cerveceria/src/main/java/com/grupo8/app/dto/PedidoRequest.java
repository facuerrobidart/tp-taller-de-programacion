package com.grupo8.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest {
    private String idProducto;
    private Integer cantidad;
    private String idComanda;
}
