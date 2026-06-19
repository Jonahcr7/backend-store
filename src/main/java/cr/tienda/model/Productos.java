package cr.tienda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Productos")
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombreProducto;
    private Double precioCosto;
    private Double precioVenta;
    private Double existencia;
    // Relación con la entidad Departamento 1:N (muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    // Relación con la entidad Ticket N:N (muchos a muchos)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ticket_producto",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_ticket"))
    @ToString.Exclude
    private List<Ticket> tickets = new ArrayList<>();
}
