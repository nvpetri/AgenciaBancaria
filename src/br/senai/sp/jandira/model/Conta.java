package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String agencia;
    private int numeroConta;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    List<Conta> listContas = new ArrayList<>();


    public Conta pesquisarConta(int numeroConta){
        for (Conta conta: listContas) {

            int validaConta = conta.getNumeroConta();

            if (validaConta == numeroConta){
                return conta;
            }
        }
        return null;
    }
    public void listarContas(){
        for (Conta conta: listContas) {
            System.out.println(conta.getNumeroConta());
        }
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

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
