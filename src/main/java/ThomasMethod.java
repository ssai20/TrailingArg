//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
//
//class ThomasMethod {
//    public ThomasMethod() {
//    }
//
//    public BigDecimal[] progonka(BigDecimal[] A, BigDecimal[] B, BigDecimal[] C, BigDecimal[] F, Integer N, BigDecimal epsilon) {
//        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
//
//        BigDecimal[] alpha = new BigDecimal[N + 1];
//        BigDecimal[] betta = new BigDecimal[N + 1];
//        BigDecimal[] c = new BigDecimal[N + 1];
//
//        alpha[1] = BigDecimal.ZERO;
//        betta[1] = BigDecimal.TWO;//BigDecimal.ONE;//BigDecimal.TWO;
//
//        for (int i = 1; i < N; i++) {
//            BigDecimal denominator = B[i].add(alpha[i].multiply(A[i], mc), mc);
//            alpha[i + 1] = C[i].negate().divide(denominator, mc);
//            betta[i + 1] = F[i].subtract(A[i].multiply(betta[i], mc), mc).divide(denominator, mc);
//        }
//
//        double epsilonVal = epsilon.doubleValue();
//        c[N] = BigDecimal.valueOf(Math.exp(-1.0 / epsilonVal));
////        c[N] = BigDecimal.ZERO;
//        for (int i = N - 1; i >= 0; i--) {
//            c[i] = alpha[i + 1].multiply(c[i + 1], mc).add(betta[i + 1], mc);
//        }
//
//        System.out.println("c[N] = " + c[N]);
//        System.out.println("c[0] = " + c[0]);
//        return c;
//    }
//}


public class ThomasMethod {
    public ThomasMethod() {
    }

    public Double[] progonka(Double[] A, Double[] B, Double[] C, Double[] F, Integer N, Double epsilon) {
        Double[] alpha = new Double[N + 1];
        Double[] betta = new Double[N + 1];
        Double[] c = new Double[N + 1];
        Integer iteration = 0;
        alpha[1] = 0.;
        betta[1] = 2.;//1.;
        for (int i = 1; i < N; i++) {
            alpha[i + 1] = -C[i] / (B[i] + alpha[i] * A[i]);
            betta[i + 1] = (-A[i] * betta[i] + F[i]) / (B[i] + alpha[i] * A[i]);
        }


//        c[0] = 2.;
        c[N] = Math.exp(-1. / epsilon); //0.;
        for (int i = N - 1; i >= 0; i--) {
            c[i] = alpha[i + 1] * c[i + 1] + betta[i + 1];
            iteration++;
        }
        System.out.println("c[N] = " + c[N]);
        System.out.println("c[0] = " + c[0]);
        return c;
    }

}
