import java.util.*;

public class QUESTAO1 {
    public static final int tamanho = 6; // Declaração de constantes

    public static int[] inverter(int[] vetor1) {
        int tamanho = vetor1.length;
        
        for (int i = 0; i < tamanho / 2; i++) {
            int oposto = tamanho - i - 1;
            int temp = vetor1[i]; // Armazena temporariamente o valor atual
            vetor1[i] = vetor1[oposto]; // Substitui o valor atual pelo valor oposto
            vetor1[oposto] = temp; // Coloca o valor temporário na posição oposta
        }

        return vetor1;
    }

    public static int[] preencheVetor(int[] vetor1) {
        Scanner input = new Scanner(System.in); 
        for (int i = 0; i < tamanho; i++) {
            vetor1[i] = input.nextInt();
        }
        
        input.close();
        return vetor1;
    }

    public static void imprimirVetor(int[] vetor1) {
        for (int valor : vetor1) {
            System.out.print(valor + " ");
        }
    }

    public static void main(String[] args) {
        int[] vetor1 = new int[tamanho]; 
        preencheVetor(vetor1);

        inverter(vetor1); 

        System.out.print("Vetor invertido: ");
        imprimirVetor(vetor1);
    }
}
