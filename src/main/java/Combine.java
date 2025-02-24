import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class Combine {
    private String filePath;
    public Latex latex;
    private Finding finding = new Finding();
    public Combine (String filePath) {
        this.filePath = filePath;
        latex = new Latex(filePath.concat("name").concat(".tex"));
    }

        public void latexTable() throws FileNotFoundException, UnsupportedEncodingException {
            String residual[][] = new String[7][6];
            String oac[][] = new String[7][6];
    //        double a = 0.;
            //double epsilon = 1./1.;
    //        int node = 5;
    //        Derivative firstDerivative = new Derivative(node, x -> Math.cos(Math.PI * x) + Math.exp(-x/(epsilon)), x -> -Math.PI*Math.sin(Math.PI*x) - Math.exp(-x/epsilon)/epsilon, x -> Math.exp(-x/epsilon), x -> -Math.exp(-x/epsilon)/epsilon);
            latex.latexInitial();
            int kRes=0;
            int kOa=0;
            Double delta = 0.;
            for (int eps = 8;eps<=512;eps=eps*2) {
                if (eps==8.) eps = 1;
                double a = 0.;
                double epsilon = 1./eps;
                int lRes=0;
                int lOa=0;
                for (int i = 32; i <= 1024; i = 2 * i) {
                    double b = finding.find(epsilon, i, delta);
                    String formattedDouble = String.format("%6.2e", b).replace(",", ".");
                    double four = a / b;
                    double oa = Math.log10(four) / Math.log10(2.);
                    java.text.NumberFormat formatterOa = new java.text.DecimalFormat("0.#");
                    String formattedDoubleOa = formatterOa.format(oa).replace(",", ".").replace("E", "e");
                    a = b;
                    residual[kRes][lRes] = formattedDouble;
                    lRes++;
                    oac[kOa][lOa] = formattedDoubleOa;
                    lOa++;
                }
                kRes++;
                kOa++;
                if (eps==1.) eps = 8;
            }
//            latexTable(residual, oac);
            latex.latexEnd();
        }
}
