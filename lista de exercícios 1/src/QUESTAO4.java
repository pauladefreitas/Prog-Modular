import java.util.*;

public class QUESTAO4 {

    public static boolean testaFim(String palavra) {
        boolean teste = false;

        if (palavra.equals("FIM")) {
            teste = true;
        }

        return teste;
    }

    public static void inverter(String palavra) {
        String invertida="";
        int tamanho = palavra.length(); 

        for(int i=tamanho-1; i>=0; i--) {
            invertida += palavra.charAt(i); 
        }

        System.out.print(invertida); 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String palavra = input.next();

        while (testaFim(palavra)) {
            inverter(palavra);
        }

        input.close();
    }
}
