import entidades.*;
import relacioncontraza1.Sucursal;
import repositorio.InMemoryRepository;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Inicializo Repositorios
        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();

        //Creo Categorias

        Categoria pizzas = Categoria.builder().denominacion("Pizzas").build();
        Categoria sanguche = Categoria.builder().denominacion("Sanguche").build();
        Categoria lomos = Categoria.builder().denominacion("Lomos").build();
        Categoria insumos = Categoria.builder().denominacion("Insumos").build();

        categoriaRepository.save(1L, pizzas);
        categoriaRepository.save(2L, sanguche);
        categoriaRepository.save(3L, lomos);
        categoriaRepository.save(4L, insumos);

        //Creo Unidades de Medida

        UnidadMedida kg = UnidadMedida.builder().denominacion("kg").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
        UnidadMedida gramos = UnidadMedida.builder().denominacion("gramos").build();

        unidadMedidaRepository.save(1L, kg);
        unidadMedidaRepository.save(2L, litro);
        unidadMedidaRepository.save(3L, gramos);

        //Creo Articulos

        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .esParaElaborar(true)
                .precioCompra(100)
                .stockActual(10)
                .stockMaximo(200)
                .categoria(insumos)
                .unidadMedida(gramos)
                .build();

        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .esParaElaborar(true)
                .precioCompra(200)
                .stockMaximo(400)
                .stockActual(250)
                .categoria(insumos)
                .unidadMedida(litro)
                .build();

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .esParaElaborar(true)
                .precioCompra(200)
                .stockMaximo(300)
                .stockActual(150)
                .categoria(insumos)
                .unidadMedida(kg)
                .build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .esParaElaborar(true)
                .precioCompra(500)
                .stockActual(200)
                .stockMaximo(600)
                .categoria(insumos)
                .unidadMedida(kg)
                .build();

        articuloInsumoRepository.save(1L, sal);
        articuloInsumoRepository.save(2L, aceite);
        articuloInsumoRepository.save(3L, harina);
        articuloInsumoRepository.save(4L, carne);

        // Creo imágenes para los artículos
        Imagen img1 = Imagen.builder().denominacion("HawaianaPizza1").url("http://example.com/pizza1").build();
        Imagen img2 = Imagen.builder().denominacion("HawaianaPizza2").url("http://example.com/pizza2").build();
        Imagen img3 = Imagen.builder().denominacion("HawaianaPizza3").url("http://example.com/pizza3").build();
        Imagen img4 = Imagen.builder().denominacion("LomoCompletoLomo1").url("http://example.com/lomo1").build();
        Imagen img5 = Imagen.builder().denominacion("LomoCompletoLomo2").url("http://example.com/lomo2").build();
        Imagen img6 = Imagen.builder().denominacion("LomoCompletoLomo3").url("http://example.com/lomo3").build();

        //Creo detalles

        ArticuloManufacturadoDetalle detalle1PizzaHawai = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2PizzaHawai = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(harina)
                .build();

        ArticuloManufacturadoDetalle detalle3PizzaHawai = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle1LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle3LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(carne)
                .build();

        //Creo Articulos Manufacturados

        ArticuloManufacturado pizzaHawai = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina")
                .precioVenta(15)
                .descripcion("Pizza con piña y jamón")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear por 20 minutos")
                .categoria(pizzas)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawai, detalle2PizzaHawai, detalle3PizzaHawai)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(20)
                .descripcion("Lomo completo con todos los ingredientes")
                .tiempoEstimadoMinutos(25)
                .preparacion("Cocinar a la parrilla por 25 minutos")
                .categoria(sanguche)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1LomoCompleto, detalle2LomoCompleto, detalle3LomoCompleto)))
                .build();

        articuloManufacturadoRepository.save(1L, pizzaHawai);
        articuloManufacturadoRepository.save(2L, lomoCompleto);

