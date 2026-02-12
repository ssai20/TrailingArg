public class ThomasMethod {
    public ThomasMethod() {
    }

    public Double[] progonka(Double[] A, Double[] B, Double[] C, Double[] F, Integer N, Double epsilon) {
        Double[] alpha = new Double[N + 1];
        Double[] betta = new Double[N + 1];
        Double[] c = new Double[N + 1];
        Integer iteration = 0;
        alpha[1] = 0.;
        betta[1] = 2.;//Math.exp(-1. / epsilon);
        for (int i = 1; i < N; i++) {
            alpha[i + 1] = -C[i] / (B[i] + alpha[i] * A[i]);
            betta[i + 1] = (-A[i] * betta[i] + F[i]) / (B[i] + alpha[i] * A[i]);
        }


//        c[0] = 2.;
        c[N] = Math.exp(-1. / epsilon);
        for (int i = N - 1; i >= 0; i--) {
            c[i] = alpha[i + 1] * c[i + 1] + betta[i + 1];
            iteration++;
        }
        System.out.println("c[N] = " + c[N]);
        System.out.println("c[0] = " + c[0]);
        return c;
    }

}
