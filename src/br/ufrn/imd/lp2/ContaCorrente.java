package br.ufrn.imd.lp2;

public class ContaCorrente extends ContaBancaria implements Imprimivel{
    private double taxaDeOperacao = 5.00;

    public ContaCorrente(String nome, String CPF, int numero, double saldo){
        super(nome, CPF, numero, saldo);
    }

    public double getTaxaDeOperacao(){
        return taxaDeOperacao;
    }

    @Override
    public boolean sacar(double valor) {
        double saque = valor;
        if(this.getSaldo() - saque - taxaDeOperacao >= 0){
            this.setSaldo(this.getSaldo() - saque - taxaDeOperacao);
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

    public void mostrarDados(){
        System.out.println("***Conta Corrente***");
        System.out.println("Cliente: " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Numero da Conta: " + this.getNumeroConta());
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Taxa de Operacao: R$" + this.getTaxaDeOperacao());
        System.out.println();
    }

}
