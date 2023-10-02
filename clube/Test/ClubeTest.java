import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalTime;
import java.util.Date;

public class ClubeTest {

    @Test
    public void testAddFrequentador() {
        // Crie um clube com capacidade para 2 frequentadores
        Clube clube = new Clube(2);

        // Adicione dois frequentadores
        Socio socio1 = new Socio("Socio1", "S1", 101);
        Socio socio2 = new Socio("Socio2", "S2", 102);

        assertTrue(clube.addFrequentador(socio1));
        assertTrue(clube.addFrequentador(socio2));

        // Tente adicionar um terceiro frequentador (deve falhar)
        Convidado convidado = new Convidado("Convidado", "C1", socio1);
        assertFalse(clube.addFrequentador(convidado));
    }

    @Test
    public void testRegistrarVisita() {
        // Crie um clube com capacidade para 2 frequentadores
        Clube clube = new Clube(2);

        Socio socio = new Socio("Socio1", "S1", 101);
        assertTrue(clube.addFrequentador(socio));

        // Registre uma visita para o socio
        Date data = new Date();
        LocalTime hora = LocalTime.now();
        clube.registrarVisita("S1", data, hora);

        assertEquals("Visitas em " + data + "\nSocio: Socio1 (Número de sócio: 101)\n", clube.relatorioVisitasData(data));
    }
}