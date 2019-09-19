package br.ufrn.imd.lp2;

import java.util.ArrayList;

public class Banco implements Imprimivel{
    private String nomeBanco;
    private ArrayList <ContaBancaria> banco = new ArrayList<ContaBancaria>();
    public Banco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }
    public String getNomeBanco(){
        return nomeBanco;
    }

    public boolean inserir(ContaBancaria conta){
        if(!banco.contains(conta)){
            banco.add(conta);
            System.out.println("Conta cadastrada com sucesso!");
            System.out.println();
            return true;
        }
        System.out.println("Conta ja cadastrada");
        System.out.println();
        return false;
    }

    public boolean remover(ContaBancaria conta){
        if(banco.contains(conta)){
            banco.remove(conta);
            System.out.println("Conta removida com sucesso!");
            System.out.println();
            return true;
        }
        System.out.println("Conta nao existe");
        System.out.println();
        return false;
    }

    public ContaBancaria procurarConta(int numero){
        for(ContaBancaria x : banco){
            if(x.getNumeroConta() == numero){
                return x;
            }
        }
        return null;
    }

    public void mostrarDados(){
        System.out.println(" -----------------------------------");
        System.out.println("| *** Clientes do Banco " + this.getNomeBanco() + "*** |  ");
        System.out.println(" -----------------------------------");
        for(ContaBancaria x : banco){
            x.mostrarDados();
            System.out.println();
        }
    }


}
