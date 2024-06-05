package juanca.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProfesoresEstudiantes {
    ArrayList<String> listaProfesores;
    ArrayList<String> listEstudiantes;
    ArrayList<ArrayList<String>> listaGeneralEstudiantes; //Se crea una lista de listas, siendo cada sub-lista una lista de estudiantes por profesor
    public ProfesoresEstudiantes () { //Se hace el constructor que define ambas listas
        listaProfesores=new ArrayList<>();
        listaGeneralEstudiantes=new ArrayList<>();
    }
    
    public void iniciar() {
        int opt = 0;
        do {
            //Se crea un menú con las distintas opciones
            opt = Integer.parseInt(JOptionPane.showInputDialog("1. Registrar profesores\n2. Registrar estudiantes\n3. Consultar la lista de profesores y estudiantes\n4. Consultar el profesor por nombre\n5. Consultar la cantidad de estudiantes por profesor\n6. Consultar estudiante por nombre\n7. Terminar.\n"));
            switch (opt) {
                case 1:
                    registrarProfesores();
                    break;
                case 2:
                    registrarEstudiantes();
                    break;
                case 3:
                    consultarListaProfesoresYEstudiantes();
                    break;
                case 4:
                    consultaProfesorPorNombre();
                    break;
                case 5:
                    consultaCantidadEstudiantesPorProfesor();
                    break;
                case 6:
                    consultarEstudiante();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida");
            }
        } while (opt!=7); //Se termina de ejecutar si se entra la opción 7
    }
    
    private void registrarProfesores() {
        System.out.println("\n<<<< Registro de Profesosres >>>>");
        int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad de profresores")); //Se le pide al usuario cuantos instructores se van a añadir
        for (int i = 0; i < cant; i++) { //Se itera por cada uno, se pregunta el nombre y se añade a la lista
            String nombreProfesor=JOptionPane.showInputDialog("nombre profesor"+(i+1));
            if (!listaProfesores.contains(nombreProfesor)) //Antes de añadir, verifica si el instructor no está ya en la lista
                listaProfesores.add(nombreProfesor);
            else
                JOptionPane.showMessageDialog(null, "El profesor ya se encuentra en la lista");
        }
    }
    
    private void registrarEstudiantes() {
        System.out.println("\n<<<< REgistro de Estudiantes >>>>");
        for (int i = 0; i < listaProfesores.size(); i++) { //Se itera por cada instructor y se pregunta cuantos estudiantes se van a ingresar
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes para el profesor "+listaProfesores.get(i));
            listEstudiantes=new ArrayList<String>();
            int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            for (int j = 0; j < cant; j++) { //Se ingresan los distintos estudiantes
                String nombreEst=JOptionPane.showInputDialog("nombre estudiante"+(j+1));
                if (!listEstudiantes.contains(nombreEst)) //Se verifica que la lista no contenga al estudiante.
                    listEstudiantes.add(nombreEst);
                else
                    JOptionPane.showMessageDialog(null, "El estudiante ya se encuentra en la lista");
            }
            listaGeneralEstudiantes.add(listEstudiantes);
        }
        System.out.println("Registro de estudiantes Exitoso!\n");
    }
    
    private void consultarListaProfesoresYEstudiantes() {
        System.out.println("\n<<<< Lista de Profesores y Estudiantes >>>>");
        ArrayList<String> listaTemporal;
        if (listaProfesores.size() > 0) { //Se verifica que hayan profesores
            if (listaGeneralEstudiantes.size() > 0) { //Se verifica que hayan estudiantes
                for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
                    listaTemporal=listaGeneralEstudiantes.get(i);
                    System.out.print("Profesor: "+listaProfesores.get(i)+" = ");
                    System.out.print("[");
                    for (int j = 0; j < listaTemporal.size(); j++) {
                        System.out.print(listaTemporal.get(j));
                        if (j<listaTemporal.size()-1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El profesor "+listaProfesores.get(0)+" no tiene estudiantes, hay que registrar uno primero");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay instructores, hay que registrar uno primero");
        }
    }
    
    private void consultaProfesorPorNombre() {
        System.out.println("\n<<<< Consulta de Profesor >>>>  \n");
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor");
        //Se verifica que existe el profesor con ese nombre
        if (listaProfesores.contains(nombre)) {
            System.out.print("Profesor: "+nombre+" = ");
            int posicion=listaProfesores.indexOf(nombre);
            if (posicion < listaGeneralEstudiantes.size()) { //Se verifica que el instructor tenga su lista de estudiantes
                System.out.print("[");
                ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
                for (int j = 0; j < listaEstudiantesTemporal.size(); j++) {
                    System.out.print(listaEstudiantesTemporal.get(j));
                    if (j<listaEstudiantesTemporal.size()-1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("El profesor no tiene alumnos");
            }
        } else {
            System.out.println("No se encuentra el profesor "+nombre+"\n");
        }
    }
    
    private void consultaCantidadEstudiantesPorProfesor() {
        System.out.println("\n<<<< Consulta cantidad de estudiantes de Profesores >>>>  \n");
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber la cantidad de estudiantes asociados");
        if (listaProfesores.contains(nombre)) { //Se verifica que el profesor exista
            int posicion=listaProfesores.indexOf(nombre);
            if (posicion < listaGeneralEstudiantes.size()) { //Se verifica que el profesor tenga estudiantes
                ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
                System.out.println("La cantidad de estudiantes asociados al profesor "+nombre+" es "+listaEstudiantesTemporal.size());
            } else {
                System.out.println("El profesor "+nombre+" no tiene estudiantes.");
            }
        } else {
            System.out.println("No se encuentra el profesor "+nombre+"\n");
        }
    }
    
    private void consultarEstudiante() {
        System.out.println("\n<<<< Consulta de Estudiante >>>>  \n");
        ArrayList<String> listTemporal;
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");
        if (listEstudiantes.size() > 0) { //Se verifica que hayan estudiantes
            for (int i = 0; i < listaGeneralEstudiantes.size(); i++) { //Se itera por las listas de estudiantes hasta encontar un profesor que contenga tal estudiante.
                listTemporal=listaGeneralEstudiantes.get(i);
                if (listTemporal.contains(nombre)) {
                    for (int j = 0; j < listTemporal.size(); j++) {
                        if (listTemporal.get(j).equalsIgnoreCase(nombre)) {
                            System.out.println("Encuentra al nombre: "+nombre+" pertenece al grupo de "+listaProfesores.get(i));
                        }
                    }
                } else {
                    System.out.println("No se encuentra el nombre en el grupo de "+listaProfesores.get(i));
                }
            }
        } else {
            System.out.println("No hay estudiantes, hay que ingresar uno primero.");
        }
    }
}
