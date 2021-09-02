package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {

}
