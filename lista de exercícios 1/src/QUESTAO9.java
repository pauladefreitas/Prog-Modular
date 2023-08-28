import java.util.*;

//questão 9

public class QUESTAO9 {
    
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

        this.dia = Byte.parseByte(partes[0]); 
        this.mes = Byte.parseByte(partes[1]); 
        this.ano = Integer.parseInt(partes[2]);

        if (!validarData()) {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1900; 
        }
    }

    
    /** Este método valida se a data recebida está de acordo com a notação usada: DD/MM/AAAA.
     * @return Verdadeiro caso esteja válido, Falso caso não válido.
     */
    boolean validarData() {
        if ((dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12) && (ano < 9999))
            return true;
        else {
            return false;
        }
    }

    
    /** Este método obtém o dia da semana no ano de 2024 independente do ano no qual o usuário tenha digitado baseando-se no cálculo 
     * de dias passados dentro do mês e do dia base sendo segunda-feira o dia 1. O dia da semana é calculado pelo resto da divisão entre 
     * esses dois valores.
     * @return O dia da semana em formato de String.
     */
    String obterDiaSemana() {
        String[] semana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
        int[] diasMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diaBase = 1; 

        int diasPassados = 0;
        for (int i = 1; i < mes; i++) {
            diasPassados += diasMes[i];
        }
        diasPassados += dia - 1;

        int diaSemana = (diaBase + diasPassados) % 7; 
        return semana[diaSemana];
    }

    
    /** Este método calcula qual data está a frente da outra, sendo usado como base o primeiro objeto criado.
     * @param outraData
     * @return boolean
     */
    boolean estaAFrente(QUESTAO9 outraData) {
        if (this.ano > outraData.ano) {
            return true;
        } else if (this.ano < outraData.ano) {
            return false;
        } else {
            if (this.mes > outraData.mes) {
                return true;
            } else if (this.mes < outraData.mes) {
                return false;
            } else {
                return this.dia > outraData.dia;
            }
        }
    }

    
    /** Este método formata a data para que possa ser utilizada em outros contextos.
     * @return String
     */
    String formatarData() {
        String diaF = String.format("%02d",this.dia); 
        String mesF = String.format("%02d",this.mes); 
        String anoF = String.format("%04d",this.ano); 

        return diaF+"/"+mesF+"/"+anoF;
    }

    public static void main(String[] args) {
        QUESTAO9 dataObj = new QUESTAO9();

        //teste recebimento do primeiro valor de data;
        String dataOriginal = dataObj.receberData();
        String diaSemanaOriginal = dataObj.obterDiaSemana();
        System.out.println("Data original: " + dataOriginal);
        System.out.println("Dia da semana da data original: " + diaSemanaOriginal);

        //teste alteração de data
        String dataAlt = dataObj.receberData();
        dataObj.ajustar(dataAlt);
        String diaSemanaAlterada = dataObj.obterDiaSemana();
        System.out.println("Data alterada: " + dataObj.formatarData());
        System.out.println("Dia da semana da data alterada: " + diaSemanaAlterada);

        //teste comparação de datas
        QUESTAO9 dataObj2 = new QUESTAO9(); 
        dataObj2.receberData(); 

        if (dataObj.estaAFrente(dataObj2)) {
            System.out.println("A data alterada está a frente da terceira data.");
        } else {
            System.out.println("A data três está a frente da data alterada.");
        }
    }
}

