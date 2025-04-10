import java.util.ArrayList;
import java.util.function.Function;

public class DifferenceScheme {
    Double A[];
    Double B[];
    Double C[];
    Double f[];
    Integer N;
    public DifferenceScheme(int N) {
        this.N = N;
        A = new Double[N + 1];
        B = new Double[N + 1];
        C = new Double[N + 1];
        f = new Double[N + 1];
    }

    public ArrayList<Double[]> classicTeylorFormulasScheme(Double epsilon, Double[] h, Double delta, Function<Double, Double> function, Double[] uzel) {
        Double[] A = new Double[N + 1];
        Double[] B = new Double[N + 1];
        Double[] C = new Double[N + 1];
        Double[] f = new Double[N + 1];
        ArrayList<Double[]> list = new ArrayList<Double[]>();
        for (int i = 0; i < N; i++) {
                A[i] = 2. * epsilon / (h[i] + h[i + 1]) / h[i];
                B[i] = -2. * epsilon / (h[i] + h[i + 1]) / h[i + 1] - (2. * epsilon / ((h[i] + h[i + 1])) / h[i]) - (1. + delta) / h[i + 1] - 1.;
                System.out.println("Bclassic["+i+"] = " + B[i]);
                C[i] = 2. * epsilon / ((h[i] + h[i + 1])) / h[i + 1] + (1. + delta) / (h[i + 1]);
                f[i] = function.apply(uzel[i]);
            }

//        for (int i = 0; i < N; i++) {
//            if (uzel[i] > delta) {
//                A[i] = 2. * epsilon / (h[i] + h[i + 1]) / h[i];
//                B[i] = -2. * epsilon / (h[i] + h[i + 1]) / h[i + 1] - (2. * epsilon / ((h[i] + h[i + 1])) / h[i]) - (1. + delta) / h[i + 1] - 1.;
//                System.out.println("Bclassic["+i+"] = " + B[i]);
//                C[i] = 2. * epsilon / ((h[i] + h[i + 1])) / h[i + 1] + (1. + delta) / (h[i + 1]);
//                f[i] = function.apply(uzel[i]);
//            }
//            if (uzel[i] <= delta ) {
//                A[i] = 2. * epsilon / (h[i] + h[i + 1]) / h[i];
//                B[i] = -2. * epsilon / (h[i] + h[i + 1]) / h[i + 1] - (2. * epsilon / ((h[i] + h[i + 1])) / h[i]) - 1. / h[i + 1];
//                C[i] = 2. * epsilon / ((h[i] + h[i + 1])) / h[i + 1] + 1. / (h[i + 1]);
//                f[i] = function.apply(uzel[i]) + 2.;
//            }
//        }
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(f);
        return list;
    }

    public ArrayList<Double[]> modifiedTeylorFormulasScheme(Double epsilon, Double[] h, Double delta, Double[] Phi, Double[] PhiDelta, Function<Double, Double> function, Double[] uzel) {
        ArrayList<Double[]> list = new ArrayList<Double[]>();
        for (int i = 0; i < N; i++) {
            A[i] = 2. * epsilon / (h[i] + h[i + 1])/h[i];
            B[i] = - 2. * epsilon / (h[i]+h[i+1]) /h[i+1] - (2. * epsilon / ((h[i]+h[i+1]))/h[i]) - (1.)/h[i+1] -  1. + (epsilon/h[i+1] - epsilon * PhiDelta[i]/Phi[i]/h[i+1]);/*(PhiDelta[i] - Phi[i])/(Phi[i+1]-Phi[i])*/;
            C[i] = 2. * epsilon / ((h[i] + h[i + 1]))/h[i+1] + (1.)/(h[i+1]) - (epsilon/h[i+1] - epsilon * PhiDelta[i]/Phi[i]/h[i+1]);/*(PhiDelta[i] - Phi[i])/(Phi[i+1]-Phi[i])*/;
            f[i] = function.apply(uzel[i]);
        }


//        for (int i = 0; i < N; i++) {
//            if (uzel[i] > delta) {
//                A[i] = 2. * epsilon / (h[i] + h[i + 1]) / h[i];
//                System.out.println(A[i]);
//                B[i] = -2. * epsilon / (h[i] + h[i + 1]) / h[i + 1] - (2. * epsilon / ((h[i] + h[i + 1])) / h[i]) - (1.) / h[i + 1] - 1. + (epsilon / h[i + 1] - epsilon * PhiDelta[i] / Phi[i] / h[i + 1]);/*(PhiDelta[i] - Phi[i])/(Phi[i+1]-Phi[i])*/
//                ;
//                System.out.println("Bmodif["+i+"] = " + B[i]);
//                C[i] = 2. * epsilon / ((h[i] + h[i + 1])) / h[i + 1] + (1.) / (h[i + 1]) - (epsilon / h[i + 1] - epsilon * PhiDelta[i] / Phi[i] / h[i + 1]);/*(PhiDelta[i] - Phi[i])/(Phi[i+1]-Phi[i])*/
//                ;
//                f[i] = function.apply(uzel[i]);
//            }
//            if (uzel[i] <= delta) {
//                A[i] = 2. * epsilon / (h[i] + h[i + 1]) / h[i];
//                B[i] = -2. * epsilon / (h[i] + h[i + 1]) / h[i + 1] - (2. * epsilon / ((h[i] + h[i + 1])) / h[i]) - 1. / h[i + 1];
//                C[i] = 2. * epsilon / ((h[i] + h[i + 1])) / h[i + 1] + 1. / (h[i + 1]);
//                f[i] = function.apply(uzel[i]) + 2.;
//            }
//        }
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(f);
        return list;
    }
    public Double[] findPoints(Double[] h) {
        Double[] uzel = new Double[N+1];
        uzel[0] = 0.;
        for (int i = 1; i < N + 1; i++) {
            uzel[i] = uzel[i - 1] + h[i];
//            System.out.println("uzel["+i+"]" + uzel[i]);
        }
        System.out.println();
        return uzel;
    }

//    public void findFunction(Double[] uzel, Function<Double, Double> function) {
//        for (int i = 0; i < N + 1; i++) {
//            f[i] = function.apply(uzel[i]);
//        }
//    }

    public ArrayList<Double[]> ABCF(Double epsilon, Double[] h, Double delta, Function<Double, Double> function, Integer method, Function<Double, Double> Phi) {
        ArrayList<Double[]> list = new ArrayList<Double[]>();
        Double[] phi = new Double[N+1];
        Double[] phiDelta = new Double[N+1];
        Double[] uzel = findPoints(h);
        for (int i = 0; i < N + 1; i++) {
            phi[i] = Phi.apply(uzel[i]);
            phiDelta[i] = Phi.apply(uzel[i]-delta);
        }
        if (method == 0) {
            System.out.println("method0 = " + method);
            list = classicTeylorFormulasScheme(epsilon, h, delta, function, uzel);
        }
        if (method == 1) {
            list = modifiedTeylorFormulasScheme(epsilon, h, delta, phi, phiDelta, function, uzel);
            System.out.println("method1 = " + method);
        }
//        findFunction(uzel, function);
//        System.out.println(A[1]);
//        System.out.println(B[1]);
//        System.out.println(C[1]);
//        System.out.println(f[1]);
//        list.add(A);
//        list.add(B);
//        list.add(C);
//        list.add(f);

//        new DifferenceScheme(N);
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
