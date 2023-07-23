package cl.otakubook.otakubookapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "detalles_carrito")
@Data
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_carrito")
    private Long idDetalleCarrito;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private CarritoCompra carrito;

    @ManyToOne
    @JoinColumn(name = "id_manga")
    private Manga manga;

    private int cantidad;

}