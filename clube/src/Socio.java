import java.util.*;

/**
 * Representa um sócio frequentador do clube, que pode emitir convites para convidados.
 */
class Socio extends Frequentador {
    private int numeroSocio; // Número de sócio do sócio
    private List<Date> convitesEmitidos; // Lista de datas dos convites emitidos pelo sócio

    /**
     * Cria um objeto Socio com o nome, o ID e o número de sócio especificados.
     *
     * @param nome O nome do sócio.
     * @param id O ID do sócio.
     * @param numeroSocio O número de sócio do sócio.
     */
    public Socio(String nome, String id, int numeroSocio) {
        super(nome, id);
        this.numeroSocio = numeroSocio;
        this.convitesEmitidos = new ArrayList<>();
    }

    /**
     * Obtém o número de sócio do sócio.
     *
     * @return O número de sócio do sócio.
     */
    public int getNumeroSocio() {
        return numeroSocio;
    }

    /**
     * Obtém a lista de datas dos convites emitidos pelo sócio.
     *
     * @return A lista de datas dos convites emitidos pelo sócio.
     */
    public List<Date> getConvitesEmitidos() {
        return convitesEmitidos;
    }

    /**
     * Verifica se o sócio pode emitir mais convites.
     *
     * @return True se o sócio pode emitir mais convites (menos de 4), false caso contrário.
     */
    public boolean podeEmitirConvite() {
        return convitesEmitidos.size() < 4;
    }

    /**
     * Retorna uma representação em string do sócio.
     *
     * @return Uma string que representa o sócio, incluindo o nome e o número de sócio.
     */
    @Override
    public String toString() {
        return "Socio: " + nome + " (Número de sócio: " + numeroSocio + ")";
    }

    /**
     * Emite um convite para o convidado especificado com a data do convite.
     *
     * @param convidado O convidado para quem o convite será emitido.
     * @param dataConvite A data do convite.
     */
    public void emitirConvite(Convidado convidado, Date dataConvite) {
        if (podeEmitirConvite()) {
            convitesEmitidos.add(dataConvite);
            convidado.setConviteEmitido(true);
        } else {
            System.out.println("Você atingiu o limite de 4 convites por mês.");
        }
    }
}