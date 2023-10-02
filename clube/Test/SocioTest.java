import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class SocioTest {

    @Test
    public void testEmitirConvite() {
        Socio socio = new Socio("Socio1", "S1", 101);
        Convidado convidado = new Convidado("Convidado1", "C1", socio);

        // Emitir convites
        assertTrue(socio.podeEmitirConvite());
        socio.emitirConvite(convidado, new Date());
        assertEquals(1, socio.getConvitesEmitidos().size());

        // Tentar emitir mais convites que o permitido
        for (int i = 0; i < 5; i++) {
            socio.emitirConvite(convidado, new Date());
        }
        assertFalse(socio.podeEmitirConvite());
        assertEquals(4, socio.getConvitesEmitidos().size());
    }

    @Test
    public void testToString() {
        Socio socio = new Socio("Socio1", "S1", 101);
        assertEquals("Socio: Socio1 (Número de sócio: 101)", socio.toString());
    }
}
