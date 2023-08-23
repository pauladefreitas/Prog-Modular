import java.util.*;

public class QUESTAO8 {
    
    byte dia, mes;
    int ano;
    
    /** Recebe a data digitada pelo usuário e armazena em uma variável no main.
     * @return String data.
     */
    String receberData() {

        Scanner input = new Scanner(System.in); 
        String data = input.next();

        if (data.length() != 10) {
            System.out.print("Data diferente de 10 caracteres.");
        }

        ajustar(data);

        return data;
    }

    
    /** Ajusta a data de maneira que os campos dia, mês e ano sejam devidamente preenchidos e, também, chama o método de validação
     * para ajuste do preenchimento destes campos.
     * Caso um deles não esteja conforme, reseta os valores para 01/01/1900.
     * @param data
     */
    void ajustar(String data) {
        String[] partes = data.split("/"); 
        String resposta;

        this.dia = Byte.parseByte(partes[0]); 
        this.mes = Byte.parseByte(partes[1]); 
        this.ano = Integer.parseInt(partes[2]);

        int maxDia;
        
        if(ano<1900)
            resposta =  "Ano inválido.";
        else{
           if (mes < 1 || mes > 12)                           
                resposta =  "Mês inválido.";
           else { 
                   maxDia = DIASDOMES[mes];
                   if(anoBissexto(ano)&&mes==2)     
                        maxDia++;
                   
                   if (dia > maxDia)                
                        resposta =  "Dia inválido: máximo de "+maxDia+" para o mês "+mes+".";
                }
        }                       
        return resposta;


    }


    
}
