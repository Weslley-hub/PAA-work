import java.math.BigInteger;

public class Testes {

    private static int aprovados = 0;
    private static int total = 0;

    public static void main(String[] args) {
        executarTodos();
    }

    public static void executarTodos() {
        aprovados = 0;
        total = 0;

        System.out.println("Questão 2");
        testarQ2();

        System.out.println();
        System.out.println("Questão 4");
        testarQ4();

        System.out.println();
        System.out.println("Resultado: " + aprovados + "/" + total + " testes aprovados.");
        if (aprovados == total) {
            System.out.println("Todos os testes passaram.");
        } else {
            System.out.println((total - aprovados) + " testes reprovados.");
        }
    }

    private static void testarQ2() {
        verificarQ2("12", "34", "408");
        verificarQ2("1234", "5678", "7006652");
        verificarQ2("0", "999", "0");
        verificarQ2("12345", "678", "8369910");
        verificarQ2("99999", "99999", "9999800001");

        String grandeA = "123456789012345678901234567890";
        String grandeB = "987654321098765432109876543210";
        BigInteger esperado = new BigInteger(grandeA).multiply(new BigInteger(grandeB));
        BigInteger obtido = Questao2.multiplicar(grandeA, grandeB);
        verificar("Q2 grandes (" + grandeA.length() + " x " + grandeB.length() + " dígitos)",
                obtido.equals(esperado),
                esperado.toString(),
                obtido.toString());

        String a2 = "9999999999999999999999999999999999999999";
        String b2 = "1111111111111111111111111111111111111111";
        BigInteger esp2 = new BigInteger(a2).multiply(new BigInteger(b2));
        BigInteger obt2 = Questao2.multiplicar(a2, b2);
        verificar("Q2 grandes 40 dígitos",
                obt2.equals(esp2),
                esp2.toString(),
                obt2.toString());
    }

    private static void testarQ4() {
        verificarQ4(new int[]{2, 5, 8, 7}, 8, 2);
        verificarQ4(new int[]{1, 3, 5, 9, 7, 4}, 9, 3);
        verificarQ4(new int[]{9, 5, 1}, 9, 0);
        verificarQ4(new int[]{1, 4, 9}, 9, 2);
        verificarQ4(new int[]{42}, 42, 0);
        verificarQ4(new int[]{2, 8, 5}, 8, 1);
    }

    private static void verificarQ2(String a, String b, String esperado) {
        BigInteger obtido = Questao2.multiplicar(a, b);
        boolean ok = obtido.equals(new BigInteger(esperado));
        verificar("Q2 " + a + " × " + b, ok, esperado, obtido.toString());
    }

    private static void verificarQ4(int[] vetor, int valorEsperado, int indiceEsperado) {
        Questao4.Resultado r = Questao4.encontrarMaximo(vetor);
        boolean ok = r.valor == valorEsperado && r.indice == indiceEsperado;
        String entrada = java.util.Arrays.toString(vetor);
        verificar("Q4 " + entrada,
                ok,
                "valor=" + valorEsperado + ", índice=" + indiceEsperado,
                "valor=" + r.valor + ", índice=" + r.indice);
    }

    private static void verificar(String nome, boolean ok, String esperado, String obtido) {
        total++;
        if (ok) {
            aprovados++;
            System.out.println("[OK] " + nome);
        } else {
            System.out.println("[FALHOU] " + nome);
            System.out.println("         esperado: " + esperado);
            System.out.println("         obtido:   " + obtido);
        }
    }
}
