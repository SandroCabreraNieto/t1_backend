package pe.edu.cibertec.t1_backend.service;

import pe.edu.cibertec.t1_backend.dto.BuscarRequestDTO;

import java.io.IOException;

public interface BusquedaService {

    String[] validarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException;

}
