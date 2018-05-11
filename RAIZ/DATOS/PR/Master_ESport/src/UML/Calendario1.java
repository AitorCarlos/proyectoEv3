package UML;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import master_esport.*;

public class Calendario1 {
    private int[] equipos;
    private String[][] matriz1,matriz2,jornadas,jornadas2;
	
    public Calendario1(ArrayList equipos, java.sql.Date fecha){
        
            matriz1 = new String[equipos.size()-1][equipos.size()/2];
            matriz2 = new String[equipos.size()-1][equipos.size()/2];
            jornadas = new String[equipos.size()-1][equipos.size()/2]; 
            jornadas2 = new String[equipos.size()-1][equipos.size()/2];

            int cont = 0;
            int cont2 = equipos.size()-2;

            for(int i=0;i<equipos.size()-1;i++){
                    for(int j=0;j<equipos.size()/2;j++){
                            matriz1[i][j] = String.valueOf(equipos.get(cont));
                            cont++;
                            if(cont==(equipos.size()-1)) cont=0;
                            if(j==0) matriz2[i][j] = String.valueOf(equipos.get(equipos.size()-1));
                            else {
                                    matriz2[i][j] = String.valueOf(equipos.get(cont2));
                                    cont2--;
                                    if(cont2==-1) cont2 = equipos.size()-2;
                            }
                            if(j==0){
                                    if(i%2==0) jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
                                    else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
                            }
                            else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
                            if(j==0){
                                    if(i%2==0) jornadas2[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
                                    else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
                            }
                            else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
                    }
            }
            
            int jorn = 1;
            for(int i=0;i<equipos.size()-1;i++){
                System.out.println("JORNADA "+jorn);
                Master_ESport.insertarJornada(fecha, Master_ESport.sumarDias(fecha, equipos));
                fecha = Master_ESport.sumarDias(fecha, equipos);
                    for(int j=0;j<equipos.size()/2;j++){
                            
                            System.out.print("J"+jorn+" "+jornadas[i][j]); 
                            
                            
                            
                            
                            if(j==(equipos.size()/2)-1) System.out.println();
                    }
                    jorn++;
            }
            
            jorn = equipos.size();
            for(int i=0;i<equipos.size()-1;i++){
                System.out.println("JORNADA "+jorn);
                Master_ESport.insertarJornada(fecha, Master_ESport.sumarDias(fecha, equipos));
                fecha = Master_ESport.sumarDias(fecha, equipos);
                    for(int j=0;j<equipos.size()/2;j++){
                            System.out.print("J"+jorn+" "+jornadas2[i][j]);
                            if(j==(equipos.size()/2)-1) System.out.println();
                    }
                    jorn++;
            }
	}
	
}
