package uis.edu.entornos.TablasEntrelazadas.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;

@Entity
@Table(name = Producto.TABLE_NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    public static final String TABLE_NAME = "producto";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor idProveedor;
    @Column(name = "ivaCompra")
    private Double ivaCompra;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precioCompra")
    private Double precioCompra;
    @Column(name = "precioVenta")
    private Double precioVenta;
}
