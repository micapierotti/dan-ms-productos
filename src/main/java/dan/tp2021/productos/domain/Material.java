package dan.tp2021.productos.domain;
import javax.persistence.*;

@Entity
public class Material {

	@Id
	private Integer id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stockActual;
	private Integer stockMinimo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIDAD_ID")
	Unidad unidad;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStockActual() {
		return stockActual;
	}
	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}
	public Integer getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Material(Integer id, String nombre, String descripcion, Double precio, Integer stockActual, Integer stockMinimo, Unidad unidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.unidad = unidad;
	}

	public Material() {
	}
}
