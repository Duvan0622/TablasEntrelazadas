package uis.edu.entornos.TablasEntrelazadas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Usuario.TABLE_NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTipoDocumento")
    private TipoDocumento idTipoDocumento;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "email")
    private String email;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "password")
    private String password;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
}
