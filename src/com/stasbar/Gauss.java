package com.stasbar;

import java.util.Arrays;

/**
 * Created by stasbar on 05.04.2017.
 */
public class Gauss {
    double[][] A;
    double[] B;
    int N;
    public Gauss(double[][] a, double[] b, int N) {
        A = a;
        B = b;
        this.N = N;
    }

    public long solve() {
        long iteration;
        double[] x = new double[N];
        double[] previous = new double[N];
        double omega;
        double res;

        Arrays.fill(x, 0);
        Arrays.fill(previous, 0);

        for (iteration = 0; iteration < 10000; iteration++) {
            for (int i = 0; i < N; i++) {
                omega = 0;
                for (int j = 0; j <= i - 1; j++)
                    omega += A[i][j] * x[j];
                for (int j = i+1; j < N; j++)
                    omega += A[i][j] * previous[j];
                x[i] = (B[i] - omega) / A[i][i];
            }
            res = Utils.norm(Utils.res(A, x, B));
            if (res <= Utils.EPSILON)
                break;
            previous = x.clone();
        }
        return iteration;
    }

}
