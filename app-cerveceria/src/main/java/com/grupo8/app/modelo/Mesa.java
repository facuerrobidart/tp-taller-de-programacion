package com.grupo8.app.modelo;

import com.grupo8.app.tipos.EstadoMesa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mesa {
    private Integer nroMesa;
    private Integer cantSillas;
    private EstadoMesa estadoMesa;
    private Mozo mozoAsignado;
}
