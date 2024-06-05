package juan.softwareprofesores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
//Se define la clase
public class SoftwareProfesores {
    public static void main(String[]args){
        ArrayList<String>listaProfesores=new ArrayList<>(); //Se crea la lista de profesores
        ArrayList<String>listEstudiantes; //Se crea la lista de estudiantes
        ArrayList<ArrayList<String>> ListaGeneralEstudiantes = new ArrayList(); //Se crea la lista general la cual contiene una lista de estudiantes por profesor
        
        listaProfesores.add("Cristian");
        listaProfesores.add("German");
        listaProfesores.add("Hugo");

        //Se crea un ciclo en el cual se pide que se ingrese los nombres de los estudiantes
        for (int i=0; i<listaProfesores.size(); i++){
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes "
            + "para el profesor "+listaProfesores.get(i));
            
            listEstudiantes=new ArrayList<String>();
            int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            for (int j=0; j<cant;j++){ //Se itera por cada estudiante a añadir
                String nombreEst=JOptionPane.showInputDialog("nombre estudiate "+(j+1)); //Se pregunta por el nombre del estudiante en la posición 
                listEstudiantes.add(nombreEst);
            }
            ListaGeneralEstudiantes.add(listEstudiantes);
            System.out.print("Profesor "+listaProfesores.get(i)+"=");
            System.out.println(listEstudiantes);
        }

        //Se crea una pequeña lista con los estudiantes de cada profesor
        ArrayList<String> listaTemporal;
        for (int i = 0; i < ListaGeneralEstudiantes.size(); i++) { //Se itera por cada profesor
            listaTemporal=ListaGeneralEstudiantes.get(i);
            System.out.print("Profesor: "+listaProfesores.get(i)+" = ");
            System.out.print("[");
            for (int j = 0; j < listaTemporal.size(); j++) { //Se itera por cada estudiante de ese instructor
                System.out.print(listaTemporal.get(j)+" ");
            }
            System.out.print("]\n");
        }
    } 
}
