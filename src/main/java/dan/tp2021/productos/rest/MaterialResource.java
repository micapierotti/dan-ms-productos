package dan.tp2021.productos.rest;

import dan.tp2021.productos.domain.Material;
import dan.tp2021.productos.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/productos")
@Api(value = "MaterialResource", description = "Permite gestionar los materiales")
public class MaterialResource {
	@Autowired
    MaterialService materialSrv;

    @PostMapping
    @ApiOperation(value = "Crear un material")
    public ResponseEntity<String> crear(@RequestBody Material nuevoMaterial){

        System.out.println("Crear material "+ nuevoMaterial);

        if(nuevoMaterial.getNombre()==null)
            return ResponseEntity.badRequest().body("El material debe tener un nombre especificado.");
        if(nuevoMaterial.getPrecio()==null)
            return ResponseEntity.badRequest().body("El material debe tener precio especificado.");
        if(nuevoMaterial.getStockActual()==null || nuevoMaterial.getStockMinimo()==null)
            return ResponseEntity.badRequest().body("El material debe tener un stock actual y un stock mínimo.");

        materialSrv.crearMaterial(nuevoMaterial);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @PutMapping(path = "/{idMaterial}")
    @ApiOperation(value = "Actualizar un material")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualizado correctamente"),
        @ApiResponse(code = 401, message = "No autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<Material> actualizar(@RequestBody Material materialActualizado,  @PathVariable Integer idMaterial){
        return ResponseEntity.ok(materialSrv.actualizarMaterial(materialActualizado, idMaterial));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borrar un material según su id")
    public ResponseEntity<Material> borrar(@PathVariable Integer id){
        boolean result = materialSrv.borrarMaterial(id);
        if(result) return ResponseEntity.ok().build();

        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un material según su id")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer id){
    Material m = materialSrv.buscarPorId(id);
        if(m != null)
            return ResponseEntity.ok(m);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping
    @ApiOperation(value = "Devuelve todos los productos")
    public ResponseEntity<List<Material>> buscarTodos(@RequestParam(name="razonSocial", required = false) String razonSocial) {
        List<Material> materiales = materialSrv.buscarTodos();
        if(materiales.size()) return ResponseEntity.ok(clientes);
        return ResponseEntity.notFound().build();
    }
}