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

                    Cliente clienteTitular = referenciaCliente.pesquisarCliente(cpfTitular);


                    if (clienteTitular != null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteTitular);
                        referenciaConta.adicionarConta(conta);

                        System.out.println("Conta criada com sucesso");
                    }else {
                        System.out.println("Impossível encontrar o cliente informado. \nPor favor cadastre ou informe um usuário existente");
                    }

                    Conta conta = new Conta();
                    conta.gerarConta(referenciaCliente);
                    referenciaConta.adicionarConta(conta);

                    break;
                case 3:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpFTitular = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaPesquisada = referenciaConta.pesquisarConta(cpFTitular);

                    if (contaPesquisada != null){
                        double saldo = contaPesquisada.getSaldo();
                        System.out.println("O saldo disponivel na sua conta é: " + saldo);
                    }else {
                        System.out.println("O usuário não possui conta cadastrada.");
                    }

                    break;
                case 4:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.println("Informe o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.realizarDeposito(valorDeposito);
                    }else {
                        System.out.println("O usuário não possui conta cadastrada.");
                    }

                    break;
                case 5:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.println("Informe o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.realizarSaque(valorSaque);
                    }else {
                        System.out.println("O usuário não possui conta cadastrada.");
                    }
                    break;
                case 6:
                    System.out.println("Informe o CPF do Titular da conta de origem: ");
                    long cpfOrigem = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaOrigem = referenciaConta.pesquisarConta(cpfOrigem);

                    if (contaOrigem != null) {
                        System.out.println("Informe o CPF do Titular da conta de destino: ");
                        long cpfDestino = scanner.nextLong();
                        scanner.nextLine();

                        Conta contaDestino = referenciaConta.pesquisarConta(cpfDestino);

                        if (contaDestino != null) {
                            System.out.println("Informe o valor para a transferência: ");
                            double valorTransferencia = scanner.nextDouble();

                            if (contaOrigem.realizarTransferencia(contaDestino, valorTransferencia)) {
                                System.out.println("Transferência realizada com sucesso.");
                            }
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                    }
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
