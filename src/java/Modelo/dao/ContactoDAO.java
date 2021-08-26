/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dto.ContactoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edwin Sandoval
 */
public class ContactoDAO {

    private  List<ContactoDTO> listaComentarios = new ArrayList<ContactoDTO>();

    public ContactoDAO() {
    }

    public List<ContactoDTO> readAll() {
        List<ContactoDTO> lista = new ArrayList<ContactoDTO>();
        lista=listaComentarios;
        return listaComentarios;
    }

    public boolean crear(ContactoDTO comentario) {
        if (comentario != null) {
            listaComentarios.add(comentario);
            return true;
        }
        return false;
    }

}
