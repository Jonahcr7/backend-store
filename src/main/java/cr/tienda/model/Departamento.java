package cr.tienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Departamento")
@Table(name = "departamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    private String nombreDepartamento;
    private LocalDate fechaDeCreacion;
    // Relación con la entidad Cajero 1:N (muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cajero")
    private Cajero cajero;
    // Relación con la entidad Productos 1:N (uno a muchos)
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Productos> productos = new ArrayList<>();
}