//EJERCICIO 5 -------------------------------------------------

        System.out.println("-----------------------5.A-----------------------");

        System.out.println("Todas las categorias: ");
        for (Categoria c: categoriaRepository.findAll()){
            System.out.println("- "+c.getDenominacion());
        }

        System.out.println("-----------------------5.B-----------------------");

        System.out.println("Articulos que son insumos: ");
        for (ArticuloInsumo ai : articuloInsumoRepository.findAll()){
            System.out.println("- "+ai.getDenominacion());
        }

        System.out.println("-----------------------5.C-----------------------");

        System.out.println("Articulos manufacturados: ");
        for (ArticuloManufacturado am : articuloManufacturadoRepository.findAll())
            System.out.println("- "+am.getDenominacion());

        System.out.println("-----------------------5.D-----------------------");
        long idBuscado = 2L;
        ArticuloManufacturado encontrado = articuloManufacturadoRepository.findById(idBuscado);

        if (encontrado!=null){
            System.out.println("entidades.Articulo manufacturado encontrado: ");
            System.out.println("ID: "+idBuscado+", Denominación: "+encontrado.getDenominacion());
        } else {
            System.out.println("No se encontró el artículo con ID: "+idBuscado);
        }

        System.out.println("-----------------------5.E-----------------------");
        System.out.println("Antes de actualizar: "+articuloManufacturadoRepository.findById(1L).getDenominacion());

        //aca actualizo
        if (articuloInsumoRepository.exists(1L)){
            ArticuloManufacturado pizzaA = ArticuloManufacturado.builder()
                    .denominacion("Pizza Fugazzeta")
                    .categoria(pizzas)
                    .precioVenta(12)
                    .descripcion("Pizza con queso y cebolla")
                    .build();
            articuloManufacturadoRepository.update(1L, pizzaA);
        }


        System.out.println("Después de actualizar: "+articuloManufacturadoRepository.findById(1L).getDenominacion());

        System.out.println("-----------------------5.F-----------------------");
        System.out.println("Antes de eliminar: ");
        for (ArticuloManufacturado am : articuloManufacturadoRepository.findAll()){
            System.out.println("- "+am.getDenominacion());
        }
        //ahora elimino
        long idElminar=1L;
        articuloManufacturadoRepository.delete(idElminar);

        System.out.println("Despues de eliminar: ");
        for (ArticuloManufacturado am : articuloManufacturadoRepository.findAll()){
            System.out.println("- "+am.getDenominacion());
        }
        if (!articuloManufacturadoRepository.exists(idElminar)){
            System.out.println("El articulo con ID: "+idElminar+" fue eliminado correctamente");
        } else {
            System.out.println("El articulo con ID: "+idElminar+" sigue existiendo");
        }

        System.out.println("--------------------------RELACION CON EJERCICIO TRAZA 1--------------------------");

        //Creo sucursales

        LocalTime horarioApertura = LocalTime.parse("08:30");
        LocalTime horarioCierre = LocalTime.parse("17:45");

        Sucursal suc1 = Sucursal.builder()
                .nombre("Sucursal 1")
                .horarioApertura(horarioApertura)
                .horarioCierre(horarioCierre)
                .build();

        LocalTime horarioApertura2 = LocalTime.parse("19:30");
        LocalTime horarioCierre2 = LocalTime.parse("01:45");

        Sucursal suc2 = Sucursal.builder()
                .nombre("Sucursal 2")
                .horarioApertura(horarioApertura2)
                .horarioCierre(horarioCierre2)
                .build();

        //relacion entre sucursales y articulos

        suc1.agregarArticulo(pizzaHawai);
        suc2.agregarArticulo(lomoCompleto);

        System.out.println("Articulos en: "+suc1.getNombre()+":");
        suc1.getArticulos().forEach(articulo -> System.out.println("- "+articulo.getDenominacion()));

        System.out.println("Sucursales donde se vende Lomo Completo: ");
        lomoCompleto.getSucursales().forEach(sucursal -> System.out.println("- "+sucursal.getNombre()));



    }


}