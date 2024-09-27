package uis.edu.entornos.TablasEntrelazadas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Cliente.TABLE_NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    public static final String TABLE_NAME = "cliente";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTipoDocumento")
    private TipoDocumento idTipoDocumento;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;

}
