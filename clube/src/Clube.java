import java.time.LocalTime;
import java.util.*;

/**
 * Representa um clube que registra as visitas dos frequentadores.
 */
public class Clube {

    private Frequentador[] frequentadores;
    private int quantFreq;

    /**
     * Cria um objeto Clube com a capacidade especificada.
     *
     * @param n A capacidade máxima de frequentadores no clube.
     */

    public Clube(int n) {
        if (n <= 2) {
            n = 2;
        }

        frequentadores = new Frequentador[n];
        quantFreq = 0;
    }

    /**
     * Adiciona um novo frequentador ao clube.
     *
     * @param novo O novo frequentador a ser adicionado.
     * @return True se o frequentador foi adicionado com sucesso, false se o limite de capacidade foi atingido.
     */
    public boolean addFrequentador(Frequentador novo) {
        boolean resposta = true;

        if (quantFreq == frequentadores.length) {
            resposta = false;
        } else {
            for (int i = 0; i < quantFreq && resposta; i++) {
                if (frequentadores[i].equals(novo)) {
                    resposta = false;
                }
            }

            if (resposta) {
                frequentadores[quantFreq] = novo;
                quantFreq++;
            }
        }

        return resposta;
    }

    /**
     * Registra uma visita para um frequentador no clube.
     *
     * @param idFreq O ID do frequentador para o qual a visita será registrada.
     * @param data A data da visita.
     * @param hora A hora da visita.
     */
    public void registrarVisita(String idFreq, Date data, LocalTime hora) {
        for (int i = 0; i < quantFreq; i++) {
            if (idFreq.equals(frequentadores[i].getId())) {
                frequentadores[i].registrarVisita(data, hora);
            }
        }
    }

    /**
     * Registra a saída de um frequentador do clube.
     *
     * @param idFreq O ID do frequentador para o qual a saída será registrada.
     * @param data A data da saída.
     * @param hora A hora da saída.
     */
    public void registrarSaida(String idFreq, Date data, LocalTime hora) {
            for (int i = 0; i < quantFreq; i++) {
                if (frequentadores[i].visitouClubeEm(data)) {
                    if (idFreq.equals(frequentadores[i].getId())) {
                        frequentadores[i].registrarSaida(data, hora);
                    }
                }
            }
    }

    /**
     * Gera um relatório das visitas em uma data específica.
     *
     * @param dia A data para a qual o relatório será gerado.
     * @return O relatório das visitas nessa data.
     */
    public String relatorioVisitasData(Date dia) {
        StringBuilder relat = new StringBuilder("Visitas em " + dia + "\n");

        for (int i = 0; i < quantFreq; i++) {
            if (frequentadores[i].visitouClubeEm(dia)) {
                relat.append(frequentadores[i] + "\n");
            }
        }

        return relat.toString();
    }

    /**
     * Gera um relatório das visitas de um frequentador específico.
     *
     * @param idFreq O ID do frequentador para o qual o relatório será gerado.
     * @return O relatório das visitas do frequentador.
     */
    public String relatorioVisitasFreq(String idFreq) {
        for (int i = 0; i < quantFreq; i++) {
            if (idFreq.equals(frequentadores[i].getId())) {
                return frequentadores[i].relatorioVisitas();
            }
        }

        return "Não existe este sócio";
    }

    /**
     * Obtém a quantidade de visitas de convidados de um sócio.
     *
     * @param socio O sócio para o qual a quantidade de visitas de convidados será obtida.
     * @return A quantidade de visitas de convidados desse sócio.
     */
    public int getQtdVisitasConvidados(Socio socio) {
        int qtdVisitas = 0;
    
        for (Frequentador visitante : frequentadores) {
            if (visitante instanceof Convidado) {
                Convidado convidado = (Convidado) visitante;
                if (convidado.getSocioResponsavel().equals(socio)) {
                    qtdVisitas += convidado.getVisitas().size();
                }
            }
        }
    
        return qtdVisitas;
    }
    
}

