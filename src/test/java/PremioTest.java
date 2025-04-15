import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PremioTest {

    @Test
    void testeApostaNula() {
        Premio premio = new Premio();
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                premio.calculaPremio(null, new Sorteio(6), 1000.00));
        assertEquals("Aposta nao pode ser calculada", e.getMessage());
    }

    @Test
    void testeSorteioNulo() {
        Premio premio = new Premio();
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                premio.calculaPremio(new Aposta(Arrays.asList(10, 20, 30, 40, 50, 60)), null, 1000.00));
        assertEquals("Sorteio nao pode ser realizado", e.getMessage());
    }
    @Test
    void testeGanhaPremio() {
        List<Integer> sorteados = Arrays.asList(01, 11, 21, 37, 47, 45);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Premio premio = new Premio();
        Aposta aposta = new Aposta(Arrays.asList(01, 11, 21, 37, 47, 45));
        assertEquals(2000000, premio.calculaPremio(aposta, sorteioMock, 2000000), 0.0);
    }

    @Test
    void testeGanhaQuina() {
        List<Integer> sorteados = Arrays.asList(01, 11, 21, 37, 47, 45);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Premio premio = new Premio();
        Aposta aposta = new Aposta(Arrays.asList(01, 41, 21, 37, 47, 45));
        assertEquals(200000, premio.calculaPremio(aposta, sorteioMock, 1000000),0.0);
    }

    @Test
    void testeGanhaQuadra() {
        List<Integer> sorteados = Arrays.asList(01, 11, 21, 37, 47, 45);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Premio premio = new Premio();
        Aposta aposta = new Aposta(Arrays.asList(01, 02, 21, 37, 47, 55));
        assertEquals(500000, premio.calculaPremio(aposta, sorteioMock, 1000000), 0.0);
    }

    @Test
    void testeNaoGanha() {
        List<Integer> sorteados = Arrays.asList(01, 11, 21, 37, 47, 45);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Premio premio = new Premio();
        Aposta aposta = new Aposta(Arrays.asList(04, 12, 30, 19, 60, 55));
        assertEquals(0.00, premio.calculaPremio(aposta, sorteioMock, 1000.00), 0.0);
    }


}
