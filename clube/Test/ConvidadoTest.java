import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConvidadoTest {

    @Test
    void testCriarConvidado() {
        // Cria um convidado com um sócio responsável
        Socio socioResponsavel = new Socio("TEste", "S1", 2);
        Convidado convidado = new Convidado("Maria da Silva", "9876543210", socioResponsavel);

        // Verifica se o convidado foi criado corretamente
        Assertions.assertEquals("Maria da Silva", convidado.getNome());
        Assertions.assertEquals("9876543210", convidado.getId());
        Assertions.assertEquals(socioResponsavel, convidado.getSocioResponsavel());
        Assertions.assertFalse(convidado.isConviteEmitido());
    }

    @Test
    void testSetConviteEmitido() {
        // Cria um convidado com um sócio responsável
        Socio socioResponsavel = new Socio("TEste2", "S2", 3);       
        Convidado convidado = new Convidado("Maria da Silva", "9876543210", socioResponsavel);

        // Verifica se o convite não foi emitido inicialmente
        Assertions.assertFalse(convidado.isConviteEmitido());

        // Define o convite como emitido
        convidado.setConviteEmitido(true);

        // Verifica se o convite foi emitido
        Assertions.assertTrue(convidado.isConviteEmitido());
    }

    @Test
    void testToString() {
        // Cria um convidado com um sócio responsável
        Socio socioResponsavel = new Socio("João da Silva", "S3", 4);  
        Convidado convidado = new Convidado("Maria da Silva", "9876543210", socioResponsavel);

        // Verifica se a representação em string é correta
        Assertions.assertEquals("Convidado: Maria da Silva (Sócio responsável: João da Silva)", convidado.toString());
    }
}
