package dan.tp2021.productos.services.implementacion;

import dan.tp2021.productos.database.MaterialRepository;
import dan.tp2021.productos.domain.*;
import dan.tp2021.productos.dto.PedidoDTO;
import dan.tp2021.productos.services.MaterialService;
import dan.tp2021.productos.services.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService{


    MaterialRepository materialRepository;
    ProvisionService provisionService;

    public MaterialServiceImpl(MaterialRepository materialRepository, ProvisionService provisionService) {
        this.materialRepository = materialRepository;
        this.provisionService = provisionService;
    }

    @Override
    public Material crearMaterial(Material m) {
        this.materialRepository.save(m);
        return m;
    }

    @Override
    public boolean borrarMaterial(Integer id) {
        Material m = buscarPorId(id);

        if(m != null){
            materialRepository.delete(m);
            return !materialRepository.findById(id).isPresent();
        } else {
            return false;
        }
    }

    @Override
    public Material actualizarMaterial(Material mat, Integer id) {
        try {
            if (materialRepository.findById(id).isPresent())
                return materialRepository.save(mat);
            else
                throw new RuntimeException("Para actualizar un material ingrese un id existente");
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Material buscarPorNombre(String nombre) {
        try {
            //return materialRepository.findByName(nombre);
            List<Material> materiales = (List<Material>) materialRepository.findAll();
            Material material = materiales.stream().filter((m) -> m.getNombre() == nombre).findFirst().get();
            return material;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Material buscarPorId(Integer id) {
        try{
            if (materialRepository.findById(id).isPresent())
                return materialRepository.findById(id).get();
            else
                throw new RuntimeException("No se halló el material de id " + id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Material> buscarPorRangoStock(Integer stockMin, Integer stockMax) {
        try{
            List<Material> materiales = (List<Material>) materialRepository.findAll();
            List<Material> materialesFiltrados = new ArrayList<Material>();
            materiales.stream().forEach((m) -> {
                if(m.getStockActual() >= stockMin && m.getStockActual() <= stockMax) {
                    materialesFiltrados.add(m);
                }
            });
            return materialesFiltrados;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Material> buscarTodos() {
        try{
            return (List<Material>) materialRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void registrarMovimientoStock(PedidoDTO pedidoDTO) {
        //TODO revisar si anda artemis?
        
        //Se registra un movimiento de stock del producto y además actualizará el stock actual en la tabla de productos.
        //Si se llegó a un stock debajo del mínimo se crea una nueva orden de provisión.

        Map<Integer, Integer> mapIdMaterialesCant = pedidoDTO.getDetallePedidoDTOList()
                                                    .stream().collect(Collectors
                        .toMap(detallePedidoDTO -> detallePedidoDTO.getProductoId(), detallePedidoDTO -> detallePedidoDTO.getCantidad()));

        List<Integer> idMateriales = new ArrayList<>(mapIdMaterialesCant.keySet());
        List<Material> listaMateriales = idMateriales.stream().map( id -> buscarPorId(id)).collect(Collectors.toList());
        List<DetalleProvision> listaDetalles = new ArrayList<>();
        Integer cantidad;

        for(Material m: listaMateriales){
            cantidad = mapIdMaterialesCant.get(m.getId());

            m.setStockActual(m.getStockActual() - cantidad);

            if(m.getStockMinimo() >= m.getStockActual()){
               listaDetalles.add(new DetalleProvision(m,cantidad));
            }
        }
        if(!(listaDetalles.size() == 0)){
            provisionService.crearProvision(listaDetalles);
        }
        materialRepository.saveAll(listaMateriales);
    }

    @Override
    public List<Material> buscarPorPrecio(Double precio) {
        try{
            List<Material> materiales = (List<Material>) materialRepository.findAll();
            List<Material> materialesFiltrados = new ArrayList<Material>();
            materiales.stream().forEach((m) -> {
                if(m.getPrecio() == precio) {
                    materialesFiltrados.add(m);
                }
            });
            return materialesFiltrados;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}