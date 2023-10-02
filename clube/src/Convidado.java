/**
 * Representa um frequentador convidado no clube, associado a um sócio responsável.
 */
class Convidado extends Frequentador {
    private Socio socioResponsavel; // O sócio responsável pelo convite
    private boolean conviteEmitido; // Indica se o convite foi emitido

    /**
     * Cria um objeto Convidado com o nome, ID e sócio responsável especificados.
     *
     * @param nome O nome do convidado.
     * @param id O ID do convidado.
     * @param socioResponsavel O sócio responsável pelo convite.
     */
    public Convidado(String nome, String id, Socio socioResponsavel) {
        super(nome, id);
        this.socioResponsavel = socioResponsavel;
        this.conviteEmitido = false;
    }

    /**
     * Obtém o sócio responsável pelo convite.
     *
     * @return O sócio responsável pelo convite.
     */
    public Socio getSocioResponsavel() {
        return socioResponsavel;
    }

    /**
     * Verifica se o convite foi emitido para este convidado.
     *
     * @return True se o convite foi emitido, false caso contrário.
     */
    public boolean isConviteEmitido() {
        return conviteEmitido;
    }

    /**
     * Define se o convite foi emitido para este convidado.
     *
     * @param conviteEmitido True se o convite foi emitido, false caso contrário.
     */
    public void setConviteEmitido(boolean conviteEmitido) {
        this.conviteEmitido = conviteEmitido;
    }

    /**
     * Retorna uma representação em string do convidado.
     *
     * @return Uma string que representa o convidado, incluindo o nome e o nome do sócio responsável.
     */
    @Override
    public String toString() {
        return "Convidado: " + nome + " (Sócio responsável: " + socioResponsavel.getNome() + ")";
    }
}
