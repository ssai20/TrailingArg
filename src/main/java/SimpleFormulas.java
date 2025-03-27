import java.util.function.Function;

public class SimpleFormulas {
    public SimpleFormulas() {
    }

    public double classicTeylorForExp(double epsilon, Double uzel[], double delta, Function<Double, Double> uDer, int N, Function<Double, Double> function) {
        double[] uNorm = new double[N + 1];
        for (int i = 0; i < N + 1; i++) {
            if (uzel[i] > delta) {
                function = x -> 0.;
            }
            uNorm[i] = Math.abs(1. * (function.apply(uzel[i]) - delta * uDer.apply(uzel[i]) - function.apply(uzel[i] - delta)));
//            uNorm[i] = epsilon * (function.apply(uzel[i]) - delta*uDer.apply(uzel[i]) + delta*delta/(2.*epsilon*epsilon)* function.apply(uzel[i]) - function.apply(uzel[i] - delta));

            if (uzel[i] <= delta) {
                uNorm[i] = 0.;
            }
        }
        double max = 0;
        for (int i = 0; i < N + 1; i++) {
            if (uNorm[i] > max) max = uNorm[i];
        }
        return max;
    }


    public double classicTeylorForExpStraight(double epsilon, Double uzel[], double delta, Function<Double, Double> uDer, int N, Function<Double, Double> function) {
        double[] uNorm = new double[N + 1];
        for (int i = 0; i < N + 1; i++) {
//            if (uzel[i] > delta) {
//                function = x -> 0.;
//            }
            uNorm[i] = Math.abs(1. * (function.apply(uzel[i]) + delta * uDer.apply(uzel[i]) - function.apply(uzel[i] + delta)));
//            uNorm[i] = epsilon * (function.apply(uzel[i]) - delta*uDer.apply(uzel[i]) + delta*delta/(2.*epsilon*epsilon)* function.apply(uzel[i]) - function.apply(uzel[i] - delta));

//            if (uzel[i] <= delta) {
//                uNorm[i] = 0.;
//            }
        }
        double max = 0;
        for (int i = 0; i < N + 1; i++) {
            if (uNorm[i] > max) max = uNorm[i];
        }
        return max;
    }

    public double modifiedTeylorForExp(double epsilon, Double uzel[], double delta, Function<Double, Double> uDer,
                                       int N, Function<Double, Double> function, Function<Double, Double> Phi, Function<Double, Double> PhiDer) {
        double[] uNorm = new double[N + 1];
        for (int i = 0; i < N + 1; i++) {
            if (uzel[i] > delta) {
                function = x -> 0.;
            }
            uNorm[i] = Math.abs(1. * (function.apply(uzel[i]) - uDer.apply(uzel[i]) / PhiDer.apply(uzel[i]) * (Phi.apply(uzel[i]) - Phi.apply(uzel[i] - delta)) - function.apply(uzel[i] - delta)));
//            System.out.println(uNorm[i]);

            if (uzel[i] > delta) {
                uNorm[i] = 0.;
            }
        }
        double max = 0;
        for (int i = 0; i < N + 1; i++) {
            if (uNorm[i] > max) max = uNorm[i];
        }
        return max;
    }


    public double modifiedTeylorForExpStraight(double epsilon, Double uzel[], double delta, Function<Double, Double> uDer,
                                               int N, Function<Double, Double> function, Function<Double, Double> Phi,
                                               Function<Double, Double> PhiDer) {
        double[] uNorm = new double[N + 1];
        for (int i = 0; i < N + 1; i++) {
//            if (uzel[i] > delta) {
//                function = x -> 0.;
//            }
            uNorm[i] = Math.abs(function.apply(uzel[i]) + (uDer.apply(uzel[i]) / PhiDer.apply(uzel[i])) * (Phi.apply(uzel[i] + delta) -
                    Phi.apply(uzel[i])) - function.apply(uzel[i] + delta));
//            System.out.println(uNorm[i]);

//            if (uzel[i] > delta) {
//                uNorm[i] = 0.;
//            }
        }
        double max = 0;
        for (int i = 0; i < N + 1; i++) {
            if (uNorm[i] > max) max = uNorm[i];
        }
        return max;
    }

    public double classicTeylorSimple(double epsilon, Double uzel[], double delta, Function<Double, Double> uDer, int N, Function<Double, Double> function) {
        double[] uNorm = new double[N + 1];
//        for (int i = 0; i < N + 1; i++) {
            double max = Math.abs(1. * (function.apply(0.) + delta * uDer.apply(0.) - function.apply(0. + delta)));
//        }
//        double max = 0;
//        for (int i = 0; i < N + 1; i++) {
//            if (uNorm[i] > max) max = uNorm[i];
//        }
        return max;
    }

    public double modifiedTeylorSimple(double epsilon, Double uzel[], double delta, Function<Double, Double> uDer,
                                               int N, Function<Double, Double> function, Function<Double, Double> Phi,
                                               Function<Double, Double> PhiDer) {
//        double[] uNorm = new double[N + 1];
//        for (int i = 0; i < N + 1; i++) {
//            if (uzel[i] > delta) {
//                function = x -> 0.;
//            }
            double max = Math.abs(function.apply(0.) + (uDer.apply(0.) / PhiDer.apply(0.)) * (Phi.apply(0. + delta) -
                    Phi.apply(0.)) - function.apply(0. + delta));
//            System.out.println(uNorm[i]);

//            if (uzel[i] > delta) {
//                uNorm[i] = 0.;
//            }
//        }
//        double max = 0;
//        for (int i = 0; i < N + 1; i++) {
//            if (uNorm[i] > max) max = uNorm[i];
//        }
        return max;
    }

}

