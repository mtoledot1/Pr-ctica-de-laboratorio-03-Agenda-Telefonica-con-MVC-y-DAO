/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tano
 */
public class UsuarioDAO implements IUsuarioDAO{

    private Map<Integer,Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new HashMap<>();
    }

    @Override
    public void create(Usuario usuario) {
        usuarios.put(usuario.hashCode(), usuario);
    }

    @Override
    public Usuario read(String cedula) {
        Usuario usuario = new Usuario(cedula, null, null, null, null);
        if(usuarios.containsKey(usuario.hashCode())){
            return usuarios.get(usuario.hashCode());
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        if(usuarios.containsKey(usuario.hashCode())){
            usuarios.replace(usuario.hashCode(), usuario);
        }
    }

    @Override
    public void delete(Usuario usuario) {
        if(usuarios.containsKey(usuario.hashCode())){
            usuarios.remove(usuario.hashCode());
        }
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList(usuarios.values());
    }
    
}
