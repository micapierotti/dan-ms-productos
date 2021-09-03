package dan.tp2021.productos.services.implementacion;

import dan.tp2021.productos.dto.PedidoDTO;
import dan.tp2021.productos.services.ArtemisService;
import dan.tp2021.productos.services.MaterialService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ArtemisServiceImpl implements ArtemisService {

    private MaterialService materialService;

    public ArtemisServiceImpl(MaterialService materialService) {
        this.materialService = materialService;
    }

    @JmsListener(destination = "someQueue")
    public void recibirMensaje(PedidoDTO pedidoDTO) {
        materialService.registrarMovimientoStock(pedidoDTO);
    }
}
