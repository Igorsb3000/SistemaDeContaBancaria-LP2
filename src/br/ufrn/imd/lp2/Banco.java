package br.ufrn.imd.lp2;

import java.util.ArrayList;
import java.util.List;

public class Banco implements Imprimivel{
    private String nomeBanco;
    private ArrayList <ContaBancaria> banco = new ArrayList<>();

    public Banco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }

    public String getNomeBanco(){
        return nomeBanco;
    }

    public ArrayList<ContaBancaria> getBanco() {
        return banco;
    }

    //Uma pessoa pode ter mais de uma conta, porem cada pessoa tem apenas um CPF
    public boolean validarCliente(String nome, String CPF){
        for(ContaBancaria conta : banco){
            if(conta.getCPF().equals(CPF)) {
                if(!conta.getNome().equals(nome)){
                    return false;
                }
                return true;
            }
        }
        return true;
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

    public List<ContaBancaria> procurarContaPorTitular(String nome){
        List<ContaBancaria> tmp = new ArrayList<>();
        for(ContaBancaria conta : banco){
            if(conta.getNome().contains(nome)){
                tmp.add(conta);
            }
        }
        return tmp;
    }
    public List<ContaBancaria> procurarContaPorCPF(String CPF){
        List<ContaBancaria> tmp = new ArrayList<>();
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

        for(ContaBancaria x : banco){
            x.mostrarDados();
            System.out.println();
        }
    }

}
