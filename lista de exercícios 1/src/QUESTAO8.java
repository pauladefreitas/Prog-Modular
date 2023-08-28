import java.util.*;

public class QUESTAO8 {
    
    byte dia, mes;
    int ano;
    static final int[] DIASDOMES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    String receberData() {
        Scanner input = new Scanner(System.in); 
        String data = input.next();

        if (data.length() != 10) {
            return "Data diferente de 10 caracteres.";
        }

        return ajustar(data);
    }

    String ajustar(String data) {
        String[] partes = data.split("/"); 

        this.dia = Byte.parseByte(partes[0]); 
        this.mes = Byte.parseByte(partes[1]); 
        this.ano = Integer.parseInt(partes[2]);

        int maxDia;

        if (ano < 1900)
            return "Ano inválido.";
        else {
            if (mes < 1 || mes > 12)
                return "Mês inválido.";
            else {
                maxDia = DIASDOMES[mes];
                if (anoBissexto(ano) && mes == 2)
                    maxDia++;

                if (dia > maxDia)
                    return "Dia inválido: máximo de " + maxDia + " para o mês " + mes + ".";
            }
        }

        return "Data válida.";
    }

    boolean anoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public static void main(String[] args) {
        QUESTAO8 validarData = new QUESTAO8();

        System.out.println("Digite uma data no formato dd/mm/aaaa:");
        String data = validarData.receberData();

        String resposta = validarData.ajustar(data);
        System.out.println(resposta);
    }
}
