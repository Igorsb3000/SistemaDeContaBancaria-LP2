package br.ufrn.imd.lp2;

import java.time.LocalDateTime;
import java.util.Comparator;

public abstract class ContaBancaria implements Comparable<ContaBancaria> {
    private int numero;
    private double saldo;
    private String CPF;
    private String nome;
    private LocalDateTime dataCadastro = LocalDateTime.now();
    private LocalDateTime dataEncerramento = null;
    private boolean ativo = true;

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

    public ContaBancaria(String nome, String CPF, int numero, double saldo) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = numero;
        this.saldo = saldo;
    }

    public void configurarConta(String nome, String CPF){
        //ContaBancaria tmp = null;
        /*for(ContaBancaria conta : this.banco){
            if(conta.getCPF() == CPF){
                tmp = conta;
                break;
            }
        }*/

        if(!this.getAtivo()){
            System.out.println("Conta inativa, não é possivel configura-lá!");
            return;
        }
        else{
            this.setDataCadastro(LocalDateTime.now());
            this.setCPF(CPF);
            this.setNome(nome);
            this.setAtivo(true);

        }
        return;
    }

    public void encerrarConta(String CPF){
        //ContaBancaria tmp = null;
        /*for(ContaBancaria conta : this.banco){
            if(conta.getCPF() == CPF){
                tmp = conta;
                break;
            }
        }*/

        if(!this.getAtivo()){
            System.out.println("Sua conta já está encerrada!");
            return;
        }
        else{
            this.setAtivo(false);
            this.setDataEncerramento(LocalDateTime.now());
            System.out.println("Sua conta foi encerrada com sucesso!");
        }
        return;
    }

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

    public void mostrarDados() {
    }


    public  boolean transferir(ContaBancaria conta, double valor){
        if(this.sacar(valor) == true){
            conta.depositar(valor);
            return true;
        }
        System.out.println("Nao foi possivel fazer a transferencia");
        return false;
    }


}
