import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

public class TrailingArg {
    public static void main(String[] args) throws IOException {
        ThomasMethod thomasMethod = new ThomasMethod();
        ExamineSolution examineSolution = new ExamineSolution();
//        double epsilon = 1.;
//        int oddsNumber = 1000;
//        Double d = 1.e-03;//*epsilon;//0.;//1.e-05;//0.01*epsilon;// 0.;// 10*epsilon;
//        DifferenceScheme differenceScheme = new DifferenceScheme(oddsNumber);
//        Function<Double, Double> solution = x -> Math.cos(Math.PI * x / 2.) + Math.exp(-x / epsilon);
//        Function<Double, Double> function = x -> -Math.cos(Math.PI * x / 2.) * (Math.PI * Math.PI * epsilon / 4.) - Math.PI / 2. * Math.sin(Math.PI * x / 2.) -
//                -Math.exp((delta - x) / epsilon) - Math.cos(Math.PI * (x - delta) / 2.);
//        Function<Double, Double> Phi = x -> Math.exp(-x / epsilon);
//        Function<Double, Double> PhiDer = x -> -Math.exp(-x / epsilon) / epsilon;
//        Function<Double, Double> PhiSecDer = x -> Math.exp(-x / epsilon) / epsilon / epsilon;
//        Function<Double, Double> uSimple = x -> Math.exp(-x / epsilon) + Math.cos(Math.PI * x / 2.);
//        Function<Double, Double> uSimpleDer = x -> -Math.exp(-x / epsilon) / epsilon - Math.PI * Math.sin(Math.PI * x / 2.) / 2.;
//        Function<Double, Double> uSimpleSecDer = x -> Math.exp(-x / epsilon) / epsilon / epsilon - Math.PI * Math.PI * Math.cos(Math.PI * x / 2.) / 4.;
//        Double h[] = GridDesign.setkaShishkina(epsilon, oddsNumber);
//        Double hSimple[] = GridDesign.ravnomSetka(oddsNumber);
//        Double[] uzelSimple = differenceScheme.findPoints(h);
//        ArrayList<Double[]> listClassic = differenceScheme.ABCF(epsilon, h, delta, function, 0, Phi);
//        ArrayList<Double[]> listModificated = differenceScheme.ABCF(epsilon, h, delta, function, 1, Phi);
//        Double[] uzel = differenceScheme.findPoints(h);
//        Double[] uClassic = thomasMethod.progonka(listClassic.get(0), listClassic.get(1), listClassic.get(2), listClassic.get(3), oddsNumber, epsilon);
//        Double uModified[] = thomasMethod.progonka(listModificated.get(0), listModificated.get(1), listModificated.get(2), listModificated.get(3), oddsNumber, epsilon);
//        Double errorNormClassic = examineSolution.errorNorm(uClassic, oddsNumber, solution, uzel);
//        Double errorNormModified = examineSolution.errorNorm(uModified, oddsNumber, solution, uzel);
//        System.out.println("error norm classic  = " + errorNormClassic);
//        System.out.println("error norm modified = " + errorNormModified);
        SimpleFormulas simpleFormulas = new SimpleFormulas();
//        System.out.println("error equation with Teylor classic formulas = " + simpleFormulas.classicTeylorForExp(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple));
//        System.out.println("error equation with Teylor modified formulas = " + simpleFormulas.modifiedTeylorForExp(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple, Phi, PhiDer));

//        System.out.println("error STRAIGHT equation with Teylor classic formulas = " + simpleFormulas.classicTeylorForExpStraight(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple));
//        System.out.println("error STRAIGHT equation with Teylor modified formulas = " + simpleFormulas.modifiedTeylorForExpStraight(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple, Phi, PhiDer));
//        System.out.println("error STRAIGHT SIMPLE equation with Teylor classic formulas = " + simpleFormulas.classicTeylorSimple(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple));
//        System.out.println("error STRAIGHT SIMPLE equation with Teylor modified formulas = " + simpleFormulas.modifiedTeylorSimple(epsilon, uzelSimple, delta, uSimpleDer, oddsNumber, uSimple, Phi, PhiDer));
//
//        System.out.println("error STRAIGHT SIMPLE equation with Teylor classic formulas Second derivative = " + simpleFormulas.classicTeylorSimpleSecondDer(epsilon, uzelSimple, delta, uSimpleDer, uSimpleSecDer, oddsNumber, uSimple));
//        System.out.println("error STRAIGHT SIMPLE equation with Teylor modified formulas Second derivative = " + simpleFormulas.modifiedTeylorSimpleSecondDer(epsilon, uzelSimple, delta, uSimpleDer, uSimpleSecDer, oddsNumber, uSimple, Phi, PhiDer, PhiSecDer));

        String[][] classic = new String[9][5];
        String[][] modified = new String[9][5];
        double a;
        double b;
        int i = 0;
        for (double e = 1.; e >= 1.e-08; e = e / 10.) {
            int j = 0;
            for (int n = 128; n <= 2048; n = n * 2) {
                Double d = 0.;
                DifferenceScheme differenceScheme = new DifferenceScheme(n);
                double finalE = e;
//                Function<Double, Double> solution = x -> Math.cos(Math.PI * x / 2.) + Math.exp(-x / epsilon);
//                Function<Double, Double> function = x -> -Math.cos(Math.PI * x / 2.) * (Math.PI * Math.PI * epsilon / 4.) - Math.PI / 2. * Math.sin(Math.PI * x / 2.) - Math.exp((delta - x) / epsilon) - Math.cos(Math.PI * (x - delta) / 2.);
                Function<Double, Double> Phi2 = x -> Math.exp(-x / finalE);
                Function<Double, Double> PhiDer2 = x -> -Math.exp(-x / finalE) / finalE;
                Function<Double, Double> PhiSecDer2 = x -> Math.exp(-x / finalE) / finalE / finalE;
                Function<Double, Double> PhiThiDer2 = x -> -Math.exp(-x / finalE) / finalE / finalE / finalE;

//                Function<Double, Double> Phi2 = x -> Math.sqrt(x+finalE);
//                Function<Double, Double> PhiDer2 = x -> 0.5/Math.sqrt(x +finalE);
//                Function<Double, Double> PhiSecDer2 = x -> (-0.25)/(x+finalE)/Math.sqrt(x +finalE);
//                Function<Double, Double> PhiThiDer2 = x -> 3./8./(x+finalE)*(x+finalE)/Math.sqrt(x +finalE);

//                Function<Double, Double> Phi2 = x->Math.log(x+finalE);
//                Function<Double, Double> PhiDer2 = x -> 1./(x+finalE);
//                Function<Double, Double> PhiSecDer2 = x -> -1./(x+finalE)/(x+finalE);
//                Function<Double, Double> PhiThiDer2 = x -> 2./(x+finalE)/(x+finalE)/(x+finalE);

                Function<Double, Double> uSimple2 = x -> Phi2.apply(x) + Math.cos(Math.PI * x / 2.);
                Function<Double, Double> uSimpleDer2 = x -> PhiDer2.apply(x) - Math.PI * Math.sin(Math.PI * x / 2.) / 2.;
                Function<Double, Double> uSimpleSecDer2 = x -> PhiSecDer2.apply(x) - Math.PI * Math.PI * Math.cos(Math.PI * x / 2.) / 4.;
                Function<Double, Double> uSimpleThiDer2 = x -> PhiThiDer2.apply(x) + Math.PI * Math.PI * Math.PI * Math.sin(Math.PI * x / 2.) / 8.;

//                a = simpleFormulas.classicTrailingTeylorSimple(e, uzelSimple, d, uSimpleDer2, oddsNumber, uSimple2);
//                b = simpleFormulas.modifiedTrailingTeylorSimple(e, uzelSimple, d, uSimpleDer2, uSimpleSecDer2, oddsNumber, uSimple2, Phi2, PhiDer2, PhiSecDer2);
                double finalD = d;

                Function<Double, Double> solution = x -> Math.cos(Math.PI * x / 2.) + Math.exp(-x / finalE);
                Function<Double, Double> function = x -> -Math.cos(Math.PI * x / 2.) * (Math.PI * Math.PI * finalE / 4.) - Math.PI / 2. * Math.sin(Math.PI * x / 2.) -
                        -Math.exp((finalD - x) / finalE) - Math.cos(Math.PI * (x - finalD) / 2.);
//                Function<Double, Double> solution = x -> Math.cos(Math.PI * x / 2.);
//                Function<Double, Double> function = x -> -Math.cos(Math.PI * x / 2.) * (Math.PI * Math.PI * finalE / 4. +1.) - Math.PI / 2. * Math.sin(Math.PI * x / 2.);

                Function<Double, Double> Phi = x -> Math.exp(-x / finalE);
//                    Double[] h = GridDesign.setkaShishkina(e, n);
                    Double[] h = GridDesign.setkaBakhvalova(e, n);
//                Double[] h = GridDesign.ravnomSetka(n);
                ArrayList<Double[]> listClassic = differenceScheme.ABCF(e, h, d, function, 0, Phi);
                ArrayList<Double[]> listModificated = differenceScheme.ABCF(e, h, d, function, 1, Phi);
                Double[] uzel = differenceScheme.findPoints(h);
                Double[] uClassic = thomasMethod.progonka(listClassic.get(0), listClassic.get(1), listClassic.get(2), listClassic.get(3), n, e);
                Double[] uModified = thomasMethod.progonka(listModificated.get(0), listModificated.get(1), listModificated.get(2), listModificated.get(3), n, e);
                a = examineSolution.errorNorm(uClassic, n, solution, uzel);
                b = examineSolution.errorNorm(uModified, n, solution, uzel);

//                a = simpleFormulas.classicTeylorSimpleSecondDer(e, uzelSimple, d, uSimpleDer2, uSimpleSecDer2, oddsNumber, uSimple2);
//                b = simpleFormulas.modifiedTeylorSimpleSecondDer(e, uzelSimple, d, uSimpleDer2, uSimpleSecDer2, uSimpleThiDer2, oddsNumber, uSimple2, Phi2, PhiDer2, PhiSecDer2, PhiThiDer2);
//                a = simpleFormulas.classicTeylorSimple(e, uzelSimple, d, uSimpleDer2, oddsNumber, uSimple2);
//                b = simpleFormulas.modifiedTeylorSimple(e, uzelSimple, d, uSimpleDer2, uSimpleSecDer2, oddsNumber, uSimple2, Phi2, PhiDer2, PhiSecDer2);
                classic[i][j] = String.format("%6.2e", a).replace(",", ".");
                modified[i][j] = String.format("%6.2e", b).replace(",", ".");
                System.out.println("i = " + i + "j = " + j + " = " + modified[i][j]);
                j++;
            }
            i++;
        }


        Latex latex = new Latex("/home/funforces/Articles/Trailing/доклад/результаты/12feb2026/bh-delta-0eps1-00-1-08-N-128-2048-2.tex");
//        Latex latex = new Latex("/home/funforces/Dissertation/TrailingArg/latex/new - 000 epsilon-03-bahvalov-1000uzlov - 1000-0200-0.tex");
//        Latex latex = new Latex("/Users/work/Desktop/Аспирантура/Programms/TrailingArgByTeylorModificationFormulas/latex/Oh2001.tex");
        latex.latexHeadDocument();

        latex.latexTableInitial("сетка Бахвалова $\\delta = 0.$");

        latex.latexTable(classic, modified);

        latex.latexTableEnd();

        latex.latexEndDocument();
        latex.compileAndOpenPDFFile();
    }

}