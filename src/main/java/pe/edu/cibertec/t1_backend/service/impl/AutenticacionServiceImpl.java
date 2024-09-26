package pe.edu.cibertec.t1_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.t1_backend.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarVehiculo(LoginRequestDTO loginRequestDTO) throws IOException {
        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            //Ocurre algo aqui
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                if (loginRequestDTO.placa().equals(datos[1])) {

                    datosVehiculo = new String[4];
                    datosVehiculo[0] = datos[3]; //recuperar Marca
                    datosVehiculo[1] = datos[4]; //recuperar modelo
                    datosVehiculo[2] = datos[5]; //recuperar Nro de asientos
                    datosVehiculo[3] = datos[6];
                    //recuperar precio


                    break;

                }
            }

        } catch (IOException e){
            datosVehiculo = null;
            throw new IOException(e);
        }


        return datosVehiculo;
    }
}
