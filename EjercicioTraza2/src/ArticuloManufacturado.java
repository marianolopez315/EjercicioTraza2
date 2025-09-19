import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;

    @Builder.Default
    HashSet<ArticuloManufacturadoDetalle>articuloManufacturadoDetalles = new HashSet<>();
}
