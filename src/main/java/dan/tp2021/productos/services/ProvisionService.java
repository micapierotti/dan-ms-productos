package dan.tp2021.productos.services;

import dan.tp2021.productos.database.ProvisionRepository;
import dan.tp2021.productos.domain.DetalleProvision;

import java.util.List;

public interface ProvisionService {
    public void crearProvision(List<DetalleProvision> listaProvisiones);

}
