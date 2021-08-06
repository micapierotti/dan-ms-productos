package dan.tp2021.productos.services.implementacion;

import dan.tp2021.productos.database.MaterialRepository;
import dan.tp2021.productos.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public Material crearMaterial(Material m) {
        this.materialRepository.save(m);
        return m.getId();
    }

    @Override
    public boolean borrarMaterial(Integer id) {
        Material m = buscarPorId(id);

        if(m != null){
            materialRepository.delete(m);
            if (materialRepository.findById(id).isPresent()) return false;
            return true;
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
    public List<Material> buscarTodos() {
        try{
            return materialRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}