import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorteioTest {

    @Test
    public void SorteioValido() {
        Sorteio sorteio = new Sorteio(0);
        assertEquals(new ArrayList<>(), sorteio.getNumeros());
    }
}