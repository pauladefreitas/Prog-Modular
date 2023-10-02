import java.time.LocalTime;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        // Criando o clube com capacidade para 10 frequentadores
        Clube clube = new Clube(10);

        // Criando alguns frequentadores (sócios e convidados)
        Socio socio1 = new Socio("João", "S1", 101);
        Socio socio2 = new Socio("Maria", "S2", 102);
        Convidado convidado1 = new Convidado("Pedro", "C1", socio1);
        Convidado convidado2 = new Convidado("Laura", "C2", socio1);

        // Adicionando os frequentadores ao clube
        clube.addFrequentador(socio1);
        clube.addFrequentador(socio2);
        clube.addFrequentador(convidado1);
        clube.addFrequentador(convidado2);

        // Registrando visitas
        clube.registrarVisita("S1", new Date(), LocalTime.of(10, 0));
        clube.registrarVisita("S2", new Date(), LocalTime.of(11, 30));
        clube.registrarVisita("C1", new Date(), LocalTime.of(12, 0));
        clube.registrarVisita("C2", new Date(), LocalTime.of(9, 0));

        // Emitindo convites
        socio1.emitirConvite(convidado2, new Date());
        socio1.emitirConvite(convidado2, new Date()); // Além do limite (deve mostrar mensagem)

        // Registrando saída
        clube.registrarSaida("S1", new Date(), LocalTime.of(13, 0));
        clube.registrarSaida("S2", new Date(), LocalTime.of(14, 0));
        clube.registrarSaida("C1", new Date(), LocalTime.of(15, 0));
        clube.registrarSaida("C2", new Date(), LocalTime.of(16, 0));

        // Gerando relatórios
        Date dataConsulta = new Date(); // Assume que a consulta é feita no dia atual
        System.out.println("Relatório de visitas em uma data específica:");
        System.out.println(clube.relatorioVisitasData(dataConsulta));

        System.out.println("Relatórios de visitas de frequentadores:");
        System.out.println(clube.relatorioVisitasFreq("S1"));
        System.out.println(clube.relatorioVisitasFreq("C1"));

        // Quantidade de visitas de convidados de um sócio
        int qtdVisitasConvidadosSocio1 = clube.getQtdVisitasConvidados(socio1);
        System.out.println("Quantidade de visitas de convidados do Socio1: " + qtdVisitasConvidadosSocio1);
    }
}
