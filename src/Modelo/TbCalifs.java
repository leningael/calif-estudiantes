/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Aplicacion.EstudiantesCSVInicio.listaAlumnos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenin
 */
public class TbCalifs {
    public void inicializaTabla(JTable tabla){
        lecturaAlumnos();
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        titulos.add("Matrícula");
        titulos.add("Nombre completo");
        titulos.add("Asignatura");
        titulos.add("Calificación");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Vector<Object> row  = new Vector<Object>();
            row.add(listaAlumnos.get(i).getMatricula());
            row.add(listaAlumnos.get(i).getNombres()+" "+listaAlumnos.get(i).getApellidoPaterno()+" "+listaAlumnos.get(i).getApellidoMaterno());
            row.add(listaAlumnos.get(i).getAsignatura());
            data.add(row);
        }
        DefaultTableModel modelo = new DefaultTableModel(data, titulos);
        tabla.setModel(modelo);
    }
    public void lecturaAlumnos(){
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(jfc);
        try{
            String ruta = jfc.getSelectedFile().getAbsolutePath();
            File CSV = new File(ruta);
            Scanner scArchivo = new Scanner(CSV);
            while (scArchivo.hasNextLine()) {
                String datosAlumno = scArchivo.nextLine();
                Scanner scDatos = new Scanner(datosAlumno);
                scDatos.useDelimiter("\\s*,\\s*");
                String matricula = scDatos.next();
                String apellidoPaterno = scDatos.next();
                String apellidoMaterno = scDatos.next();
                String nombres = scDatos.next();
                Alumno alumno = new Alumno(matricula, apellidoPaterno, apellidoMaterno, nombres);
                listaAlumnos.add(alumno);
            }
            scArchivo.close();
        }catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
