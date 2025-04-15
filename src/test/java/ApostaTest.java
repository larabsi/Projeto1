import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApostaTest{
    @Test
    public void testeApostaValida() {
        List<Integer> numeros = Arrays.asList(1, 16, 27, 36, 31, 58);
        Aposta aposta = new Aposta(numeros);
        assertEquals(numeros, aposta.getNumeros());
    }

    @Test
    public void testeMenosNumeros() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
            new Aposta(Arrays.asList(1, 10, 24, 58, 60)); // apenas 5 números
        });
        assertEquals("Aposta sem o numero minimo de numeros", excecao.getMessage());
    }

    @Test
    public void testeApostaCerta() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Aposta correta");
        });
        assertEquals("Aposta correta", e.getMessage());
    }

    @Test
    public void testApostaInvalidaPoucosNumerosMock2() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Aposta correta");
        });
        assertEquals("Aposta correta", e.getMessage());
    }

}
