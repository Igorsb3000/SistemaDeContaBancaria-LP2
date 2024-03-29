package br.ufrn.imd.lp2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {
    private double limite = 500;

    public ContaPoupanca(String nome, String CPF, int numero, double saldo, LocalDateTime dataCadastro, LocalDateTime dataEncerramento, boolean ativo){
        super(nome, CPF, numero, saldo, dataCadastro, dataEncerramento, ativo);
    }

    @Override
    public void configurarConta(String nome, String CPF) {
            this.setDataCadastro(LocalDateTime.now());
            this.setCPF(CPF);
            this.setNome(nome);
            this.setAtivo(true);
            this.setDataEncerramento(null);
    }


    public double getLimite(){
        return limite;
    }

    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() - valor >= this.getLimite() * -1){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        System.out.println("Saque invalido, ultrapassou o limite");
        System.out.println();
        return false;

    }
    @Override
    public boolean depositar(double valor){
        double deposito = valor;
        this.setSaldo(this.getSaldo() + deposito);
        return true;
    }
    

    public void mostrarDados(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd//MM/yyy HH:mm:ss");
        System.out.println("***Conta Poupanca***");
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
        System.out.println("Limite: R$" + this.getLimite());
        System.out.println();

    }

    @Override
    public int compareTo(ContaBancaria o) {
        return this.getNome().compareTo(o.getNome());
    }
}
