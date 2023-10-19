import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estacionamento {

    private String nome;
    private int quantFileiras;
    private int vagasPorFileira;
    private List<Cliente> clientes;
    private List<Vaga> vagas;
    private Map<String, UsoDeVaga> usoDeVagaMap;

    public Estacionamento(String nome, int quantFileiras, int vagasPorFileira) {
        this.nome = nome;
        this.quantFileiras = quantFileiras;
        this.vagasPorFileira = vagasPorFileira;
        this.clientes = new ArrayList<>();
        this.vagas = new ArrayList<>();
        this.usoDeVagaMap = new HashMap<>();
        gerarVagas();
    }

    public void add_veiculo(Veiculo veiculo, String clienteId) {
        Cliente cliente = getClienteById(clienteId);
        if (cliente != null) {
            cliente.addVeiculo(veiculo);
        }
    }

    public void add_cliente(Cliente cliente) {
        clientes.add(cliente);
    }

    private void gerarVagas() {
        for (char fila = 'A'; fila < 'A' + quantFileiras; fila++) {
            for (int numero = 1; numero <= vagasPorFileira; numero++) {
                String id = String.format("%c%02d", fila, numero);
                Vaga vaga = new Vaga(id);
                vagas.add(vaga);
            }
        }
    }

    public boolean estacionar(String placa) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel()) {
                vaga.estacionar();
                UsoDeVaga usoDeVaga = new UsoDeVaga(placa, vaga.getId());
                usoDeVagaMap.put(placa, usoDeVaga);
                return true;
            }
        }
        return false;
    }

    public boolean sair(String placa) {
        UsoDeVaga usoDeVaga = usoDeVagaMap.get(placa);
        if (usoDeVaga != null) {
            Vaga vaga = getVagaById(usoDeVaga.getVagaId());
            if (vaga != null) {
                vaga.sair();
                usoDeVagaMap.remove(placa);
                return true;
            }
        }
        return false;
    }

    public double total_arrecadado() {
        double total = 0;
        for (UsoDeVaga usoDeVaga : usoDeVagaMap.values()) {
            total += usoDeVaga.calcularCusto();
        }
        return total;
    }

    // Implement arrecadacao_no_mes(), valorMedioPorUso(), top5clientes() based on your requirements

    private Cliente getClienteById(String clienteId) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(clienteId)) {
                return cliente;
            }
        }
        return null;
    }

    private Vaga getVagaById(String vagaId) {
        for (Vaga vaga : vagas) {
            if (vaga.getId().equals(vagaId)) {
                return vaga;
            }
        }
        return null;
    }
}
