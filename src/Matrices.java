import java.util.Scanner;
public class Matrices {


    public static int[][] inputMatrix(Scanner scanner, int rows, int cols, String matrixName) {
        System.out.println("Enter values for " + matrixName  + "  " + rows + "x" + cols + ":");
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2)

            throws IllegalArgumentException {
        if (matrix2.length != matrix1.length   ||   matrix2[0].length != matrix1[0].length) {
            throw new IllegalArgumentException("ERROR!!!!! Matrices must have the same dimensions for addition.");
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    //-------------------------------------------------------------------------------------
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2)

            throws IllegalArgumentException {
        if (matrix2.length != matrix1.length  ||   matrix2[0].length != matrix1[0].length) {
            throw new IllegalArgumentException("ERROR!!!!! Matrices must have the same dimensions for subtraction.");
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    //-----------------------------------------------------------------------------------

    //*********************************************************************************
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2)

            throws IllegalArgumentException {
        if (matrix1[0].length != matrix2.length ) {
            throw new IllegalArgumentException("ERROR!!!!! Number of columns in matrix 1 must equal to number of rows in matrix 2 for multiplication.");
        }

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    //*******************************************************************************

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }












    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows for Matrix 1: ");
        int rows1 = scanner.nextInt();

        System.out.print("Enter number of columns for Matrix 1: ");
        int cols1 = scanner.nextInt();

        System.out.print("Enter number of rows for Matrix 2: ");
        int rows2 = scanner.nextInt();

        System.out.print("Enter number of columns for Matrix 2: ");
        int cols2 = scanner.nextInt();

        int[][] matrix1 = inputMatrix(scanner, rows1, cols1, "First Matrix");
        int[][] matrix2 = inputMatrix(scanner, rows2, cols2, "Second Matrix");
        System.out.println("ENTER  1  for Addition");
        System.out.println("ENTER  2  for Subtract");
        System.out.println("ENTER  3  for Multiply");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                try {
                    int[][] resultAdd = addMatrices(matrix1, matrix2);
                    printMatrix(resultAdd);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    int[][] resultSubtract = subtractMatrices(matrix1, matrix2);
                    printMatrix(resultSubtract);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {
                    int[][] resultMultiply = multiplyMatrices(matrix1, matrix2);
                    printMatrix(resultMultiply);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("ERROR!!!!!! Invalid Choice,, PLEASE ENTER 1 OR 2 OR 3");
                break;
        }

        scanner.close();
    }
}


