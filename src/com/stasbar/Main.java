package com.stasbar;

public class Main {

    public static void main(String[] args) {
        int n = 918;
        int a1 = 10;
        int a2 = -1;
        int a3 = -1;

        double[][] A = generateMatrixA(a1,a2,a3, n);
        double[] b = generateMatrixB(n);

        GaussSaidee gaussSaidee = new GaussSaidee(A,b, n);
        long gaussSaideeStart = System.currentTimeMillis();
        long gaussSaideeIterations = gaussSaidee.solve();
        long gaussSaideeEnd = System.currentTimeMillis();
        System.out.printf("Gauss-Saidee: iterations: %d time %d \n", gaussSaideeIterations, gaussSaideeEnd - gaussSaideeStart);

        Jacobi jacobi = new Jacobi(A,b, n);
        long jacobiStart = System.currentTimeMillis();
        long jacobiIterations = jacobi.solve();
        long jacobiEnd = System.currentTimeMillis();
        System.out.printf("Jacobi: iterations: %d time %d \n", jacobiIterations, jacobiEnd - jacobiStart);

        //C
        a1 = 3;
        a2 = -1;
        a3 = -1;
        A = generateMatrixA(a1,a2,a3, n);
        b = generateMatrixB(n);

        gaussSaidee = new GaussSaidee(A,b, n);
        gaussSaideeStart = System.currentTimeMillis();
        gaussSaideeIterations = gaussSaidee.solve();
        gaussSaideeEnd = System.currentTimeMillis();
        System.out.printf("GaussSaidee-Saidee: iterations: %d time %d \n", gaussSaideeIterations, gaussSaideeEnd - gaussSaideeStart);

        jacobi = new Jacobi(A,b, n);
        jacobiStart = System.currentTimeMillis();
        jacobiIterations = jacobi.solve();
        jacobiEnd = System.currentTimeMillis();
        System.out.printf("Jacobi: iterations: %d time %d \n", jacobiIterations, jacobiEnd - jacobiStart);

        //D
        a1 = 3;
        a2 = -1;
        a3 = -1;
        A = generateMatrixA(a1,a2,a3, n);
        b = generateMatrixB(n);
        GaussianElimination gaussianElimination = new GaussianElimination(A,b, n);
        double norm = gaussianElimination.solve();
        System.out.printf("Norm from gaussianElimination method is %f",norm);

        // E
        System.out.println();
        System.out.println();
        System.out.println();
        int[] Ns = {100,500,1000,2000,3000};
        a1 = 10;
        a2 = -1;
        a3 = -1;
        for (int Nth : Ns) {
            n = Nth;
            System.out.println();
            System.out.printf("*******%d*******\n", n);
            A = generateMatrixA(a1, a2, a3, n);
            b = generateMatrixB(n);
            gaussSaidee = new GaussSaidee(A, b, n);
            gaussSaideeStart = System.currentTimeMillis();
            gaussSaidee.solve();
            gaussSaideeEnd = System.currentTimeMillis();
            System.out.printf("Gauss-Saidee: \t%d \n", gaussSaideeEnd - gaussSaideeStart);

            jacobi = new Jacobi(A, b, n);
            jacobiStart = System.currentTimeMillis();
            jacobi.solve();
            jacobiEnd = System.currentTimeMillis();
            System.out.printf("Jacobi: \t\t%d \n", jacobiEnd - jacobiStart);

            long gaussStart = System.currentTimeMillis();
            gaussianElimination = new GaussianElimination(A, b, n);
            gaussianElimination.solve();
            long gaussEnd = System.currentTimeMillis();
            System.out.printf("Gauss: \t\t\t%d \n", gaussEnd - gaussStart);
            System.out.println("******************");
        }

    }
    private static double[][] generateMatrixA(int a1, int a2, int a3, int N){

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
        return A;
    }
    private static double[] generateMatrixB(int N){

        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = Math.sin((double) i * 1d / 50d);
        }
        return b;
    }

}
