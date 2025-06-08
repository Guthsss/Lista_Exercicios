import java.util.Scanner;

public class Soma_Array {
    public static void main(String[] args) {
        int[] numeros = new int[5];
        int sum = 0;
        try (Scanner scanner = new Scanner(System.in)){

            // Loop para adicionar os números no array
            for (int i = 0; i < numeros.length; i++) {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                numeros[i] = scanner.nextInt();
            }

            // Loop para mostrar os números do array
            for (int i = 0; i < numeros.length; i++) {
                sum = sum + numeros[Ordens.i];
            }
            System.out.println("A soma dos elementos: " + sum);
        }
    }
}