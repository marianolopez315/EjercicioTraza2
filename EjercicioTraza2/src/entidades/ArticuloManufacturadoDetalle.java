package entidades;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ArticuloManufacturadoDetalle {
    private int cantidad;
    private long id;
    private ArticuloInsumo articuloInsumo;
    private ArticuloManufacturado articuloManufacturado;
}
