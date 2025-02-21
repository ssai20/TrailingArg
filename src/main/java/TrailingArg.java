import java.util.ArrayList;
import java.util.function.Function;

public class TrailingArg {
    public static void main(String[] args) {
        ThomasMethod thomasMethod = new ThomasMethod();
        ExamineSolution examineSolution = new ExamineSolution();
        Double epsilon = 1.;
        int oddsNumber = 10;
        DifferenceScheme differenceScheme = new DifferenceScheme(oddsNumber);
        Double delta = 0.;
        Function<Double, Double> solution = x -> Math.cos(Math.PI*x/2.) + Math.exp(-x/epsilon);
//        Function<Double, Double> function = x -> - Math.cos(Math.PI*x/2.)*(1 + Math.PI*Math.PI*epsilon/4.) - Math.PI/2.*Math.sin(Math.PI*x/2.) - Math.exp(-x/epsilon);
        Function<Double, Double> function = x -> - Math.cos(Math.PI*x/2.)*(Math.PI*Math.PI*epsilon/4.) - Math.PI/2.*Math.sin(Math.PI*x/2.) - Math.exp((delta-x)/epsilon) - Math.cos(Math.PI*(x-delta)/2.);
//        Function<Double, Double> solution = x -> Math.exp(-x/epsilon) + Math.cos(Math.PI*x/2.);
//        Function<Double, Double> function = x -> (1./epsilon);
        Function<Double, Double> Phi = x -> Math.exp (-x/epsilon);
        Double h[] = GridDesign.setkaShishkina(epsilon, oddsNumber);
        ArrayList<Double[]> listClassic = differenceScheme.ABCF(epsilon, h, delta, function, 0, Phi);
//        ArrayList<double[]> listModificated = differenceScheme.ABCF(epsilon, h, delta, function, 1, Phi);
        Double[] uzel = differenceScheme.findPoints(h);
        Double[] uClassic = thomasMethod.progonka(listClassic.get(0), listClassic.get(1), listClassic.get(2), listClassic.get(3), oddsNumber, epsilon);
//        double uModified[] = thomasMethod.progonka(listModificated.get(0), listModificated.get(1), listModificated.get(2), listModificated.get(3), oddsNumber, epsilon);
        Double errorNormClassic = examineSolution.errorNorm(uClassic, oddsNumber, solution, uzel);
//        double errorNormModified = examineSolution.errorNorm(uModified, oddsNumber, solution, uzel);
        System.out.println("error norm classic = "+errorNormClassic);
//        System.out.println("error norm modified = "+errorNormModified);
//        for (int i= 0; i<oddsNumber; i++) {
//            System.out.println(errorNormClassic[i]);
//        }
    }
}
