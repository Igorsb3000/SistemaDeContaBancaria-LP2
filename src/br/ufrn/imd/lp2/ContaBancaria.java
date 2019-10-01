package br.ufrn.imd.lp2;

import java.time.LocalDateTime;

public abstract class ContaBancaria implements Comparable<ContaBancaria> {
    private int numero;
    private double saldo;
    private String CPF;
    private String nome;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataEncerramento;
    private boolean ativo;

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public ContaBancaria(String nome, String CPF, int numero, double saldo, LocalDateTime dataCadastro, LocalDateTime dataEncerramento, boolean ativo) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = numero;
        this.saldo = saldo;
        this.dataCadastro = dataCadastro;
        this.dataEncerramento = dataEncerramento;
        this.ativo = ativo;
    }

    public abstract void configurarConta(String nome, String CPF);

    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);

    public int getNumeroConta(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public abstract void mostrarDados();

    public  boolean transferir(ContaBancaria conta, double valor){
        if(this.sacar(valor)){
            conta.depositar(valor);
            return true;
        }
        System.out.println("Nao foi possivel fazer a transferencia");
        return false;
    }


}
