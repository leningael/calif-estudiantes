package Aplicacion;

import Modelo.Alumno;
import Modelo.Cuenta;
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        try {
            do{
                int ingresa = -1;
                System.out.println("Bienvenido, ingrese una opción\n1. Registrarse\n2. Iniciar sesión\n3. Salir");
                op = sc.nextInt();
                sc.nextLine();
                if(op == 1){
                    System.out.println("Ingrese la clave para poder registrar una cuenta:");
                    String clave = sc.nextLine();
                    if(clave.equals("registro2020")){
                        FileWriter registroCSV = new FileWriter("src\\login.csv", true);
                        PrintWriter escribir = new PrintWriter(registroCSV);
                        System.out.println("Ingrese el usuario");
                        String usuario = sc.nextLine();
                        System.out.println("Ingrese la contraseña");
                        String password = sc.nextLine();
                        char encriptar[] = password.toCharArray();
                        for(int i = 0; i < encriptar.length; i++) {
                            if ((int) encriptar[i] % 2 == 0)
                                encriptar[i] = (char) (encriptar[i] - (char) 2);
                            if ((int) encriptar[i] % 2 == 1)
                                encriptar[i] = (char) (encriptar[i] + (char) 2);
                        }
                        password = String.valueOf(encriptar);
                        escribir.println(usuario + "," + password);
                        registroCSV.close();
                    }else
                        System.out.println("Clave incorrecta");
                }
                if(op==2){
                    ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
                    File login = new File("src\\login.csv");
                    //LOGIN
                    Scanner scLogin = new Scanner(login);
                    while (scLogin.hasNextLine()) {
                        String datosCuenta = scLogin.nextLine();
                        Scanner scDatos = new Scanner(datosCuenta);
                        scDatos.useDelimiter("\\s*,\\s*");
                        String usuario = scDatos.next();
                        String password = scDatos.next();
                        char desencriptar[] = password.toCharArray();
                        for(int i = 0; i < desencriptar.length; i++){
                            if ((int) desencriptar[i] % 2 == 0)
                                desencriptar[i] = (char) (desencriptar[i] + (char) 2);
                            if ((int) desencriptar[i] % 2 == 1)
                                desencriptar[i] = (char) (desencriptar[i] - (char) 2);
                        }
                        password = String.valueOf(desencriptar);
                        //System.out.println("Contraseña: " + password);
                        Cuenta cuenta = new Cuenta(usuario, password);
                        listaCuentas.add(cuenta);
                    }
                    System.out.println("Ingrese el usuario:");
                    String usuario = sc.nextLine();
                    System.out.println("Ingrese la contraseña:");
                    String password = sc.nextLine();
                    for (int i = 0; i < listaCuentas.size(); i++) {
                        if (usuario.equals(listaCuentas.get(i).getUsuario()) && password.equals(listaCuentas.get(i).getPassword()))
                            ingresa = i;
                    }
                    if (ingresa == -1)
                        System.out.println("Usuario o contraseña incorrectos");
                    else {
                        System.out.println("Se ha iniciado sesión con éxito");
                        scLogin.close();
                        //Lista alumnos
                        int calif;
                        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
                        File CSV = new File("src\\lista.csv");
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
                        for (int i = 0; i < listaAlumnos.size(); i++) {
                                System.out.println("¿Desea ingresar la calificación del alumno con matricula " + listaAlumnos.get(i).getMatricula() + "?");
                                System.out.println("1. Si, 2. No");
                                op = sc.nextInt();
                                if(op==1) {
                                    do {
                                        System.out.println("Ingrese la calificación: ");
                                        calif = sc.nextInt();
                                    } while (calif < 0 || calif > 100);
                                    listaAlumnos.get(i).setCalif(calif);
                                }else if(op==2)
                                    listaAlumnos.get(i).setCalif(-1);
                        }
                        System.out.println("¿Desea generar un archivo CSV de las calificaciones?\n1. Si, 2. No");
                        op = sc.nextInt();
                        if (op == 1) {
                            FileWriter nuevoCSV = new FileWriter("src\\califs.csv");
                            PrintWriter escribir = new PrintWriter(nuevoCSV);
                            for (int i = 0; i < listaAlumnos.size(); i++){
                                if(listaAlumnos.get(i).getCalif()==-1)
                                    escribir.println(listaAlumnos.get(i).getMatricula() + "," + "Diseño de Software" + "," + "S/C");
                                else
                                    escribir.println(listaAlumnos.get(i).getMatricula() + "," + "Diseño de Software" + "," + listaAlumnos.get(i).getCalif());
                            }
                            nuevoCSV.close();
                        }
                        System.out.println("¿Desea generar un archivo PDF de las calificaciones?\n1. Si, 2. No");
                        op = sc.nextInt();
                        int coords = 125;
                        if (op == 1) {
                            PDFDocument pdf = new PDFDocument();
                            PDFPage pagina = pdf.createPage(new PageFormat());
                            Graphics2D graphics2D = pagina.createGraphics();
                            //BufferedImage logo = ImageIO.read(new File("src\\img\\LogoUady.png"));
                            //graphics2D.drawImage(logo, 0, 0, null);
                            graphics2D.drawString("Calificaciones de los alumnossss:", 100, 100);
                            graphics2D.drawString("Matricula || Nombre Completo || Calificación", 100, 125);
                            for (int i = 0; i < listaAlumnos.size(); i++){
                                coords+=25;
                                if(listaAlumnos.get(i).getCalif()==-1)
                                    graphics2D.drawString(listaAlumnos.get(i).getMatricula() + "," + listaAlumnos.get(i).getNombres() + " " +
                                            listaAlumnos.get(i).getApellidoPaterno() + " " + listaAlumnos.get(i).getApellidoMaterno() + "," + "S/C",100,coords);
                                else
                                    graphics2D.drawString(listaAlumnos.get(i).getMatricula() + "," + listaAlumnos.get(i).getNombres() + " " +
                                            listaAlumnos.get(i).getApellidoPaterno() + " " + listaAlumnos.get(i).getApellidoMaterno() + "," + listaAlumnos.get(i).getCalif(),100,coords);
                            }
                            pdf.addPage(pagina);
                            pdf.saveDocument("calificaciones.pdf");
                        }
                        scArchivo.close();
                    }
                }
                System.out.println("\n\n");
            }while(op!=3);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (InputMismatchException e3) {
            System.out.println("Debe ingresar un número entero");
        }
    }
}
