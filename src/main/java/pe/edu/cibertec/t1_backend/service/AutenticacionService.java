package pe.edu.cibertec.t1_backend.service;

import pe.edu.cibertec.t1_backend.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarVehiculo(LoginRequestDTO loginRequestDTO) throws IOException;

}
