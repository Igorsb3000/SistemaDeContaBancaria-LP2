package br.ufrn.imd.lp2;

public class ContaPoupanca extends ContaBancaria {
    private double limite = 500;

    public ContaPoupanca(String nome, String CPF, int numero, double saldo){
        super(nome, CPF, numero, saldo);
    }

    public double getLimite(){
        return limite;
    }

    @Override
    public boolean sacar(double valor) {
        double saque = valor;
        if(this.getSaldo() - saque >= this.getLimite() * -1){
            this.setSaldo(this.getSaldo() - saque);
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
        System.out.println("***Conta Poupanca***");
        System.out.println("Cliente: " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Numero da Conta: " + this.getNumeroConta());
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Limite: R$" + this.getLimite());
        System.out.println();

    }

}
