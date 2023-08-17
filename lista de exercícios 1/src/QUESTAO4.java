import java.util.*;

public class QUESTAO4 {

    public static boolean testaFim(String palavra) { //função booleana que testa se a palavra FIM foi digitada;
        return palavra.equals("FIM");                //caso palavra.equals for verdadeiro, retornará true.
    }

    public static void inverter(String palavra) {    //método (sem retorno) que imprimirá o resultado da inversão da palavra
        String invertida = "";
        int tamanho = palavra.length(); 

        for(int i = tamanho - 1; i >= 0; i--) {
            invertida += palavra.charAt(i);          
        }

        System.out.println(invertida); 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String palavra = input.next();

        while (!testaFim(palavra)) {               //estrutura de repetição para continuar a leitura dos dados lidos pelo teclado enquanto a condição for FALSE
            inverter(palavra);
            palavra = input.next();
        }

        input.close();
    }
}


