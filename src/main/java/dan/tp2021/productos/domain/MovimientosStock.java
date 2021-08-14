package dan.tp2021.productos.domain;
import java.time.Instant;
import javax.persistence.*;

@Entity
public class MovimientosStock {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "DETALLE_PED_ID")
	private DetallePedido detallePedido;
	@OneToOne
	@JoinColumn(name = "DETALLE_PROV_ID")
	private DetalleProvision detalleProvision;
	@OneToOne
	@JoinColumn(name = "MATERIAL_ID")
	private Material material;
	private Integer cantidadEntrada;
	private Integer cantidadSalida;
	//TODO: ver como mapear instant
	private Instant fecha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DetallePedido getDetallePedido() {
		return detallePedido;
	}
	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}
	public DetalleProvision getDetalleProvision() {
		return detalleProvision;
	}
	public void setDetalleProvision(DetalleProvision detalleProvision) {
		this.detalleProvision = detalleProvision;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Integer getCantidadEntrada() {
		return cantidadEntrada;
	}
	public void setCantidadEntrada(Integer cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}
	public Integer getCantidadSalida() {
		return cantidadSalida;
	}
	public void setCantidadSalida(Integer cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}
	public Instant getFecha() {
		return fecha;
	}
	public void setFecha(Instant fecha) {
		this.fecha = fecha;
	}
	
	
}
