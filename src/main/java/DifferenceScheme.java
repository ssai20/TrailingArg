import java.util.ArrayList;
import java.util.function.Function;

public class DifferenceScheme {
    double A[];
    double B[];
    double C[];
    double f[];
    int N;
    public DifferenceScheme(int N) {
        this.N = N;
        A = new double[N + 1];
        B = new double[N + 1];
        C = new double[N + 1];
        f = new double[N + 1];
    }

    public void classicTeylorFormulasScheme(double epsilon, double[] h, double delta) {
        for (int i = 0; i < N; i++) {
            A[i] = 2. * epsilon / (h[i]*(h[i] + h[i + 1]));
            B[i] = 2. * epsilon *(h[i]-h[i+1])/ (h[i]*h[i+1]*(h[i] + h[i + 1])) - 1./h[i+1] -  1.;
//            B[i] = -2. * epsilon / (h[i] + h[i + 1]) - 1. - (delta + 1.) * 1.;
            C[i] = 2. * epsilon / (h[i+1]*(h[i] + h[i + 1]));
//            C[i] = 2. * epsilon / (h[i + 1] * (h[i] + h[i + 1])) + (1. + delta * 1.) / h[i + 1];
        }
    }

    public void modifiedTeylorFormulasScheme(double epsilon, double[] h, double delta, double[] Phi, double[] PhiDelta) {
        for (int i = 0; i < N; i++) {
            A[i] = 2. * epsilon /(h[i] + h[i + 1]);
            B[i] = 1. * h[i + 1] / ((Phi[i + 1] - Phi[i]) * h[i]) - 2. * epsilon / (h[i] * h[i + 1]) - 1. / h[i] - 1.;
            C[i] = 2. * epsilon / (h[i + 1] * (h[i] + h[i + 1])) + 1. / h[i] - (1. * h[i + 1] * PhiDelta[i] - Phi[i]) / ((Phi[i + 1] - Phi[i]) * h[i]);
        }
    }
    public double[] findPoints(double[] h) {
        double[] uzel = new double[N+1];
        uzel[0] = 0.;
        for (int i = 1; i < N + 1; i++) {
            uzel[i] = uzel[i - 1] + h[i];
//            System.out.print(uzel[i] + " ");
        }
        System.out.println();
        return uzel;
    }

    public void findFunction(double[] uzel, Function<Double, Double> function) {
        for (int i = 0; i < N + 1; i++) {
            f[i] = function.apply(uzel[i]);
        }
    }

    public ArrayList<double[]> ABCF(double epsilon, double[] h, double delta, Function<Double, Double> function, int method, Function<Double, Double> Phi) {
        ArrayList<double[]> list = new ArrayList<double[]>();
        double[] phi = new double[N+1];
        double[] phiDelta = new double[N+1];
        double[] uzel = findPoints(h);
        for (int i = 0; i < N + 1; i++) {
            phi[i] = Phi.apply(uzel[i]);
            phiDelta[i] = Phi.apply(uzel[i]-delta);
        }
        if (method == 0) {
            classicTeylorFormulasScheme(epsilon, h, delta);
        }
        if (method == 1) {
            modifiedTeylorFormulasScheme(epsilon, h, delta, phi, phiDelta);
        }
        findFunction(uzel, function);
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(f);

        return list;
    }

//    public ArrayList<double[]> modifiedTeylorFormulasScheme(int N, double epsilon, double[] h, double delta, double[] Phi, double[] PhiDelta) {
//        for (int i = 0; i < N; i++) {
//            A[i] = 2. * epsilon /(h[i] + h[i + 1]);
//            B[i] = 1. * h[i + 1] / ((Phi[i + 1] - Phi[i]) * h[i]) - 2. * epsilon / (h[i] * h[i + 1]) - 1. / h[i] - 1.;
//            C[i] = 2. * epsilon / (h[i + 1] * (h[i] + h[i + 1])) + 1. / h[i] - (1. * h[i + 1] * PhiDelta[i] - Phi[i]) / ((Phi[i + 1] - Phi[i]) * h[i]);
//        }
//        ArrayList<double[]> list = new ArrayList<double[]>();
//        list.add(A);
//        list.add(B);
//        list.add(C);
//        return list;
//    }

}
