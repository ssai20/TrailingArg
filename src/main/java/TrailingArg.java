import java.util.ArrayList;
import java.util.function.Function;

public class TrailingArg {
    public static void main(String[] args) {
        ThomasMethod thomasMethod = new ThomasMethod();
        ExamineSolution examineSolution = new ExamineSolution();
        double epsilon = 1.;
        int oddsNumber = 20;
        DifferenceScheme differenceScheme = new DifferenceScheme(oddsNumber);
        double delta = 0.;
        Function<Double, Double> solution = x -> Math.cos(Math.PI*x/2.) + Math.exp(-x/epsilon);
        Function<Double, Double> function = x -> - Math.exp(delta - x)/epsilon -
                - Math.PI * Math.PI*epsilon /(4) *Math.cos((Math.PI * x)/2.) -
                - Math.PI/2. * Math.sin((Math.PI *x)/2.) - Math.cos((x-delta)*Math.PI/2.);
        Function<Double, Double> Phi = x -> Math.exp (-x/epsilon);
        double [] h = GridDesign.setkaShishkina(epsilon, oddsNumber);
        ArrayList<double[]> listClassic = differenceScheme.ABCF(epsilon, h, delta, function, 0, Phi);
//        ArrayList<double[]> listModificated = differenceScheme.ABCF(epsilon, h, delta, function, 1, Phi);
        double[] uzel = differenceScheme.findPoints(h);
        double uClassic[] = thomasMethod.progonka(listClassic.get(0), listClassic.get(1), listClassic.get(2), listClassic.get(3), oddsNumber, epsilon);
//        double uModified[] = thomasMethod.progonka(listModificated.get(0), listModificated.get(1), listModificated.get(2), listModificated.get(3), oddsNumber, epsilon);

        double errorNormClassic = examineSolution.errorNorm(uClassic, oddsNumber, solution, uzel);
//        double errorNormModified = examineSolution.errorNorm(uModified, oddsNumber, solution, uzel);
        System.out.println("error norm classic = "+errorNormClassic);
//        System.out.println("error norm modified = "+errorNormModified);
//        for (int i= 0; i<oddsNumber; i++) {
//            System.out.println(errorNorm[i]);
//        }
    }
}
