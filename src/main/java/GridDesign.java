//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
//
//class GridDesign {
//    public GridDesign() {
//    }
//
//    public static BigDecimal[] ravnomSetka(int N) {
//        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
//
//        BigDecimal[] h = new BigDecimal[N + 1];
//        BigDecimal step = BigDecimal.ONE.divide(new BigDecimal(N), mc);
//
//        for (int i = 0; i < N + 1; i++) {
//            h[i] = step;
//        }
//        return h;
//    }
//
//    public static BigDecimal[] setkaShishkina(BigDecimal epsilon, int N) {
//        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
//
//        BigDecimal[] h = new BigDecimal[N + 1];
//        double epsilonVal = epsilon.doubleValue();
//        double sigmaVal = Math.min(0.5, 4. * epsilonVal * Math.log(N * 1.) / 1.);
//        BigDecimal sigma = new BigDecimal(sigmaVal);
//
//        for (int i = 0; i <= N; i++) {
//            if ((i <= N / 2.) && (i >= 0.)) {
//                h[i] = BigDecimal.valueOf(2).multiply(sigma, mc).divide(new BigDecimal(N), mc);
//            }
//            if ((i <= N) && (i > N / 2.)) {
//                BigDecimal oneMinusSigma = BigDecimal.ONE.subtract(sigma, mc);
//                h[i] = BigDecimal.valueOf(2).multiply(oneMinusSigma, mc).divide(new BigDecimal(N), mc);
//            }
//        }
//
//        return h;
//    }
//
//    public static BigDecimal[] setkaBakhvalova(BigDecimal epsilon, int N) {
//        MathContext mc = MathContext.DECIMAL64;
//        BigDecimal[] h = new BigDecimal[N + 1];
//
//        BigDecimal one = BigDecimal.ONE;
//        BigDecimal two = BigDecimal.valueOf(2);
//        BigDecimal four = BigDecimal.valueOf(4);
//        BigDecimal Nbd = BigDecimal.valueOf(N);
//        BigDecimal half = BigDecimal.valueOf(0.5);
//        BigDecimal negativeFour = BigDecimal.valueOf(-4);
//
//        BigDecimal expMinusOne = BigDecimal.valueOf(Math.exp(-1));
//
//        if (epsilon.compareTo(expMinusOne) <= 0) {
//            BigDecimal logEpsilon = BigDecimal.valueOf(Math.log(epsilon.doubleValue()));
//            BigDecimal sigma = half.min(negativeFour.multiply(epsilon.multiply(logEpsilon, mc), mc));
//
//            if (sigma.compareTo(half) == 0) {
//                // Равномерная сетка
//                BigDecimal step = one.divide(Nbd, mc);
//                for (int i = 0; i <= N; i++) {
//                    h[i] = step;
//                }
//            } else {
//                // Неравномерная сетка с аналитическими шагами
//                BigDecimal oneMinusEps = one.subtract(epsilon, mc);
//                BigDecimal twoOneMinusEps = two.multiply(oneMinusEps, mc);
//
//                // Первая половина - экспоненциальное сгущение
//                for (int i = 1; i <= N / 2; i++) {
//                    BigDecimal iMinus1 = BigDecimal.valueOf(i - 1);
//                    BigDecimal iDivN = BigDecimal.valueOf(i).divide(Nbd, mc);
//                    BigDecimal iMinus1DivN = iMinus1.divide(Nbd, mc);
//
//                    // Аналитическая формула для шага:
//                    // h[i-1] = -4ε * [ln(1-2(1-ε)i/N) - ln(1-2(1-ε)(i-1)/N)]
//                    BigDecimal termI = one.subtract(twoOneMinusEps.multiply(iDivN, mc), mc);
//                    BigDecimal termIMinus1 = one.subtract(twoOneMinusEps.multiply(iMinus1DivN, mc), mc);
//
//                    // Защита от отрицательных аргументов
//                    if (termI.compareTo(BigDecimal.ZERO) <= 0) termI = BigDecimal.valueOf(1e-15);
//                    if (termIMinus1.compareTo(BigDecimal.ZERO) <= 0) termIMinus1 = BigDecimal.valueOf(1e-15);
//
//                    double logTermI = Math.log(termI.doubleValue());
//                    double logTermIMinus1 = Math.log(termIMinus1.doubleValue());
//
//                    h[i - 1] = negativeFour.multiply(epsilon, mc)
//                            .multiply(BigDecimal.valueOf(logTermI - logTermIMinus1), mc);
//                }
//
//                // Вторая половина - линейная часть
//                BigDecimal oneMinusSigma = one.subtract(sigma, mc);
//                BigDecimal linearStep = two.multiply(oneMinusSigma, mc).divide(Nbd, mc);
//
//                for (int i = N / 2; i <= N; i++) {
//                    h[i] = linearStep;
//                }
//
//                // Коррекция для центрального перехода
//                BigDecimal uzelx_N2_minus1 = negativeFour.multiply(epsilon, mc)
//                        .multiply(BigDecimal.valueOf(Math.log(one.subtract(
//                                twoOneMinusEps.multiply(BigDecimal.valueOf(N/2 - 1).divide(Nbd, mc), mc), mc
//                        ).doubleValue())), mc);
//
//                BigDecimal uzelx_N2 = sigma; // uzelx[N/2] = sigma
//                h[N/2 - 1] = uzelx_N2.subtract(uzelx_N2_minus1, mc);
//            }
//        } else {
//            // epsilon > exp(-1) - равномерная сетка
//            BigDecimal step = one.divide(Nbd, mc);
//            for (int i = 0; i <= N; i++) {
//                h[i] = step;
//            }
//        }
//
//        return h;
//    }
//
//
//}




