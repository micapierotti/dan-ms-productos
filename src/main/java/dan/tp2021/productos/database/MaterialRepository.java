package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {

   //@Query(value="select m from Material m where m.nombre = ?1", nativeQuery = true)
    public Material findByNombre(String name);
}
