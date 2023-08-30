public class DATA {
    
    private byte dia, mes;
    private int ano;
    
    /** Método construtor da classe que separa os valores corretamente entre o dia, mês e ano; e valida se os 
     * valores estão em conformidade com uma data real. 
     * Caso um deles não esteja conforme, reseta os valores para 01/01/1900.
     * @param data
     */
    public void DATA(String data) {
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
    private boolean validarData() {
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
    public String obterDiaSemana() {
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
    public boolean estaAFrente(DATA outraData) {
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
    public String formatarData() {
        String diaF = String.format("%02d",this.dia); 
        String mesF = String.format("%02d",this.mes); 
        String anoF = String.format("%04d",this.ano); 

        return diaF+"/"+mesF+"/"+anoF;
    }

}
