import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Caixa_mercado {
    public static void main(String[] args) {

        // Usando ArrayList
        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();

        // Formatador para valores monetários

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Bem vindo ao SuperMercado Piraputa");

        try (Scanner mercado = new Scanner(System.in)) {

            // Validação do número de clientes

            int clientes;
            do {
                System.out.print("Quantos clientes há na fila? ");
                clientes = mercado.nextInt();
                if (clientes <= 0) {
                    System.out.println("Por favor, digite um número válido de clientes.");
                }
            } while (clientes <= 0);

            mercado.nextLine(); // Limpa o buffer

            // Processamento de cada cliente

            for (int i = 1; i <= clientes; i ++) {
                System.out.println("\n---- Cliente " + i + " ----");

                double total = processarCompraCliente(mercado, produtos, precos);
                processarPagamento(mercado, total);
                imprimirResumoCompra(produtos, precos, total, i);

                // Limpa as listas para o próximo cliente

                produtos.clear();
                precos.clear();
            }

            System.out.println("\nTodos os clientes foram atendidos.");
        }
    }

    private static double processarCompraCliente(Scanner mercado, ArrayList<String> produtos,
                                                 ArrayList<Double> precos) {
        double total = 0;

        while (true) {
            System.out.print("Digite o nome do produto (ou 'fim' para encerrar): ");
            String produto = mercado.nextLine().trim();

            if (produto.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Digite o preço do produto: ");
            double preco;
            // Validação do preço
            while (true) {
                try {
                    preco = Double.parseDouble(mercado.nextLine());
                    if (preco < 0) {
                        System.out.println("O preço não pode ser negativo. Tente novamente:");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite um valor válido:");
                }
            }

            produtos.add(produto);
            precos.add(preco);
            total += preco;
        }

        return total;
    }

    private static void processarPagamento(Scanner mercado, double total) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("\nTotal da compra: R$ " + df.format(total));

        double saldo;
        while (true) {
            System.out.print("Digite o saldo do cliente: R$ ");
            try {
                saldo = Double.parseDouble(mercado.nextLine());
                if (saldo < 0) {
                    System.out.println("O saldo não pode ser negativo. Tente novamente:");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um valor válido:");
            }
        }

        if (saldo >= total) {
            System.out.println("Pagamento Aprovado. Troco: R$ " + df.format(saldo - total));
        } else {
            System.out.println("Saldo insuficiente! Pagamento recusado.");
        }
    }

    private static void imprimirResumoCompra(ArrayList<String> produtos, ArrayList<Double> precos,
                                             double total, int clienteNumero) {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("\nResumo da compra do cliente " + clienteNumero + ":");
        System.out.println("Produto\t\tPreço");
        System.out.println("--------------------------");

        for (int i = 0; i < produtos.size(); i++) {
            System.out.printf("%-15s R$ %s%n", produtos.get(i), df.format(precos.get(i)));
        }

        System.out.println("--------------------------");
        System.out.println("Total: R$ " + df.format(total));
    }
}