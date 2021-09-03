package dan.tp2021.productos.services;

import dan.tp2021.productos.domain.Material;
import dan.tp2021.productos.dto.PedidoDTO;

import java.util.List;

public interface MaterialService {

    Material crearMaterial(Material mat);
    boolean borrarMaterial(Integer id);
    Material actualizarMaterial(Material mat, Integer id);
    Material buscarPorNombre(String nombre);
    Material buscarPorId(Integer id);
    List<Material> buscarPorRangoStock(Integer stockMin, Integer stockMax);
    List<Material> buscarPorPrecio(Double precio);
    List<Material> buscarTodos();
    void registrarMovimientoStock(PedidoDTO pedidoDTO);
    boolean existeNombre(String nombre);
}
