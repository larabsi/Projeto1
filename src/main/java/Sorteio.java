import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio implements ISorteio {

    private static final int maiorNumeroPossivel = 59;

    private  List<Integer> numeros;

    public Sorteio(int quantidadeNumeros) {
        this.numeros = sortear (quantidadeNumeros);
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public List<Integer> getNumeros() {
        return this.numeros;
    }

    private List<Integer> sortear(int quantidadeNumeros) {
        List<Integer> numerosSorteados = new ArrayList<>();
        int numeroSorteado;
        while (numerosSorteados.size() < quantidadeNumeros) {
            numeroSorteado = new Random().nextInt(maiorNumeroPossivel) + 1;
            if (!numerosSorteados.contains(numeroSorteado)) {
                numerosSorteados.add(numeroSorteado);
            }
        }
        return numerosSorteados;
    }
}