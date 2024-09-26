package pe.edu.cibertec.t1_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.t1_backend.service.BusquedaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BusquedaServiceImpl implements BusquedaService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException {
        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                // Compara la placa con la entrada
                if (buscarRequestDTO.placa().equals(datos[1])) {
                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[2]; //Recuperar Marca
                    datosVehiculo[1] = datos[3]; //Recuperar Modelo
                    datosVehiculo[2] = datos[4]; //Recuperar Nro asientos
                    datosVehiculo[3] = datos[5]; //Recuperar Precio
                    datosVehiculo[4] = datos[6]; //Recuperar Color

                    break;
                }
            }
        } catch (IOException e) {
            datosVehiculo = null;
            throw new IOException(e);
        }

        return datosVehiculo;
    }
}
