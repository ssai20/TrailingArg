import java.util.function.Function;

public class GridDesign {
    public GridDesign() {
    }

    public static double[] ravnomSetka(int N) {
//        System.out.println("Uniform mesh");
        double[] h = new double[N + 1];
        for (int i = 1; i < N + 1; i++) {
            h[i] = 1. / N;
        }
        return h;
    }

    public static double[] setkaShishkina(double epsilon, int N) {
        double[] h = new double[N + 1];
        double sigma = Math.min(0.5, 4. * epsilon * Math.log(N * 1.0) / 1.);

        for (int i = 0; i <= N; i++) {
            if ((i <= N / 2.) && (i >= 1)) {
                h[i] = 2. * sigma / N;
//                System.out.println(h[i]);
            }
            if ((i <= N) && (i > N / 2.)) {
                h[i] = 2. * (1. - sigma) / N;
//                System.out.println(h[i]);
            }
        }

        return h;
    }

    public static double[] setkaBakhvalova(double epsilon, int N) {
//        System.out.println("Bakhvalov mesh");
        double uzelx[] = new double[N + 1];
        double sigma1;
        double[] h = new double[N + 1];
        sigma1 = Math.min(0.5, (-4.) * epsilon * Math.log(epsilon) / 1.);
//        sigma2 = min(0.5,(-2.)*epsilon*log(epsilon)/2.);
        if (epsilon > Math.exp(-1)) {
            sigma1 = 0.5;
//            sigma2 = 0.5;
        }


        if (sigma1 == 0.5) {
            uzelx[0] = 0.;
            for (int i = 1; i <= N; i++) {
                h[i] = 1. / N;
                uzelx[i] = uzelx[i - 1] + h[i];
            }
        }


        if (sigma1 < 0.5) {
            uzelx[0] = 0.;
            for (int i = 1; i <= N / 2; i++) {
                uzelx[i] = (-4.) / 1.0 * epsilon * Math.log(1. - 2. * (1. - epsilon) * i / N);
                //cout<<uzelx[i]<<endl;
            }
            for (int i = N / 2; i <= N; i++) {
                uzelx[i] = sigma1 + (2. * i / N - 1.) * (1. - sigma1);
            }


//            uzelx[N/2-1] = (uzelx[N/2-1] + uzelx[N/2])/2.0;
//            uzelx[N/2] = (uzelx[N/2]+uzelx[N/2+1])/2.0;

//            uzelx[N/2-1] = (uzelx[N/2-1] + uzelx[N/2])/2.0;
//            uzelx[N/2] = (uzelx[N/2]+uzelx[N/2+1])/2.0;


            for (int i = 1; i <= N; i++) {
                h[i] = uzelx[i] - uzelx[i - 1];
            }
        }


        return h;
    }

    public static void findPoints(int N, Double[] h, Double[] uzel) {
        uzel[0] = 0.;
        for (int i = 1; i < N + 1; i++) {
            uzel[i] = uzel[i - 1] + h[i];
//            System.out.println(uzel[i]);
        }
    }


    public static void findFunction(int N, Double[] f, Double[] uzel, Function<Double, Double> function) {
        for (int i = 0; i < N + 1; i++) {
            f[i] = function.apply(uzel[i]);
//            System.out.println(i+" = "+f[i]);
        }
    }
}
