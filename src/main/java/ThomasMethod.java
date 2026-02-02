public class ThomasMethod {
    public ThomasMethod() {
    }

    public Double[] progonka(Double[] A, Double[] B, Double[] C, Double[] F, Integer N, Double epsilon) {
        Double[] alpha = new Double[N + 1];
        Double[] betta = new Double[N + 1];
        Double[] c = new Double[N + 1];
        Integer iteration = 0;
        alpha[0] = 0.;
        betta[0] = 2.;//Math.exp(-1. / epsilon);
        for (int i = 0; i < N; i++) {
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
//
//public class ThomasMethod {
//    public ThomasMethod() {
//    }
//
//    public Double[] progonka(Double[] A, Double[] B, Double[] C, Double[] F, Integer N, Double epsilon) {
//        try {
//            System.out.println("=== Начало метода прогонки ===");
//            System.out.println("N = " + N + ", точек = " + (N+1));
//
//            // Проверка входных данных
//            if (A == null || B == null || C == null || F == null) {
//                throw new IllegalArgumentException("Один из массивов равен null");
//            }
//
//            // Создаем массивы
//            Double[] x = new Double[N + 1];
//            Double[] alpha = new Double[N + 1];
//            Double[] beta = new Double[N + 1];
//
//            // Инициализируем нулями
//            for (int i = 0; i <= N; i++) {
//                alpha[i] = 0.0;
//                beta[i] = 0.0;
//                x[i] = 0.0;
//            }
//
//            // ПРЯМОЙ ХОД
//            System.out.println("Прямой ход прогонки...");
//
//            // Для i=0
//            if (Math.abs(B[0]) < 1e-15) {
//                B[0] = 1.0; // Корректировка, если B[0] = 0
//                System.out.println("Внимание: B[0] был 0, исправлено на 1.0");
//            }
//
//            alpha[0] = -C[0] / B[0];
//            beta[0] = F[0] / B[0];
//
//            System.out.println("alpha[0] = " + alpha[0] + ", beta[0] = " + beta[0]);
//
//            // Для i=1..N-1
//            for (int i = 1; i < N; i++) {
//                double denominator = B[i] + A[i] * alpha[i-1];
//
//                // Защита от деления на 0
//                if (Math.abs(denominator) < 1e-15) {
//                    denominator = 1e-15;
//                    System.out.println("Внимание: малый знаменатель на i=" + i);
//                }
//
//                alpha[i] = -C[i] / denominator;
//                beta[i] = (F[i] - A[i] * beta[i-1]) / denominator;
//
//                if (i % 20 == 0) { // Вывод каждые 20 точек
//                    System.out.println("i=" + i + ": alpha=" + alpha[i] + ", beta=" + beta[i]);
//                }
//            }
//
//            // ОБРАТНЫЙ ХОД
//            System.out.println("Обратный ход прогонки...");
//
//            // Для i=N
//            double denominatorN = B[N] + A[N] * alpha[N-1];
//            if (Math.abs(denominatorN) < 1e-15) {
//                denominatorN = 1e-15;
//                System.out.println("Внимание: малый знаменатель для i=N");
//            }
//
//            x[N] = (F[N] - A[N] * beta[N-1]) / denominatorN;
//            System.out.println("x[" + N + "] = " + x[N]);
//
//            // Для i=N-1..0
//            for (int i = N - 1; i >= 0; i--) {
//                x[i] = alpha[i] * x[i+1] + beta[i];
//
//                if (i % 20 == 0) { // Вывод каждые 20 точек
//                    System.out.println("x[" + i + "] = " + x[i]);
//                }
//            }
//
//            System.out.println("=== Метод прогонки завершен успешно ===");
//            System.out.println("x[0] = " + x[0] + ", x[" + N + "] = " + x[N]);
//
//            return x;
//
//        } catch (Exception e) {
//            System.err.println("ОШИБКА в методе прогонки: " + e.getMessage());
//            e.printStackTrace();
//
//            // Возвращаем хотя бы нули
//            Double[] errorResult = new Double[N + 1];
//            for (int i = 0; i <= N; i++) {
//                errorResult[i] = 0.0;
//            }
//            return errorResult;
//        }
//    }
//}