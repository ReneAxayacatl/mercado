package com.rene.mercado.Modelo;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Table(name = "productos", schema = "rene")                                 // Anotacion para definir la tabla en la base de datos y el esquema al que pertenece

public class Productos {

    @Id                                                                     // Anotacion para identificar PK de la entidad 'productos'
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     // Anotacion para definir el dato auto-incremental a la PK
    @Column(name = "id_producto")                                           // Anotacion para definir el Id de la columna en la base de datos
    private Integer idProducto;                                             // Variable de tipo entero para almacenar el Id del producto

    @NotNull(message = "El Precio Unitario es Obligatrio")                  // Anotacion para validar que el precio unitario no sea nulo, y mostrar mensaje de error personalizado
    @Column(name = "precio_unit")                                           // Anotacion para definir le precio unitario como valor decimal de la columna en la base de datos
    private BigDecimal precioUnit;                                          // Variable de tipo decimal para almacenar el precio unitario del producto

    @ManyToOne(fetch = FetchType.LAZY)                                      // Anotacion para definir la relacion de muchos a uno entre Productos y Categoria, y traer datos de forma secuencial (LAZY)
    @JoinColumn(name = "id_categoria")                                      // Anotacion para definir el nombre de la llave foranea de la columna en la BD que se relaciona con la tabla 'categoria'
    private Categoria categoria;                                            // Variable de tipo Categoria para almacenar los datos de categoria asociado a un producto

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Ropa> ropas;                                          // Lista de datos de las ropas asociados a un producto

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Comida> comidas;   
}
