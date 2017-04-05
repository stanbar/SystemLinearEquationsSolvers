package com.stasbar;

/**
 * Created by stasbar on 04.04.2017.
 */
public class Utils {
    public static final double EPSILON = 10e-9;
    public static double norm(double[] vector) {
        double sum = 0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i] * vector[i];
        }
        return Math.sqrt(sum);
    }
    private static void square(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            solution[i] *= solution[i];
        }
    }

    public static double[] res(double[][] A, double[] solution, double[] B) {
        double[] ans = multiply(A, solution);
        return substract(ans, B);


    }

    public static double[] multiply(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] result = new double[rows];

        for (int row = 0; row < rows; row++) {
            double sum = 0;
            for (int column = 0; column < columns; column++) {
                sum += matrix[row][column]
                        * vector[column];
            }
            result[row] = sum;
        }
        return result;
    }

    private static double[] substract(double[] ans, double[] b) {
        double[] result = new double[ans.length];
        for (int i = 0; i < ans.length; i++) {
            result[i] = ans[i] - b[i];
        }
        return result;
    }
}
