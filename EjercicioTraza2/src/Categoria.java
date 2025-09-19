import lombok.*;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Categoria {
    private String denominacion;
    private long id;

    @Builder.Default
    private HashSet<Articulo>articulos = new HashSet<>();
}
