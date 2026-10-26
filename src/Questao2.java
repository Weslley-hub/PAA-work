import java.math.BigInteger;

public class Questao2 {

    public static BigInteger multiplicar(String a, String b) {
        a = normalizar(a);
        b = normalizar(b);

        if (a.equals("0") || b.equals("0")) {
            return BigInteger.ZERO;
        }

        return karatsuba(new BigInteger(a), new BigInteger(b));
    }

    public static BigInteger multiplicar(BigInteger a, BigInteger b) {
        if (a.signum() < 0 || b.signum() < 0) {
            throw new IllegalArgumentException("Apenas números não negativos são suportados.");
        }
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        return karatsuba(a, b);
    }

    private static BigInteger karatsuba(BigInteger x, BigInteger y) {
        if (x.compareTo(BigInteger.TEN) < 0 && y.compareTo(BigInteger.TEN) < 0) {
            return BigInteger.valueOf(x.intValue() * y.intValue());
        }

        int n = Math.max(x.toString().length(), y.toString().length());
        int m = n / 2;
        BigInteger base = BigInteger.TEN.pow(m);

        BigInteger[] partesX = x.divideAndRemainder(base);
        BigInteger a1 = partesX[0];
        BigInteger a0 = partesX[1];

        BigInteger[] partesY = y.divideAndRemainder(base);
        BigInteger b1 = partesY[0];
        BigInteger b0 = partesY[1];

        BigInteger z0 = karatsuba(a0, b0);
        BigInteger z2 = karatsuba(a1, b1);
        BigInteger z1 = karatsuba(a0.add(a1), b0.add(b1));

        BigInteger meio = z1.subtract(z2).subtract(z0);
        return z2.multiply(BigInteger.TEN.pow(2 * m))
                .add(meio.multiply(base))
                .add(z0);
    }

    private static String normalizar(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Número inválido.");
        }
        s = s.trim();
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException("Informe apenas dígitos não negativos: " + s);
        }
        s = s.replaceFirst("^0+(?!$)", "");
        return s;
    }
}
