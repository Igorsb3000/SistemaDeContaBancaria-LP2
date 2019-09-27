package br.ufrn.imd.lp2;

public abstract class ContaBancaria {
    private int numero;
    private double saldo;
    private String CPF;
    private String nome;
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

    public ContaBancaria(String nome, String CPF, int numero, double saldo) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = numero;
        this.saldo = saldo;
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
