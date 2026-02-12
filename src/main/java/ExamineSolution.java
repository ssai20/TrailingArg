//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Function;
//
//class ExamineSolution {
//    public BigDecimal errorNorm(BigDecimal[] u, int N, Function<BigDecimal, BigDecimal> solution, BigDecimal[] uzel) {
//        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
//
//        List<BigDecimal> norm = new ArrayList<>();
//        BigDecimal[] res = new BigDecimal[N + 1];
//        BigDecimal norma = BigDecimal.ZERO;
//
//        for (int i = 1; i < N; i++) {
//            BigDecimal exact = solution.apply(uzel[i]);
//            res[i] = exact.subtract(u[i], mc).abs();
//        }
//
//        for (int i = 1; i < N; i++) {
//            if (res[i].compareTo(norma) > 0) {
//                norma = res[i];
//            }
//        }
//
//        System.out.println("norma[" + N + "] = " + norma);
//        norm.add(norma);
//        return norma;
//    }
//}



import java.util.ArrayList;
import java.util.List;



import java.util.function.Function;

public class ExamineSolution {


    public Double errorNorm(Double[] u, int N, Function<Double, Double> solution, Double[] uzel) {
        List<Double> norm = new ArrayList<>();
        Double[] res = new Double[N+1];
        Double norma = 0.;
//        Double[] s = new Double[N+1];
        for (int i = 0; i < N+1; i++) {
//            System.out.print("sol["+i+"] = "+solution.apply(uzel[i]) + " ");
            res[i] = Math.abs(solution.apply(uzel[i]) - u[i]);
//            System.out.println("res["+i+"] = "+ res[i]);
        }
        System.out.println();

        //норма погрешности:
        for (int i = 0; i < N + 1; i++) {
            if (res[i] > norma) norma = res[i];
        }
        norm.add(norma);
        return norma;
    }
}