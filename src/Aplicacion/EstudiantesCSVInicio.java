/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Modelo.Alumno;
import Modelo.Cuenta;
import Vista.FrmLogin;
import java.util.ArrayList;

/**
 *
 * @author lenin
 */
public class EstudiantesCSVInicio {
    public static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    public static ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
    public static void main(String[] args) {
        new FrmLogin().setVisible(true);
    }
}
