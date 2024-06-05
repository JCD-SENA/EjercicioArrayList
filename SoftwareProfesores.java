package juan.softwareprofesores;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SoftwareProfesores {
    public static void main(String[]args){
        ArrayList<String>listaProfesores=new ArrayList<>();
        ArrayList<String>listEstudiantes;
        ArrayList<ArrayList<String>> ListaGeneralEstudiantes = new ArrayList();
        
        listaProfesores.add("Cristian");
        listaProfesores.add("German");
        listaProfesores.add("Hugo");
        
        for (int i=0; i<listaProfesores.size(); i++){
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes "
            + "para el profesor "+listaProfesores.get(i));
            
            listEstudiantes=new ArrayList<String>();
            int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            for (int j=0; j<cant;j++){
                String nombreEst=JOptionPane.showInputDialog("nombre estudiate "+(j+1));
                listEstudiantes.add(nombreEst);
            }
            ListaGeneralEstudiantes.add(listEstudiantes);
            System.out.print("Profesor "+listaProfesores.get(i)+"=");
            System.out.println(listEstudiantes);
        }
        
        ArrayList<String> listaTemporal;
        for (int i = 0; i < ListaGeneralEstudiantes.size(); i++) {
            listaTemporal=ListaGeneralEstudiantes.get(i);
            System.out.print("Profesor: "+listaProfesores.get(i)+" = ");
            System.out.print("[");
            for (int j = 0; j < listaTemporal.size(); j++) {
                System.out.print(listaTemporal.get(j)+" ");
            }
            System.out.print("]\n");
        }
    } 
}