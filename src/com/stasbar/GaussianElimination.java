package com.stasbar;

/**
 * Created by stasbar on 06.04.2017.
 */
public class GaussianElimination {
    double[][] A;
    double[] B;
    int N;
    public GaussianElimination(double[][] a, double[] b, int N) {
        A = a;
        B = b;
        this.N = N;
    }

    public double solve()
    {
        int N = B.length;
        for (int k = 0; k < N; k++)
        {
            /** find pivot row **/
            int max = k;
            for (int i = k + 1; i < N; i++)
                if (Math.abs(A[i][k]) > Math.abs(A[max][k]))
                    max = i;

            /** swap row in A matrix **/
            double[] temp = A[k];
            A[k] = A[max];
            A[max] = temp;

            /** swap corresponding values in constants matrix **/
            double t = B[k];
            B[k] = B[max];
            B[max] = t;

            /** pivot within A and B **/
            for (int i = k + 1; i < N; i++)
            {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++)
                    A[i][j] -= factor * A[k][j];
            }
        }



        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * x[j];
            x[i] = (B[i] - sum) / A[i][i];
        }
        return Utils.norm(Utils.res(A, x, B));

    }

}
