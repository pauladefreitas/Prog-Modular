import java.util.*; 

public class QUESTAO6 {

    int premio1, premio2;

    void leituraValores() {
        Scanner input = new Scanner(System.in);
        this.premio1 = input.nextInt(); 
        this.premio2 = input.nextInt(); 

        input.close();
    }

    int numPremio() {
        int valorPremio; 
        premio1%=1000;
        premio2/=100; 

        valorPremio = (premio2*1000)+premio1;

        return valorPremio; 
    }

    public static void main(String[] args) {
        
        QUESTAO6 teste = new QUESTAO6();
        teste.leituraValores();
        System.out.println(teste.numPremio());
        
    }
}