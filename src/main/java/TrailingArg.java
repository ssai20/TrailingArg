import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

public class TrailingArg {
    public static void main(String[] args) throws IOException {
        ThomasMethod thomasMethod = new ThomasMethod();
        ExamineSolution examineSolution = new ExamineSolution();
        Double epsilon = 1.e-04;
        int oddsNumber = 100;
        Double delta = 1.e-05;//0.;//0.01*epsilon;// 0.;// 10*epsilon;
        DifferenceScheme differenceScheme = new DifferenceScheme(oddsNumber);
        Function<Double, Double> solution = x -> Math.cos(Math.PI * x / 2.) + Math.exp(-x / epsilon);
        Function<Double, Double> function = x -> -Math.cos(Math.PI * x / 2.) * (Math.PI * Math.PI * epsilon / 4.) - Math.PI / 2. * Math.sin(Math.PI * x / 2.) - Math.exp((delta - x) / epsilon) - Math.cos(Math.PI * (x - delta) / 2.);
        Function<Double, Double> Phi = x -> Math.exp(-x / epsilon);
        Function<Double, Double> PhiDer = x -> -Math.exp(-x / epsilon) / epsilon;
        Function<Double, Double> PhiSecDer = x -> Math.exp(-x / epsilon) / epsilon / epsilon;
        Function<Double, Double> uSimple = x -> Math.exp(-x / epsilon) + Math.cos(Math.PI * x / 2.);
        Function<Double, Double> uSimpleDer = x -> -Math.exp(-x / epsilon) / epsilon - Math.PI * Math.sin(Math.PI * x / 2.) / 2.;
        Function<Double, Double> uSimpleSecDer = x -> Math.exp(-x / epsilon) / epsilon / epsilon -  Math.PI * Math.PI * Math.cos(Math.PI * x / 2.) / 4.;
        Double h[] = GridDesign.setkaShishkina(epsilon, oddsNumber);
        Double hSimple[] = GridDesign.ravnomSetka(oddsNumber);
        Double[] uzelSimple = differenceScheme.findPoints(h);
        ArrayList<Double[]> listClassic = differenceScheme.ABCF(epsilon, h, delta, function, 0, Phi);
        ArrayList<Double[]> listModificated = differenceScheme.ABCF(epsilon, h, delta, function, 1, Phi);
        Double[] uzel = differenceScheme.findPoints(h);
        Double[] uClassic = thomasMethod.progonka(listClassic.get(0), listClassic.get(1), listClassic.get(2), listClassic.get(3), oddsNumber, epsilon);
        Double uModified[] = thomasMethod.progonka(listModificated.get(0), listModificated.get(1), listModificated.get(2), listModificated.get(3), oddsNumber, epsilon);
        Double errorNormClassic = examineSolution.errorNorm(uClassic, oddsNumber, solution, uzel);
        Double errorNormModified = examineSolution.errorNorm(uModified, oddsNumber, solution, uzel);
        System.out.println("error norm classic  = " + errorNormClassic);
        System.out.println("error norm modified = " + errorNormModified);
        SimpleFormulas simpleFormulas = new SimpleFormulas();
        System.out.println("error equation with Teylor classic formulas = " + simpleFormulas.classicTeylorForExp(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple));
        System.out.println("error equation with Teylor modified formulas = " + simpleFormulas.modifiedTeylorForExp(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple, Phi, PhiDer));

//        System.out.println("error STRAIGHT equation with Teylor classic formulas = " + simpleFormulas.classicTeylorForExpStraight(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple));
//        System.out.println("error STRAIGHT equation with Teylor modified formulas = " + simpleFormulas.modifiedTeylorForExpStraight(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple, Phi, PhiDer));
        System.out.println("error STRAIGHT SIMPLE equation with Teylor classic formulas = " + simpleFormulas.classicTeylorSimple(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple));
        System.out.println("error STRAIGHT SIMPLE equation with Teylor modified formulas = " + simpleFormulas.modifiedTeylorSimple(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple, Phi, PhiDer));

        System.out.println("error STRAIGHT SIMPLE equation with Teylor classic formulas Second derivative = " + simpleFormulas.classicTeylorSimpleSecondDer(epsilon, uzelSimple, delta, uSimpleDer, uSimpleSecDer, oddsNumber, uSimple));
        System.out.println("error STRAIGHT SIMPLE equation with Teylor modified formulas Second derivative = " + simpleFormulas.modifiedTeylorSimpleSecondDer(epsilon, uzelSimple, delta, uSimpleDer, uSimpleSecDer, oddsNumber, uSimple, Phi, PhiDer, PhiSecDer));

        double[] a = new double[5];
        double[] b = new double[5];
        for (int i=0;i<5;i++) {
            a[i] = simpleFormulas.classicTeylorSimpleSecondDer(epsilon, uzelSimple, delta, uSimpleDer, uSimpleSecDer, oddsNumber, uSimple);
            b[i] = simpleFormulas.modifiedTeylorSimpleSecondDer(epsilon, uzelSimple, delta, uSimpleDer, uSimpleSecDer, oddsNumber, uSimple, Phi, PhiDer, PhiSecDer);
        }
        Latex latex = new Latex("/home/funforces/Dissertation/TrailingArg/latex/abc.tex");

        latex.latexHeadDocument();

        latex.latexTableInitial();

//        latex.latexTable(a ,b);
        latex.latexTableEnd();

        latex.latexEndDocument();
        latex.compileAndOpenPDFFile();
    }

}
