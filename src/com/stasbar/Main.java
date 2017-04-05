package com.stasbar;

public class Main {


    public static void main(String[] args) {
        int N = 918;
        int a1 = 10;
        int a2 = -1;
        int a3 = -1;

        double[][] A = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    A[i][j] = a1;
                else if (Math.abs(i - j) == 1)
                    A[i][j] = a2;
                else if (Math.abs(i - j) == 2)
                    A[i][j] = a3;
                else
                    A[i][j] = 0;
            }
        }

        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = Math.sin((double) i * 1d / 50d);
        }
        Gauss gauss = new Gauss(A,b,N);
        long gaussStart = System.currentTimeMillis();
        long gaussIterations = gauss.solve();
        long gaussEnd = System.currentTimeMillis();
        System.out.printf("Gauss-Saidee: iterations: %d time %d \n", gaussIterations, gaussEnd - gaussStart);

        Jacobi jacobi = new Jacobi(A,b,N);
        long jacobiStart = System.currentTimeMillis();
        long jacobiIterations = jacobi.solve();
        long jacobiEnd = System.currentTimeMillis();
        System.out.printf("Jacobi: iterations: %d time %d \n", jacobiIterations, jacobiEnd - jacobiStart);

    }

    private static void jacobi() {

    }








    public static void printRowEchelonForm(double[][] A, double[] B) {
        int N = B.length;
        System.out.println("\nRow Echelon form : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%.3f ", A[i][j]);
            System.out.printf("| %.3f\n", B[i]);
        }
        System.out.println();
    }

    public static void printSolution(double[] sol) {
        int N = sol.length;
        System.out.println("\nSolution : ");
        for (int i = 0; i < N; i++)
            System.out.printf("%.3f ", sol[i]);
        System.out.println();
    }

}
