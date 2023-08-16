import java.util.*;

public class QUESTAO3 {
    public static void primeiraLinha (int numX) {
        
        for (int i=0; i<numX; i++) {
            System.out.print("X"); 
        }
        System.out.println("");
    }

    public static void segundaLinha (int numX) {
    
        for (int j=0; j<numX-2; j++) {
            System.out.print("X"); 
            for (int i=0; i<numX-2; i++) {
                System.out.print(" "); 
            }
            System.out.println("X"); 
        }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numX = input.nextInt(); //recebe quantos Xs tem na linha;
        
        primeiraLinha(numX);
        segundaLinha(numX);
        primeiraLinha(numX);

        input.close();
    }
}
