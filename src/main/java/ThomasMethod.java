public class ThomasMethod {
    public ThomasMethod() {
    }

    public double[] progonka(double[] A, double[] B, double[] C, double[] F, int N,  double epsilon) {
        double[] alpha = new double[N + 1];
        double[] betta = new double[N + 1];
        double[] c = new double[N+1];
        int iteration = 0;
        alpha[1] = 0.;
        betta[1] = 2.;//Math.exp(-1. / epsilon);
        for (int i = 1; i < N; i++) {
            alpha[i + 1] = B[i] / (C[i] - alpha[i] * A[i]);
            betta[i + 1] = (A[i] * betta[i] + F[i]) / (C[i] - alpha[i] * A[i]);
        }



//        c[0] = 2.;
        c[N] = Math.exp(-1. / epsilon);
        for (int i = N - 1; i >= 0; i--) {
            c[i] = alpha[i + 1] * c[i + 1] + betta[i + 1];
            iteration++;
        }
         return c;
    }

}
