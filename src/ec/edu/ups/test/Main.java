/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import java.util.Scanner;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.controlador.*;
import ec.edu.ups.dao.*;
import ec.edu.ups.vista.*;
import ec.edu.ups.idao.*;

/**
 *
 * @author tano
 */
public class Main {
    
    //scanner
    Scanner leer = new Scanner(System.in);
    //vistas
    VistaUsuario vistaUsuario = new VistaUsuario();
    VistaTelefono vistaTelefono = new VistaTelefono();
    //daos
    IUsuarioDAO usuarioDAO = new UsuarioDAO();
    ITelefonoDAO telefonoDAO = new TelefonoDAO();
    //controladores
    ControladorUsuario controladorUsuario = new ControladorUsuario(vistaUsuario, vistaTelefono, usuarioDAO, telefonoDAO);
    ControladorTelefono controladorTelefono = new ControladorTelefono(vistaTelefono, telefonoDAO);
    //sesión
    Usuario sesion;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
    }
    
    public Main(){
        int opc = 0;
        do{
            if(sesion != null){
                opc = menuSesionIniciada();
            }else{
                opc = menuNormal();
            }
            switch(opc){
                case 1:
                    //inicio de sesión
                    iniciarSesion();
                    break;
                case 2:
                    //Registro de usuarios
                    controladorUsuario.registrar();
                    break;
                case 3:
                    //modificar usuario
                    controladorUsuario.actualizar();
                    break;
                case 4:
                    //eliminar usuarios
                    controladorUsuario.eliminar();
                    break;
                case 5:
                    //buscar usuarios
                    controladorUsuario.verUsuario();
                    break;
                case 6:
                    //Listar usuarios
                    controladorUsuario.verUsuarios();
                    break;
                case 7:
                    //registro de teléfono
                    controladorTelefono.registrar();
                    break;
                case 8:
                    //modificar teléfono
                    controladorTelefono.actualizar();
                    break;
                case 9:
                    //elminar teléfono
                    controladorTelefono.eliminar();
                    break;
                case 10:
                    //buscar teléfono
                    controladorTelefono.verTelefono();
                    break;
                case 11:
                    //listar teléfonos de la sesión
                    controladorTelefono.verTelefonos();
                    break;
                case 12:
                    //listar teléfonos mediante la cédula
                    break;
                case 13:
                    //listar todos los teléfonos
                    controladorTelefono.verTelefonos();
                    break;
                case 14:
                    //cambiar de usuario
                    iniciarSesion();
                    break;
                case 15:
                    //cerrar sesión
                    sesion = null;
                    break;
            }
        }while(opc != 16);
    }
    
    public int menuSesionIniciada(){
        int opc = 0;
        do{
            System.out.println("----MENU----");
            System.out.println("1) Registrar Usuario");
            System.out.println("2) Modificar Usuario");
            System.out.println("3) Eliminar Usuario");
            System.out.println("4) Buscar Usuario");
            System.out.println("5) Listar Todos los Usuarios registrados");
            System.out.println("6) Registrar Teléfono");
            System.out.println("7) Modificar Teléfono");
            System.out.println("8) Eliminar Teléfono");
            System.out.println("9) Buscar Teléfono");
            System.out.println("10) Listar Teléfonos del Usuario");
            System.out.println("11) Listar Teléfonos de un Usuario mediante la cédula");
            System.out.println("12) Listar Todos los Teléfonos registrados");
            System.out.println("13) Cambiar de Usuario");
            System.out.println("14) Cerrar Sesión");
            System.out.println("15) Cerrar programa");
            opc = leer.nextInt();
            leer.nextLine();
            if(opc < 1 || opc > 15){
                System.out.println("Ingrese una opcion correcta");
            }
        }while(opc < 1 || opc > 15);
        opc++;
        return opc;
    }
    
    public int menuNormal(){
        int opc = 0;
        do{
            System.out.println("----MENU----");
            System.out.println("1) Iniciar Sesion");
            System.out.println("2) Registrar Usuario");
            System.out.println("3) Modificar Usuario");
            System.out.println("4) Eliminar Usuario");
            System.out.println("5) Buscar Usuario");
            System.out.println("6) Listar Todos los Usuarios registrados");
            System.out.println("7) Registrar Teléfono");
            System.out.println("8) Modificar Teléfono");
            System.out.println("9) Eliminar Teléfono");
            System.out.println("10) Buscar Teléfono");
            System.out.println("11) Listar Teléfonos de un Usuario mediante la cédula");
            System.out.println("12) Listar Todos los Teléfonos registrados");
            System.out.println("13) Cerrar programa");
            opc = leer.nextInt();
            leer.nextLine();
            if(opc < 1 || opc > 13){
                System.out.println("Ingrese una opcion correcta");
            }
        }while(opc < 1 || opc > 13);
        if(opc == 11){
            return 12;
        }else if(opc == 12){
            return 13;
        }else if(opc == 13){
            return 15;
        }
        return opc;
    }
    
    public void iniciarSesion(){
        sesion = controladorUsuario.iniciarSesion();
        if(sesion == null){
            System.out.println("Usuario o contraseña incorrectos");
        }
    }
}
