import java.util.*;

public class QUESTAO5 {

    static void calculaEstudo(String tempoEstudo) {
        String[] partes = tempoEstudo.split(" "); 
        int materias = Integer.parseInt(partes[0]);
    
        String[] divHM = partes[1].split(":"); 
        int hora = Integer.parseInt(divHM[0]); 
        int minuto = Integer.parseInt(divHM[1]);
    
        int totalMinutos = (hora * 60) + minuto;
        int totalStudyTime = totalMinutos / materias;
    
        int totalBreaks = materias - 1;
        int breakTimePerBreak = (totalMinutos - totalStudyTime) / totalBreaks;
    
        System.out.print("O tempo de estudo é " + totalStudyTime + " com " + breakTimePerBreak + " de descanso.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        String tempoEstudo = input.nextLine(); 

        calculaEstudo(tempoEstudo); 
    }
}
