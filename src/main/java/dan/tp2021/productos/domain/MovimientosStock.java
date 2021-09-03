package dan.tp2021.productos.domain;
import java.time.Instant;
import java.util.Date;
import javax.persistence.*;

@Entity
public class MovimientosStock {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer detallePedidoId;
	@OneToOne
	@JoinColumn(name = "DETALLE_PROV_ID")
	private DetalleProvision detalleProvision;
	@OneToOne
	@JoinColumn(name = "MATERIAL_ID")
	private Material material;
	private Integer cantidadEntrada;
	private Integer cantidadSalida;
	private Date fecha;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDetallePedidoId() {
		return detallePedidoId;
	}

	public void setDetallePedidoId(Integer detallePedidoId) {
		this.detallePedidoId = detallePedidoId;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MovimientosStock(Integer id, Integer detallePedidoId, DetalleProvision detalleProvision, Material material, Integer cantidadEntrada, Integer cantidadSalida, Date fecha) {
		this.id = id;
		this.detallePedidoId = detallePedidoId;
		this.detalleProvision = detalleProvision;
		this.material = material;
		this.cantidadEntrada = cantidadEntrada;
		this.cantidadSalida = cantidadSalida;
		this.fecha = fecha;
	}

	public MovimientosStock() {
	}
}
