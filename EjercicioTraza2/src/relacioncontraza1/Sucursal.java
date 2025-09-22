package relacioncontraza1;

import entidades.Articulo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Sucursal {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;
    private Domicilio domicilio;
    private Empresa empresa;
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
        articulo.getSucursales().add(this); // Mantener la bidireccionalidad
    }

    public Sucursal(String nombre, Domicilio domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

}