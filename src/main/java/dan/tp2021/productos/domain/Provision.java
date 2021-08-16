package dan.tp2021.productos.domain;

import java.time.Instant;
import java.util.List;
import javax.persistence.*;

@Entity
public class Provision {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//TODO: ver como mapear instant
	private Instant fechaProvision;
	@OneToMany(targetEntity = DetalleProvision.class, cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleProvision> detalle;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Instant getFechaProvision() {
		return fechaProvision;
	}
	public void setFechaProvision(Instant fechaProvision) {
		this.fechaProvision = fechaProvision;
	}
	public List<DetalleProvision> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleProvision> detalle) {
		this.detalle = detalle;
	}

	
}
