/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.*;
import ec.edu.ups.vista.*;
import java.util.List;
/**
 *
 * @author tano
 */
public class ControladorUsuario {
    private VistaUsuario vistaUsuario;
    private VistaTelefono vistaTelefono;
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;
    private Usuario usuario;
    private Telefono telefono;

    public ControladorUsuario(VistaUsuario vistaUsuario, VistaTelefono vistaTelefono, IUsuarioDAO iUsuarioDAO, ITelefonoDAO iTelefonoDAO) {
        this.vistaUsuario = vistaUsuario;
        this.vistaTelefono = vistaTelefono;
        this.usuarioDAO = iUsuarioDAO;
        this.telefonoDAO = iTelefonoDAO;
    }
    
    public void registrar(){
        usuario = vistaUsuario.ingresarUsuario();
        usuarioDAO.create(usuario);
    }
    
    public void actualizar(){
        usuario = vistaUsuario.actualizarUsuario();
        usuarioDAO.update(usuario);
        vistaUsuario.verUsuario(usuario);
    }
    
    public void eliminar(){
        usuario = vistaUsuario.eliminarUsuario();
        usuarioDAO.delete(usuario);
    }
    
    public void verUsuario(){
        String cedula = vistaUsuario.buscarUsuario();
        usuario = usuarioDAO.read(cedula);
        vistaUsuario.verUsuario(usuario);
    }
    
    public void verUsuarios(){
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        vistaUsuario.verUsuarios(usuarios);
    }
    
    public void agregarTelefono(Usuario sesion){
        int codigo = vistaTelefono.buscarTelefono();
        telefono = telefonoDAO.read(codigo);
        vistaTelefono.verTelefono(telefono);
        sesion.agregarTelefono(telefono);
        usuarioDAO.update(sesion);
    }
    
    public Usuario iniciarSesion(){
        usuario = vistaUsuario.iniciarSesion();
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        for(Usuario usuario : usuarios){
            if(this.usuario.getCorreo().equals(usuario.getCorreo())){
                if(this.usuario.getContrasenia().equals(usuario.getContrasenia())){
                    return usuario;  
                }else{
                    return null;
                }
            }
        }
        return null;
    }
    
    public void telefonosPorCedula(){
        String cedula = vistaUsuario.buscarUsuario();
        usuario = usuarioDAO.read(cedula);
        List<Telefono> telefonos = usuario.getTelefonos();
        vistaTelefono.verTelefonos(telefonos);
    }
    
    public void telefonosPorCedula(Usuario usuario){
        this.usuario = usuarioDAO.read(usuario.getCedula());
        List<Telefono> telefonos = usuario.getTelefonos();
        vistaTelefono.verTelefonos(telefonos);
    }
}
