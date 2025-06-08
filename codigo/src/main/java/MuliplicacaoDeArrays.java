import java.util.Scanner;

public class MuliplicacaoDeArrays {
    public static void main(String[] args) {

        int[][] array1 = new int[2][2];
        int[][] array2 = new int[2][2];
        int[][] resultado = new int[2][2];

        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1[i].length; j++) {
                    System.out.print("Digite o valor do elemento " + i + " " + j + " da primeira array: ");
                    array1[i][j] = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            System.out.println("=============================");
            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array2[i].length; j++) {
                    System.out.print("Digite o valor do elemento " + i + " " + j + " da segunda array: ");
                    array2[i][j] = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            System.out.println();
            System.out.println("\nMatriz resultado:");
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1.length; j++) {
                    resultado[i][j] = array1[i][j] * array2[j][i];
                    System.out.print(resultado[i][j] + " ");
                }
                System.out.println(); // Quebra de linha após completar uma linha da matriz
            }
        }
    }
}