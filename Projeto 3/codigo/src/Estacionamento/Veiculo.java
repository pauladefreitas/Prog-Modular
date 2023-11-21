import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um veículo que pode ser estacionado em uma vaga.
 */
public class Veiculo {

    private String placa;
    private List<UsoDeVaga> usos;
    private Vaga vaga;
    private Cliente cliente;

    /**
     * Construtor que cria um novo veículo com a placa especificada.
     *
     * @param placa A placa do veículo.
     */
    public Veiculo(String placa) {
        this.placa = placa;
        this.usos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém a placa do veículo.
     *
     * @return A placa do veículo.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define a placa do veículo.
     *
     * @param placa A nova placa do veículo.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Estaciona o veículo em uma vaga na data de entrada especificada.
     *
     * @param vaga    A vaga onde o veículo será estacionado.
     * @param entrada A data de entrada do veículo na vaga.
     */
    public void estacionar(Vaga vaga, LocalDateTime entrada) {
        UsoDeVaga uso = new UsoDeVaga(vaga);
        uso.usarVaga(this, entrada);
        usos.add(uso);
        this.vaga = vaga;
    }

    public Vaga getVaga() {
        return this.vaga;
    }

    /**
     * Obtém o último uso da vaga feito por este veículo.
     *
     * @return O último uso da vaga.
     */
    public UsoDeVaga getUltimoUso() {
        if (!usos.isEmpty()) {
            return usos.get(usos.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Registra a saída do veículo de uma vaga na data de saída especificada e calcula o valor a ser pago.
     *
     * @param saida A data de saída do veículo da vaga.
     * @return O valor a ser pago pelo uso da vaga.
     */
    public double sair(LocalDateTime saida) {
        double vPagar = 0.0;
        UsoDeVaga ultimoUso = getUltimoUso();

        if (ultimoUso != null && ultimoUso.getVaga().equals(vaga)) {
            vPagar = ultimoUso.sair(saida);
            vaga = null; // Define a vaga como nula após a saída
        }

        return vPagar;
    }

    /**
     * Calcula o valor total arrecadado com o uso das vagas por este veículo.
     *
     * @return O valor total arrecadado.
     */
    public double totalArrecadado() {
        return usos.stream().mapToDouble(u -> u.calcularCusto(this, u.getEntrada(), u.getSaida())).sum();
    }

    /**
     * Calcula o valor arrecadado no mês especificado.
     *
     * @param mes O mês para o qual o valor arrecadado será calculado.
     * @return O valor arrecadado no mês especificado.
     */
    public double arrecadadoNoMes(int mes) {
        return usos.stream()
                .filter(u -> u.getEntrada().getMonthValue() == mes)
                .mapToDouble(u -> u.calcularCusto(this, u.getEntrada(), u.getSaida()))
                .sum();
    }

    /**
     * Obtém o número total de usos da vaga feitos por este veículo.
     *
     * @return O número total de usos da vaga.
     */
    public int totalDeUsos() {
        return usos.size();
    }

    public void setVaga(Vaga vagaDisponivel) {
        this.vaga = vagaDisponivel;
    }

}
