import java.io.*;
import java.util.*;

public class QUESTAO10 {

    public static int[] preencheVetor(int[] vetor1, String linha) {
        String[] valores = linha.split(";");
        for (int i = 0; i < valores.length; i++) {
            vetor1[i] = Integer.parseInt(valores[i]);
        }
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
        Scanner input = null;
        try {
            File file = new File("input.txt");
            input = new Scanner(file);

            while (input.hasNextLine()) {
                String linha = input.nextLine();
                int tamanho = linha.split(";").length;
                int[] vetor1 = new int[tamanho];

                preencheVetor(vetor1, linha);
                int[] novoVetor = somaParVizinhos(vetor1);
                imprimirVetor(novoVetor);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
