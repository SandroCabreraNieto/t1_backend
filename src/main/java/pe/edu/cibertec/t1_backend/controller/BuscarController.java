package pe.edu.cibertec.t1_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t1_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.t1_backend.dto.BuscarResponseDTO;
import pe.edu.cibertec.t1_backend.service.BusquedaService;

@RestController
@RequestMapping("/validacion")
public class BuscarController {

    @Autowired
    BusquedaService busquedaService;

    @PostMapping("/busqueda")
    public BuscarResponseDTO busqueda(@RequestBody BuscarRequestDTO buscarRequestDTO) {
        try {
            String[] datosVehiculo = busquedaService.validarVehiculo(buscarRequestDTO);
            if (datosVehiculo == null) {
                return new BuscarResponseDTO("01", "Error: Vehículo no encontrado", "", "", "", "","");
            }
            return new BuscarResponseDTO("00", "", datosVehiculo[0], datosVehiculo[1], datosVehiculo[2], datosVehiculo[3], datosVehiculo[4]);

        } catch (Exception e) {
            return new BuscarResponseDTO("99", "Error: Ocurrió un problema", "", "", "", "","");
        }
    }
}

