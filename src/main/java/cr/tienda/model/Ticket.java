package cr.tienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ticket")
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private LocalDateTime fechaHora;
    // Relación con la entidad Cajero 1:N (muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cajero")
    private Cajero cajero;
    // Relación con la entidad Cliente 1:N (muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    // Relación con la entidad Productos N:N (muchos a muchos)
    @ManyToMany(mappedBy = "tickets", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Productos> productos = new ArrayList<>();
}
