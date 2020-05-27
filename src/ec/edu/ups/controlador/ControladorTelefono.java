/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.List;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;

/**
 *
 * @author tano
 */
public class ControladorTelefono {
    
    private VistaTelefono vistaTelefono;
    private ITelefonoDAO telefonoDAO;
    private Telefono telefono;
    private ControladorUsuario controladorUsuario;

    public ControladorTelefono(VistaTelefono vistaTelefono, ITelefonoDAO telefonoDAO, ControladorUsuario controladorUsuario) {
	this.vistaTelefono = vistaTelefono;
	this.telefonoDAO = telefonoDAO;
	this.controladorUsuario = controladorUsuario;
    }
    
    public void registrar(){
	telefono = vistaTelefono.ingresarTelefono();
	telefonoDAO.create(telefono);
	vistaTelefono.verTelefono(telefono);
	controladorUsuario.agregarTelefono(telefono);
    }
    
    public void actualizar(){
        telefono = vistaTelefono.actualizarTelefono();
        telefonoDAO.update(telefono);
        vistaTelefono.verTelefono(telefono);
        controladorUsuario.actualizarTelefono(telefono);
    }
    
    public void eliminar(){
        telefono = vistaTelefono.eliminarTelefono();
        telefonoDAO.delete(telefono);
        controladorUsuario.eliminarTelefono(telefono);
    }
    
    public void verTelefono(){
        int codigo = vistaTelefono.buscarTelefono();
        telefono = telefonoDAO.read(codigo);
        vistaTelefono.verTelefono(telefono);
    }
    
    public void verTelefonos(){
        List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();
        vistaTelefono.verTelefonos(telefonos);
    } 
    
}
