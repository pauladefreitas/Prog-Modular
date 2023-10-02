import java.time.LocalTime;
import java.util.Date;

/**
 * Representa uma visita de um frequentador ao clube, registrando a data, hora de entrada e hora de saída.
 */
public class Visita {
    private Frequentador frequentador; // O frequentador que fez a visita
    private Date data; // A data da visita
    private LocalTime horaEntrada; // A hora de entrada na visita
    private LocalTime horaSaida; // A hora de saída da visita

    /**
     * Cria uma visita com o frequentador, a data, a hora de entrada e a hora de saída especificados.
     *
     * @param frequentador O frequentador que fez a visita.
     * @param data A data da visita.
     * @param horaEntrada A hora de entrada na visita.
     * @param horaSaida A hora de saída da visita.
     */
    public Visita(Frequentador frequentador, Date data, LocalTime horaEntrada, LocalTime horaSaida) {
        this.frequentador = frequentador;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    /**
     * Obtém o frequentador associado a esta visita.
     *
     * @return O frequentador associado a esta visita.
     */
    public Frequentador getFrequentador() {
        return frequentador;
    }

    /**
     * Obtém a data da visita.
     *
     * @return A data da visita.
     */
    public Date getData() {
        return data;
    }

    /**
     * Obtém a hora de entrada na visita.
     *
     * @return A hora de entrada na visita.
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Obtém a hora de saída da visita.
     *
     * @return A hora de saída da visita.
     */
    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    /**
     * Define a hora de saída da visita.
     *
     * @param horaSaida A hora de saída da visita.
     */
    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * Retorna uma representação em string da visita, incluindo a data, hora de entrada e hora de saída.
     *
     * @return Uma string que representa a visita.
     */
    @Override
    public String toString() {
        return "Visita em " + data + ", Hora de entrada: " + horaEntrada + ", Hora de saída: " + horaSaida;
    }
}