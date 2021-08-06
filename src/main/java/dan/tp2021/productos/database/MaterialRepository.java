package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material, Integer>{

}
