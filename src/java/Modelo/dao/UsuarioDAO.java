/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edwin Sandoval
 */
public class UsuarioDAO {

    private List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();

    public UsuarioDAO() {

    }

    public List<UsuarioDTO> readAll() {
        List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
        lista = listaUsuarios;
        return listaUsuarios;
    }

    public boolean crear(UsuarioDTO usuario) {
        if (usuario != null) {
            listaUsuarios.add(usuario);
            return true;
        }
        return false;
    }

    public void datosPrueba() {
        UsuarioDTO Admindto = new UsuarioDTO(1, "Paula", "Paula@gmail.com", "123", UsuarioDTO.ADMINISTRADOR);
        UsuarioDTO Clientedto = new UsuarioDTO(1, "Kevin", "kevin@gmail.com", "123", UsuarioDTO.CLIENTE);
        UsuarioDTO Vendedordto = new UsuarioDTO(1, "Juanes", "juanes@gmail.com", "123", UsuarioDTO.VENDEDOR);
        crear(Admindto);
        crear(Clientedto);
        crear(Vendedordto);

    }
}
