import java.util.List;

public class Premio {
    public static final int acertosSena = 6;
    public static final int acertosQuina = 5;
    public static final int acertosQuadra = 4;
    public static final double porcentagemTotal = 1.0;
    public static final double porcentagemQuina = 0.2;
    public static final double porcentagemQuadra = 0.05;

    public double calculaPremio(Aposta aposta, ISorteio sorteio, double premioTotal) {
        if (aposta == null || sorteio == null) {
            throw new IllegalArgumentException("Aposta/sorteio inválido");
        }

        int numerosAcertados = contarAcertos(aposta.getNumeros(), sorteio.getNumeros());

        if (numerosAcertados == acertosSena) {
            return premioTotal * porcentagemTotal;
        } else if (numerosAcertados == acertosQuina) {
            return premioTotal * porcentagemQuina;
        } else if (numerosAcertados == acertosQuadra) {
            return premioTotal * porcentagemQuadra;
        } else {
            return 0.0;
        }
    }

    private int contarAcertos(List<Integer> numerosApostados, List<Integer> numerosSorteados) {
        int numerosAcertados = 0;
        for (Integer apostado : numerosApostados) {
            if (numerosSorteados.contains(apostado)) {
                numerosAcertados++;
            }
        }
        return numerosAcertados;

    }

}
