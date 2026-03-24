package com.rene.mercado.Entidad;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Table(name = "productos", schema = "rene")                                 // Anotacion para definir la tabla y el esquema al que pertenece

public class EntidadProductos {

    @Id                                                                     // Anotacion para identificar la llave primaria de la entidad producto
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_producto")                                           // Anotacion para definir el Id de la columna en la base de datos
    private Integer idProducto;                                             // Variable para manejar el Id de producto de la BD

    @NotNull(message = "El Precio Unitario es Obligatrio")                  // Anotacion para validar que el precio unitario no sea nulo, y mostrar mensaje de error personalizado
    @Column(name = "precio_unit")                                           // Anotacion para definir el precio del producto de la BD
    private BigDecimal precioUnit;                                          // Variable para manejar el precio del producto.

    @ManyToOne(fetch = FetchType.LAZY)                                      // Anotacion que apuntamos a la relacion de muchos a uno entre Categoria y producto, y carga los datos de la entidad principal (LAZY)
    @JoinColumn(name = "id_categoria")                                      // Anotacion para referirnos a la llave foranea que se relaciona con la tabla categoria
    private EntidadCategoria categoria;                                     // Variable para almacenar los datos de categoria asociado a un producto

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)            // Anotacion que indica que la relación está controlada desde la otra clase (Ropa), y no desde esta
    private List<EntidadRopa> ropas;                                        // lista para almacenar los objetos EntidadRopa relacionados o asociados a producto

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)            // Anotacion que indica que la relación está controlada desde la otra clase (Comida), y no desde esta
    private List<EntidadComida> comidas;                                    // lista para almacenar los objetos EntidadComida relacionados o asociados a producto
}
