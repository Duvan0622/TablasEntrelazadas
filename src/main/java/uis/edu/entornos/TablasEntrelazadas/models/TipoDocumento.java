package uis.edu.entornos.TablasEntrelazadas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = TipoDocumento.TABLE_NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {
    public static final String TABLE_NAME = "tipodocumento";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "tipo")
    private String tipo;
}
