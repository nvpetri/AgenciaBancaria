package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome, endereco;
    private long cpf, rg, telefone;

    public List<Cliente> cliente = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addCliente(){
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println("/-/-/-/-/-/-/-Cadastro Cliente-/-/-/-/-/-/");
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

        Cliente clientes = new Cliente();

        System.out.print("Informe seu nome: ");
        clientes.nome = scanner.nextLine();

        System.out.print("Informe seu endereço: ");
        clientes.endereco = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        clientes.cpf = scanner.nextLong();

        System.out.print("Informe seu RG: ");
        clientes.rg = scanner.nextLong();

        System.out.print("Informe seu telefone:");
        clientes.telefone = scanner.nextLong();

        cliente.add(clientes);

        System.out.println("-/-/-/-/-/-/-Cadastro finalizado-/-/-/-/-/-/");
    }

    public Cliente pesquisarCliente(long cpf){
        for (Cliente cliente: cliente) {
            long validaCpf = cliente.cpf;
            if (validaCpf == cpf){
                return cliente;
            }
        }
        return null;
    }
    public void listarClientes(){
        for (Cliente cliente: cliente) {
            System.out.println(cliente.nome);
            System.out.println(cliente.cpf);
        }
    }
}
