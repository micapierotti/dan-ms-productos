package dan.tp2021.productos.services;

import dan.tp2021.productos.domain.Material;
import java.util.List;

public interface MaterialService {

    public Material crearMaterial(Material mat);
    public boolean borrarMaterial(Integer id);
    public Material actualizarMaterial(Material mat, Integer id);
    public Material buscarPorNombre(String nombre);
    public Material buscarPorId(Integer id);
    public List<Material> buscarPorRangoStock(Integer stockMin, Integer stockMax);
    public List<Material> buscarPorPrecio(Double precio);
    public List<Material> buscarTodos();
}
