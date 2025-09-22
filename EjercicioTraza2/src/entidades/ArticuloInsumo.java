package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder

public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private boolean esParaElaborar;
    HashSet<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();
}
