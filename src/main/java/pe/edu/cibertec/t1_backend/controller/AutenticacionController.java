package pe.edu.cibertec.t1_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t1_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.t1_backend.dto.LoginResponseDTO;
import pe.edu.cibertec.t1_backend.service.AutenticacionService;

import java.time.Duration;
import java.util.Arrays;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {

        try {
            /*Thread.sleep(Duration.ofSeconds(4));*/
            String[] datosVehiculo = autenticacionService.validarVehiculo(loginRequestDTO);
            /*System.out.println("Resultado: " + Arrays.toString(datosVehiculo));*/
            if (datosVehiculo == null){
                return new LoginResponseDTO("01", "Error: Vehiculo no encontrado","","","", "");
            }
            return new LoginResponseDTO("00", "",datosVehiculo[0], datosVehiculo[1], datosVehiculo[2], datosVehiculo[3]);

        } catch (Exception e) {
            return new LoginResponseDTO("99", "Error: Ocurrio un problema","", "","", "");

        }


    }

}

