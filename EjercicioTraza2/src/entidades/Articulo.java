package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;
import relacioncontraza1.Sucursal;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder

public class Articulo {
    private String denominacion;
    private double precioVenta;
    protected long id;
    private UnidadMedida unidadMedida;
    private Categoria categoria;
    @Builder.Default
    HashSet<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();
}
