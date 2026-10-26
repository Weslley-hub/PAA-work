import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            String opcao = sc.nextLine().trim();

            switch (opcao) {
                case "1" -> executarQuestao2(sc);
                case "2" -> executarQuestao4(sc);
                case "3" -> {
                    System.out.println();
                    Testes.executarTodos();
                    System.out.println();
                }
                case "0" -> {
                    System.out.println("Encerrando.");
                    rodando = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("1 - Questão 2");
        System.out.println("2 - Questão 4");
        System.out.println("3 - Executar testes automatizados");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void executarQuestao2(Scanner sc) {
        System.out.println();
        System.out.println("Questão 2");
        System.out.print("Informe o número A: ");
        String a = sc.nextLine().trim();
        System.out.print("Informe o número B: ");
        String b = sc.nextLine().trim();

        try {
            BigInteger resultado = Questao2.multiplicar(a, b);
            System.out.println("Resultado: " + a + " × " + b + " = " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();
    }

    private static void executarQuestao4(Scanner sc) {
        System.out.println();
        System.out.println("Questão 4");
        System.out.println("Informe os elementos");
        System.out.println("(ex.: 1 3 5):");
        String linha = sc.nextLine().trim();

        try {
            String[] partes = linha.split("\\s+");
            int[] vetor = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                vetor[i] = Integer.parseInt(partes[i]);
            }

            Questao4.Resultado r = Questao4.encontrarMaximo(vetor);
            System.out.println("Maior valor: " + r.valor);
            System.out.println("Índice: " + r.indice);
        } catch (NumberFormatException e) {
            System.out.println("Erro: informe apenas inteiros separados por espaço.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();
    }
}
