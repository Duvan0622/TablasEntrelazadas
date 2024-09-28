package uis.edu.entornos.TablasEntrelazadas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Venta.TABLE_NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    public static final String TABLE_NAME = "venta";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente idCliente;
    @Column(name = "ivaVenta")
    private Double ivaVenta;
    @Column(name = "totalVenta")
    private Double totalVenta;
    @Column(name = "valorVenta")
    private Double valorVenta;
}
