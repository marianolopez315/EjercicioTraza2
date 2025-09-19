import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder

public class Articulo {
    protected String denominacion;
    protected double precioVenta;
    protected long id;
    private UnidadMedida unidadMedida;
    private Categoria categoria;
    @Builder.Default
    HashSet<Imagen> imagenes = new HashSet<>();
}
