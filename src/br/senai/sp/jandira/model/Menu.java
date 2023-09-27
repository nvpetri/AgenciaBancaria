package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    Cliente referenciaCliente = new Cliente();

    Conta referenciaConta = new Conta();

    public void executarMenu() {

        boolean continuar = true;

        while (continuar) {

            System.out.println("-------------------------------------------");
            System.out.println("/-/-/-/-/-/-/-/-/ Menu /-/-/-/-/-/-/-/-/-/-");
            System.out.println("-------------------------------------------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Gerar Conta");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Realizar Depósito");
            System.out.println("5 - Realizar Saque");
            System.out.println("6 - Transferência");
            System.out.println("7 - Sair");
            System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-");

            int userOption = scanner.nextInt();
            scanner.next();

            switch (userOption) {
                case 1:
                    referenciaCliente.addCliente();
                    referenciaCliente.listarClientes();
                    break;
                case 2:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfTitular = scanner.nextLong();
                    scanner.nextLine();

                    Conta conta = new Conta();
                    conta.gerarConta(referenciaCliente);
                    referenciaConta.adicionarConta(conta);
                    break;
                case 3:
                    referenciaConta.consultarSaldo();
                    break;
                case 4:
                    System.out.print("Informe o valor do Depósito: ");
                    double deposito = scanner.nextDouble();

                    referenciaConta.realizarDeposito(deposito);
                    break;
                case 5:
                    System.out.print("Informe o valor do Saque: ");

                    double saque = scanner.nextDouble();
                    
                    referenciaConta.realizarSaque(saque);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    break;

            }
        }
    }
}
