package dan.tp2021.productos.dto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Integer id;
    private Date fechaPedido;
    //FIXME da problema q sea un enum originalmente?
    private String estadoPedido;
    List<DetallePedidoDTO> detallePedidoDTOList;

    public PedidoDTO() {
    }

    public PedidoDTO(Integer id, Date fechaPedido, String estadoPedido, List<DetallePedidoDTO> detallePedidoDTOList) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.detallePedidoDTOList = detallePedidoDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DetallePedidoDTO> getDetallePedidoDTOList() {
        return detallePedidoDTOList;
    }

    public void setDetallePedidoDTOList(List<DetallePedidoDTO> detallePedidoDTOList) {
        this.detallePedidoDTOList = detallePedidoDTOList;
    }
}
