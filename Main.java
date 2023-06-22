import java.util.Scanner;
import Data.DbContext;
import Models.Conta.ContaCorrente;
import Models.Conta.ContaPoupanca;
import Models.Pessoa;

public class Main {

    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        System.out.println("---- Seja bem-vindo(a) ao nosso banco! ----\n");

        System.out.println("Selecione uma opção do nosso menu: \n");
        System.out.println("1 - Abrir conta");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");

        System.out.print("\nOPÇÃO: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int opcaoSelecionada = scanner.nextInt();

            if (opcaoSelecionada >= 1 && opcaoSelecionada <= 4) {
                executaOpcao(opcaoSelecionada);
            } else {
                mensagemStatus("Opção Inválida.");
            }

            inicio();
        } else {
            mensagemStatus("Opção Inválida.");
        }

        scanner.close();
    }

    public static void executaOpcao(int opcaoSelecionada) {
        switch (opcaoSelecionada) {
            case 1:
                abrirConta();
                break;
            case 2:
                consultarSaldo();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            default:
                break;
        }
    }

    public static void abrirConta() {
        System.out.println("\nInforme o seu nome: ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            String nomeCliente = scanner.nextLine();

            DbContext database = new DbContext();

            try {
                database.conectarBanco();

                boolean statusQuery = database.executarUpdateSql("INSERT INTO public.clientes(nome) VALUES ('" + nomeCliente + "')");

                if (statusQuery) {
                    mensagemStatus("Conta aberta com sucesso para o cliente " + nomeCliente);
                }

                database.desconectarBanco();
            } catch (Exception e) {
                e.printStackTrace();
            }

            scanner.close();
        }

        inicio();
    }

    public static void consultarSaldo() {
        System.out.println("\nInforme o número da conta: ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int numeroDaConta = scanner.nextInt();

            DbContext database = new DbContext();

            try {
                database.conectarBanco();

                // Substitua ? pelo valor correto da coluna no banco de dados
                boolean statusQuery = database.executarUpdateSql("SELECT saldo FROM public.clientes WHERE numero = ?");

                if (statusQuery) {
                    // Substitua saldo pelo valor correto da coluna no banco de dados
                    mensagemStatus("Saldo da conta " + numeroDaConta + ": R$ " + saldo);
                }

                database.desconectarBanco();
            } catch (Exception e) {
                e.printStackTrace();
            }

            scanner.close();
        }

        inicio();
    }

    public static void depositar() {
        System.out.println("\nInforme o número da conta: ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int numeroDaConta = scanner.nextInt();
            System.out.println("\nInforme o valor a ser depositado: ");

            if (scanner.hasNextDouble()) {
                double valorDeposito = scanner.nextDouble();

                DbContext database = new DbContext();

                try {
                    database.conectarBanco();

                    // Substitua depositar pelo nome correto da tabela e coluna no banco de dados
                    boolean statusQuery = database.executarUpdateSql("UPDATE public.clientes SET saldo = saldo + " + valorDeposito + " WHERE numero = " + numeroDaConta);

                    if (statusQuery) {
                        mensagemStatus("Depósito de R$ " + valorDeposito + " realizado na conta " + numeroDaConta);
                    }

                    database.desconectarBanco();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }

        inicio();
    }

    public static void sacar() {
        System.out.println("\nInforme o número da conta: ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int numeroDaConta = scanner.nextInt();
            System.out.println("\nInforme o valor a ser sacado: ");

            if (scanner.hasNextDouble()) {
                double valorSaque = scanner.nextDouble();

                DbContext database = new DbContext();

                try {
                    database.conectarBanco();

                    // Substitua novoSaque pelo nome correto da tabela e coluna no banco de dados
                    boolean statusQuery = database.executarUpdateSql("UPDATE public.clientes SET saldo = saldo - " + valorSaque + " WHERE numero = " + numeroDaConta);

                    if (statusQuery) {
                        mensagemStatus("Saque de R$ " + valorSaque + " realizado na conta " + numeroDaConta);
                    }

                    database.desconectarBanco();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }

        inicio();
    }

    public static void mensagemStatus(String mensagem) {
        System.out.println("\n---------------------");
        System.out.println(" " + mensagem + " ");
        System.out.println("---------------------\n");
    }
}