import java.util.function.Function;

public class GridDesign {
    public GridDesign() {
    }

    public static Double[] ravnomSetka(int N) {
//        System.out.println("Uniform mesh");
        Double[] h = new Double[N + 1];
        for (int i = 0; i < N + 1; i++) {
            h[i] = 1. / N;
        }
        return h;
    }

    public static Double[] setkaShishkina(Double epsilon, int N) {
        Double[] h = new Double[N + 1];
        Double sigma = Math.min(0.5, 4. * epsilon * Math.log(N * 1.) / 1.);

        for (int i = 0; i <= N; i++) {
            if ((i <= N / 2.) && (i >= 0.)) {
                h[i] = 2. * sigma / N;
                System.out.println("h[" + i + "] = " + h[i]);
            }
            if ((i <= N) && (i > N / 2.)) {
                h[i] = 2. * (1. - sigma) / N;
                System.out.println("h[" + i + "] = " + h[i]);
            }
        }

        return h;
    }

    public static Double[] setkaBakhvalova(double epsilon, int N) {
        Double[] h = new Double[N + 1];

        if (epsilon <= Math.exp(-1)) {
            double sigma = Math.min(0.5, (-4.) * epsilon * Math.log(epsilon));

            if (sigma == 0.5) {
                // Равномерная сетка
                h[N] = 1. / N;
                for (int i = 0; i < N; i++) {
                    h[i] = 1. / N;
                }
            }

            if (sigma < 0.5) {
                // Явное вычисление первого шага
                double term1 = 1. - 2. * (1. - epsilon) * 1. / N;
                if (term1 <= 0) term1 = 1e-15;
                h[0] = (-4. * epsilon) * Math.log(term1);

                // Аналитическое вычисление шагов для первой половины
                // h[i-1] = -4ε * [ln(1-2(1-ε)i/N) - ln(1-2(1-ε)(i-1)/N)]
                for (int i = 2; i <= N / 2; i++) {
                    double termI = 1. - 2. * (1. - epsilon) * i / N;
                    double termIMinus1 = 1. - 2. * (1. - epsilon) * (i - 1) / N;

                    if (termI <= 0) termI = 1e-15;
                    if (termIMinus1 <= 0) termIMinus1 = 1e-15;

                    h[i - 1] = (-4. * epsilon) * (Math.log(termI) - Math.log(termIMinus1));
                }

                // Линейная часть - константные шаги
                double linearStep = 2. * (1. - sigma) / N;
                for (int i = N / 2; i <= N; i++) {
                    h[i] = linearStep;
                }

                // Коррекция центрального шага для сохранения точной позиции sigma
                if (N / 2 > 0) {
                    double uzelx_N2_minus1 = 0.;
                    for (int i = 1; i < N / 2; i++) {
                        uzelx_N2_minus1 += h[i - 1];
                    }
                    h[N / 2 - 1] = sigma - uzelx_N2_minus1;
                }

                // Гарантия положительности шагов
                double minStep = epsilon * 1e-10;
                for (int i = 0; i <= N; i++) {
                    if (h[i] < minStep) {
                        h[i] = minStep;
                    }
                }
            }
        }

        if (epsilon > Math.exp(-1.)) {
            // Равномерная сетка
            h[N] = 1. / N;
            for (int i = 0; i < N; i++) {
                h[i] = 1. / N;
            }
        }

        return h;
    }

//    public static void findPoints(int N, Double[] h, Double[] uzel) {
//        uzel[0] = 0.;
//        for (int i = 1; i < N + 1; i++) {
//            uzel[i] = uzel[i - 1] + h[i];
////            System.out.println(uzel[i]);
//        }
//    }


    public static void findFunction(int N, Double[] f, Double[] uzel, Function<Double, Double> function) {
        for (int i = 0; i < N + 1; i++) {
            f[i] = function.apply(uzel[i]);
//            System.out.println(i+" = "+f[i]);
        }
    }
}