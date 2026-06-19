package cr.tienda.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Cajero")
@Table(name = "cajero")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCajero;
    private String nombreCajero;
    private String apellidoCajero;
    private String contrasena;
    // Relación con la entidad Departamento 1:N (uno a muchos)
    @OneToMany(mappedBy = "cajero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Departamento> departamentos = new ArrayList<>();
    // Relación con la entidad Ticket 1:N (uno a muchos)
    @OneToMany(mappedBy = "cajero", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Ticket> tickets = new ArrayList<>();
}
