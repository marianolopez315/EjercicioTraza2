import lombok.*;


import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class UnidadMedida {
    private String denominacion;
    private long id;
    HashSet<Articulo> articulos =new HashSet<>();
}
