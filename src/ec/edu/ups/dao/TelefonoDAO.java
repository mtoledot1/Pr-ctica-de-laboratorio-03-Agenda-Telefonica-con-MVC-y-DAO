/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.idao.ITelefonoDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tano
 */
public class TelefonoDAO implements ITelefonoDAO{
    
    private Map<Integer,Telefono> telefonos;

    public TelefonoDAO() {
        telefonos = new HashMap<>();
    }

    @Override
    public void create(Telefono telefono) {
        telefonos.put(telefono.hashCode(), telefono);
    }

    @Override
    public Telefono read(int codigo) {
        Telefono telefono = new Telefono(codigo, null, null, null);
        if(telefonos.containsKey(telefono.hashCode())){
            return telefonos.get(telefono.hashCode());
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        if(telefonos.containsKey(telefono.hashCode())){
            telefonos.replace(telefono.hashCode(), telefono);
        }
    }

    @Override
    public void delete(Telefono telefono) {
        if(telefonos.containsKey(telefono.hashCode())){
            telefonos.remove(telefono.hashCode());
        }
    }

    @Override
    public List<Telefono> findAll() {
        return new ArrayList(telefonos.values());
    }
    
}
