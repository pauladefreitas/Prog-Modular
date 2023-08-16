import java.util.*;

public class QUESTAO2 {

    public static int[] preencheVetor(int[] vetor1, int tamanho) {
        Scanner input = new Scanner(System.in); 
        for (int i = 0; i < tamanho; i++) {
            vetor1[i] = input.nextInt();
        }

        input.close();
        return vetor1;
    }

    public static int[] somaParVizinhos(int[] vetorOriginal) {
        int tamanho = vetorOriginal.length;
        int[] vetorSoma = new int[(tamanho + 1) / 2]; 
        
        for (int i = 0; i < tamanho; i += 2) {
            int soma = vetorOriginal[i];
            if (i + 1 < tamanho) {
                soma += vetorOriginal[i + 1];
            }
            vetorSoma[i / 2] = soma;
        }

        if (tamanho % 2 != 0) {
            vetorSoma[vetorSoma.length - 1] += vetorOriginal[tamanho - 1];  
        }
        
        return vetorSoma;
    }

    public static void imprimirVetor(int[] vetor1) {
        for (int valor : vetor1) {
            System.out.print(valor + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        int tamanho = input.nextInt();
        int[] vetor1 = new int[tamanho]; 

        preencheVetor(vetor1, tamanho);
        int[] novoVetor = somaParVizinhos(vetor1); 
        imprimirVetor(novoVetor); 
        
        input.close();
    }
}
