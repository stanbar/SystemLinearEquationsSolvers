package com.stasbar;

import java.util.Arrays;

/**
 * Created by stasbar on 05.04.2017.
 */
public class Jacobi {
    double[][] A;
    double[] b;
    private int N;

    public Jacobi(double[][] A,double[] b, int N) {
        this.A = A;
        this.b = b;
        this.N = N;
    }
    public long solve() {
        int iterations;
        double res;
        double[] x = new double[N]; // Approximations
        double[] previous = new double[N]; // Prev
        Arrays.fill(x, 0);
        Arrays.fill(previous, 0);

        for(iterations = 0 ; iterations < 100; iterations++) {

            for (int i = 0; i < N; i++) {

                double sum = b[i];

                for (int j = 0; j < N; j++)
                    if (j != i)
                        sum -= A[i][j] * previous[j];
                x[i] = 1 / A[i][i] * sum;
            }
            res = Utils.norm(Utils.res(A, x, b));
            if (res <= Utils.EPSILON)
                break;
            previous = x.clone();
        }
        return iterations;
    }
}
