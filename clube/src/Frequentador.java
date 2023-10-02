import java.util.*;
import java.time.LocalTime;

/**
 * Representa um frequentador de um clube, que registra suas visitas.
 */
public class Frequentador {
    protected String nome; // O nome do frequentador
    protected String id; // O ID do frequentador
    protected List<Visita> visitas; // Lista de visitas registradas pelo frequentador

    /**
     * Cria um objeto Frequentador com o nome e o ID especificados.
     *
     * @param nome O nome do frequentador.
     * @param id O ID do frequentador.
     */
    public Frequentador(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.visitas = new ArrayList<>();
    }

    /**
     * Obtém o nome do frequentador.
     *
     * @return O nome do frequentador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do frequentador.
     *
     * @param nome O novo nome do frequentador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o ID do frequentador.
     *
     * @return O ID do frequentador.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID do frequentador.
     *
     * @param id O novo ID do frequentador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém a lista de visitas registradas pelo frequentador.
     *
     * @return A lista de visitas do frequentador.
     */
    public List<Visita> getVisitas() {
        return visitas;
    }

    /**
     * Registra uma visita para o frequentador com a data e a hora de entrada especificadas.
     *
     * @param data A data da visita.
     * @param horaEntrada A hora de entrada da visita.
     */
    public void registrarVisita(Date data, LocalTime horaEntrada) {
        Visita visita = new Visita(this, data, horaEntrada, null);
        visitas.add(visita);
    }

    /**
     * Registra a saída do frequentador no clube para a data especificada.
     *
     * @param data A data da saída.
     * @param horaSaida A hora de saída.
     */
    public void registrarSaida(Date data, LocalTime horaSaida) {
        for (Visita visita : visitas) {
            if (visita.getData().equals(data)) {
                visita.setHoraSaida(horaSaida);
                break;
            }
        }
    }

    /**
     * Verifica se o frequentador visitou o clube na data especificada.
     *
     * @param data A data a ser verificada.
     * @return True se o frequentador visitou o clube na data especificada, false caso contrário.
     */
    public boolean visitouClubeEm(Date data) {
        for (Visita visita : visitas) {
            if (visita.getData().equals(data)) {
                return true;
            }
        }
    
        return false;
    }    

    /**
     * Gera um relatório das visitas do frequentador.
     *
     * @return O relatório das visitas do frequentador.
     */
    public String relatorioVisitas() {
        StringBuilder relatorio = new StringBuilder("Visitas do frequentador " + nome + "\n");
        for (Visita visita : visitas) {
            relatorio.append(visita.toString() + "\n");
        }
        return relatorio.toString();
    }

}
