package dan.tp2021.productos.domain;
import javax.persistence.*;

@Entity
public class DetallePedido {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "MATERIAL_ID")
	private Material material;
	private Integer cantidad;

	public DetallePedido() {

	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}

	public DetallePedido(Integer id, Material material, Integer cantidad) {
		this.id = id;
		this.material = material;
		this.cantidad = cantidad;
	}
}
