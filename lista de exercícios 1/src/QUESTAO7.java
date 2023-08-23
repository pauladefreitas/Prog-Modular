import java.util.*;

public class QUESTAO7 {
    int numero; 

    void leituraValores() {
        Scanner input = new Scanner(System.in);
        this.numero = input.nextInt();

        input.close();
    }

    int calculo11() {
        int resultado, esq, dir, meio;
        esq = numero/10;
        dir = numero%10; 
        meio = (esq+dir);

        if (meio>9) {
            meio-=10;
            esq++;
        }

        resultado = (esq*100) + (meio*10) + dir;

        return resultado;
    }

    public static void main(String[] args) {
        QUESTAO7 teste = new QUESTAO7(); 
        teste.leituraValores();

        System.out.println(teste.calculo11());
        
    }
}
