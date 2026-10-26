public class Questao4 {

    public static class Resultado {
        public final int valor;
        public final int indice;

        public Resultado(int valor, int indice) {
            this.valor = valor;
            this.indice = indice;
        }

        @Override
        public String toString() {
            return "maior=" + valor + ", índice=" + indice;
        }
    }

    public static Resultado encontrarMaximo(int[] vetor) {
        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("O vetor não pode ser nulo ou vazio.");
        }

        int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (vetor[meio] < vetor[meio + 1]) {
                esquerda = meio + 1;
            } else {
                direita = meio;
            }
        }

        return new Resultado(vetor[esquerda], esquerda);
    }
}
