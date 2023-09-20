package br.senai.sp.jandira.model;

public class Conta {
    private String agencia = "000-20-X";
    private int numeroConta = 1234000;
    private double saldo = 8640;

    public void realizarSaque(double valorSaque){

        if (valorSaque > this.saldo) {
            valorSaque = 0;
            System.out.println("Insira um valor menor ou igual que: " + this.saldo);
        }

        this.saldo -= valorSaque;
        System.out.println("Seu saldo atual é: " + this.saldo);
    }

    public void realizarDeposito(double valorDeposito){

        this.saldo += valorDeposito;
        System.out.println("Seu saldo atual é :" + this.saldo);
    }

    public void consultarSaldo(){
        System.out.println("Seu saldo atual é :" + this.saldo);
    }
}
