import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aposta {
    private static final int apostaMinima = 6;
    private static final int apostaMaxima = 15;
    private static final int menorNumeroPossivel = 1;
    private static final int maiorNumeroPossivel = 60;

    private final List<Integer> numeros;

    public Aposta(List<Integer> numeros) {
        this.numeros = Collections.unmodifiableList(numeros);// cópia defensiva
        validarAposta(numeros);
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    private void validarAposta(List<Integer> numerosApostados) {
        if (numerosApostados.size() < apostaMinima) {
            throw new IllegalArgumentException("Aposta sem do minimo necessario de numeros");
        }
        if (numerosApostados.size() > apostaMaxima) {
            throw new IllegalArgumentException("Aposta com mais numeros que o permitido");
        }

        List<Integer> numerosValidados = new ArrayList<>();
        for (Integer apostado : numerosApostados) {
            if (apostado < menorNumeroPossivel || apostado > maiorNumeroPossivel) {
                throw new IllegalArgumentException("Número fora do limite permitido");
            }
            if (numerosValidados.contains(apostado)) {
                throw new IllegalArgumentException("Número duplicado");
            }
            numerosValidados.add(apostado);
        }
    }
}
