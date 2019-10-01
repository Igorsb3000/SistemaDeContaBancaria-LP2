package br.ufrn.imd.lp2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ContaCorrente extends ContaBancaria implements Imprimivel{
    private double taxaDeOperacao = 5.00;

    public ContaCorrente(String nome, String CPF, int numero, double saldo, LocalDateTime dataCadastro, LocalDateTime dataEncerramento, boolean ativo){
        super(nome, CPF, numero, saldo, dataCadastro, dataEncerramento, ativo);
    }


    public double getTaxaDeOperacao(){
        return taxaDeOperacao;
    }



    @Override
    public void configurarConta(String nome, String CPF) {
        this.setDataCadastro(LocalDateTime.now());
        this.setCPF(CPF);
        this.setNome(nome);
        this.setAtivo(true);
        this.setDataEncerramento(null);
        return;
    }


    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() - valor - taxaDeOperacao >= 0){
            this.setSaldo(this.getSaldo() - valor - taxaDeOperacao);
            return true;
        }
        System.out.println("Saque invalido!");
        return false;

    }

    @Override
    public boolean depositar(double valor){
        double deposito = valor;
        this.setSaldo(this.getSaldo() + deposito - taxaDeOperacao);
        return true;
    }

    @Override
    public void mostrarDados(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        System.out.println("***Conta Corrente***");
        System.out.println("Cliente: " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Numero da Conta: " + this.getNumeroConta());
        System.out.println("Data de Cadastro: " + dtf.format(this.getDataCadastro()));
        if(!this.getAtivo()){
            System.out.println("Conta Desativada");
            System.out.println("Data de Encerramento: " + dtf.format(this.getDataEncerramento()));
        }else{
            System.out.println("Conta Ativa");
        }
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Taxa de Operacao: R$" + this.getTaxaDeOperacao());
        System.out.println();
    }

    @Override
    public int compareTo(ContaBancaria o) {
        return this.getNome().compareTo(o.getNome());
    }
}
