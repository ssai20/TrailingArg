import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExamineSolution {
//    public static void findS(int L, int N, Double[] uzel, Double[] x, Double[] f, Double[] S, Double[] h, Double[] hh, Double[] c){
//        Double hh=1./L;
//        Double[] hh = ravnomSetka(L);
//        x[0]=0.;
//
//        for(int k=1;k<L+1;k++){
//            x[k]=x[k-1]+hh[k];
//        }
//
//        for(int i=0;i<N+1;i++){
//            for (int k=0;k<L;k++){
//                // if ( ((x[k]>=uzel[i])&&(x[k]<uzel[i+1]))||(x[k]==1.) )
//                if  ((x[k]>=uzel[i])&&(x[k]<uzel[i+1]))
//                {
//
//                    //  cout<<"x["<<k<<"] ="<<x[k]<<" popal v "<<"[ uzel["<<i<<"]; uzel["<<i+1<<"] ) = "<<uzel[i]<<";"<<uzel[i+1]<<endl;
//                    //cout<<x[k]<<" popal v "<<"[" <<uzel[i]<<";"<< uzel[i+1]<< ")"<<endl;
//                    //if (k==L) {cout<<"!!!!"<<endl;}
////                    S[k]=  f[i]+ ( (f[i]-f[i-1])/h + h*(2*c[i]+c[i-1])/3. )*(x[k]-uzel[i]) + c[i] * (x[k]-uzel[i])*(x[k]-uzel[i]) + ( (c[i]-c[i-1])/(3.*h) )*(x[k]-uzel[i])*(x[k]-uzel[i])*(x[k]-uzel[i]);
////                    S[k]=  f[i+1]+ ( (f[i+1]-f[i])/h + h*(2*c[i+1]+c[i])/3 )*(x[k]-uzel[i]) + c[i+1] * (x[k]-uzel[i])*(x[k]-uzel[i]) + ( (c[i+1]-c[i])/(3*h) )*(x[k]-uzel[i])*(x[k]-uzel[i])*(x[k]-uzel[i]);
//
////                    S[k] = (uzel[i+1] - x[k])*(uzel[i+1] - x[k])*(uzel[i+1] - x[k])*c[i]/(6*h) + (x[k] - uzel[i])*(x[k] - uzel[i])*(x[k] - uzel[i])*c[i+1]/(6*h) + (f[i+1]/h - c[i+1]*h/6.)*(x[k] - uzel[i]) + (f[i]/h - c[i]*h/6.)*(uzel[i+1] - x[k]);
//
//                    S[k] = (uzel[i+1] - x[k])*(uzel[i+1] - x[k])*(uzel[i+1] - x[k])*c[i]/(6.*h[i+1]) + (x[k] - uzel[i])*(x[k] - uzel[i])*(x[k] - uzel[i])*c[i+1]/(6.*h[i+1]) + (f[i+1]/h[i+1] - c[i+1]*h[i+1]/6.)*(x[k] - uzel[i]) + (f[i]/h[i+1] - c[i]*h[i+1]/6.)*(uzel[i+1] - x[k]);
////
////                    System.out.println("S["+k+"] = "+S[k]);
//                }
//            }
//        }
//
//        S[L] = (uzel[N] - x[L])*(uzel[N] - x[L])*(uzel[N] - x[L])*c[N]/(6*h[N]) + (x[L] - uzel[N-1])*(x[L] - uzel[N-1])*(x[L] - uzel[N-1])*c[N]/(6*h[N]) + (f[N]/h[N] - c[N]*h[N]/6)*(x[L] - uzel[N-1]) + (f[N-1]/h[N] - c[N-1]*h[N]/6.)*(uzel[N] - x[L]);
//
//    }

    public double errorNorm(double[] u, int N, Function<Double, Double> function, double[] uzel) {
        List<Double> norm = new ArrayList<>();
        double[] res = new double[N+1];
        double norma = 0.;
        for (int i = 0; i < N+1; i++) {
//            System.out.print(function.apply(uzel[i]) + " ");
            res[i] = Math.abs(function.apply(uzel[i]) - u[i]);
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
