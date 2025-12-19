import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

        boolean isSquare = rows == columns;
        boolean isDiagonal = true;
        boolean isIdentity = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (i != j && matrix[i][j] != 0) {
                    isDiagonal = false;
                    isIdentity = false;
                }

                if (i == j && matrix[i][j] != 1) {
                    isIdentity = false;
                }
            }
        }

        System.out.println(isSquare);
        System.out.println(isDiagonal);
        System.out.println(isIdentity);
    }
}
