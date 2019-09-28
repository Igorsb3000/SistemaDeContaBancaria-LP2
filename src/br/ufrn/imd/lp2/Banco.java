package br.ufrn.imd.lp2;

//import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

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
        for(ContaBancaria conta : banco){
            if(conta.getNumeroConta() == numero){
                return conta;
            }
        }
        return null;
    }

    public ArrayList<ContaBancaria> procurarContaPorTitular(String nome){
        ArrayList<ContaBancaria> tmp = new ArrayList<>();
        for(ContaBancaria conta : banco){
            if(conta.getNome().contains(nome)){
                tmp.add(conta);
            }
        }
        return tmp;
    }
    public ArrayList<ContaBancaria> procurarContaPorCPF(String CPF){
        ArrayList<ContaBancaria> tmp = new ArrayList<>();
        for(ContaBancaria conta : banco){
            if(conta.getCPF() == CPF){
                tmp.add(conta);
            }
        }
        return tmp;
    }



    public void mostrarDados(){
        System.out.println(" -----------------------------------");
        System.out.println("| *** Clientes do Banco " + this.getNomeBanco() + "*** |  ");
        System.out.println(" -----------------------------------");
        //Collections.sort(banco);

        for(ContaBancaria x : banco){
            x.mostrarDados();
            System.out.println();
        }
    }

    /*public void procurarContaPorTitular(String nomeTitular){
        for( ContaBancaria contas : banco ){
            if( contas.getNome().contains(nomeTitular) && contas.getAtivo() ){
                System.out.println("Nome: " + contas.getNome());
                System.out.println("Numero da conta: " + contas.getNumeroConta());
            }
        }
    }*/


}
