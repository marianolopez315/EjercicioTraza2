import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Imagen {
    private String denominacion;
    private long id;
    private Articulo articulo;
}
