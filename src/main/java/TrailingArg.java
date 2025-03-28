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
        Function<Double, Double> uSimpleSecDer = x -> Math.exp(-x / epsilon) / epsilon / epsilon - Math.PI * Math.PI * Math.cos(Math.PI * x / 2.) / 4.;
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

        String[][] classic = new String[5][5];
        String[][] modified = new String[5][5];
        double a;
        double b;
        int i = 0;
        for (double e = 1; e >= 1.e-04; e = e / 10.) {
            int j = 0;
            for (double d = 1.e-01; d >= 1.e-05; d = d / 10.) {
                double finalE = e;
//                Function<Double, Double> solution = x -> Math.cos(Math.PI * x / 2.) + Math.exp(-x / epsilon);
//                Function<Double, Double> function = x -> -Math.cos(Math.PI * x / 2.) * (Math.PI * Math.PI * epsilon / 4.) - Math.PI / 2. * Math.sin(Math.PI * x / 2.) - Math.exp((delta - x) / epsilon) - Math.cos(Math.PI * (x - delta) / 2.);
                Function<Double, Double> Phi2 = x -> Math.exp(-x / finalE);
                Function<Double, Double> PhiDer2 = x -> -Math.exp(-x / finalE) / finalE;
                Function<Double, Double> PhiSecDer2 = x -> Math.exp(-x / finalE) / finalE / finalE;
                Function<Double, Double> uSimple2 = x -> Math.exp(-x / finalE) + Math.cos(Math.PI * x / 2.);
                Function<Double, Double> uSimpleDer2 = x -> -Math.exp(-x / finalE) / finalE - Math.PI * Math.sin(Math.PI * x / 2.) / 2.;
                Function<Double, Double> uSimpleSecDer2 = x -> Math.exp(-x / finalE) / finalE / finalE - Math.PI * Math.PI * Math.cos(Math.PI * x / 2.) / 4.;



                a = simpleFormulas.classicTeylorSimpleSecondDer(e, uzelSimple, d, uSimpleDer2, uSimpleSecDer2, oddsNumber, uSimple2);
                b = simpleFormulas.modifiedTeylorSimpleSecondDer(e, uzelSimple, d, uSimpleDer2, uSimpleSecDer2, oddsNumber, uSimple2, Phi2, PhiDer2, PhiSecDer2);
                classic[i][j] = String.format("%6.2e", a).replace(",", ".");
                modified[i][j] = String.format("%6.2e", b).replace(",", ".");
                System.out.println("i = "+i+"j = "+j+" = "+modified[i][j]);
                j++;
            }
            i++;
        }



        Latex latex = new Latex("/home/funforces/Dissertation/TrailingArg/latex/abc14.tex");
        latex.latexHeadDocument();
//        latex.latexTable(classic,modified);
        latex.latexTableInitial();

        latex.latexTable(classic, modified);

        latex.latexTableEnd();

        latex.latexEndDocument();
        latex.compileAndOpenPDFFile();
    }

}
