package br.ufrn.imd.lp2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Banco implements Imprimivel{
    private static Scanner ler;
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

    public ContaBancaria criarConta(String nome, String CPF) {
        ler = new Scanner(System.in);
        Random random;
        int numero, opcao;
        ContaBancaria auxiliar, conta;
        LocalDateTime dataAtual = LocalDateTime.now();

        if(!this.validarCliente(nome, CPF)){
            System.out.println("Cliente ja possui cadastro com outros dados");
            return null;
        }
        random = new Random();
        numero = random.nextInt(10000)+1;
        auxiliar = this.procurarConta(numero);
        while(auxiliar != null){ //garante um numero unico para cada conta
            numero = random.nextInt(10000)+1;
            auxiliar = this.procurarConta(numero);
        }

        do {
            System.out.println("0- Voltar ao Menu Principal");
            System.out.println("1- Conta Corrente");
            System.out.println("2- Conta Poupanca");
            opcao = ler.nextInt();

            if(opcao == 1){
                conta = new ContaCorrente(nome, CPF, numero, 0, dataAtual, null, true);
                break;
            }else{
                conta = new ContaPoupanca(nome, CPF, numero, 0, dataAtual, null, true);
                break;
            }

        }while(opcao != 1 && opcao != 2);

        this.inserir(conta);
        return conta;
    }

    public void encerrarConta(String CPF) {
        ler = new Scanner(System.in);
        int numero;
        List <ContaBancaria> contas = procurarContaPorCPF(CPF);

        if(contas != null){
            System.out.println("***Lista de Todas as Contas Ativas do Cliente***");
            for(ContaBancaria conta : contas){
                if(conta.getAtivo()){
                    System.out.println("Numero da Conta: " + conta.getNumeroConta());
                }
            }
            System.out.println();
            System.out.println("Insira o numero da conta a ser encerrada: ");
            numero = ler.nextInt();

            for(ContaBancaria conta : contas){
                if(conta.getNumeroConta() == numero){
                    if(conta.getAtivo()){
                        conta.setAtivo(false);
                        conta.setDataEncerramento(LocalDateTime.now());
                        System.out.println("Sua conta foi encerrada com sucesso!");
                        return;
                    }
                    System.out.println("Conta ja encerrada anteriormente");
                    return;
                }
            }
        }
        System.out.println("CPF nao cadastrado");
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
        if(!this.getBanco().contains(conta)){
            this.getBanco().add(conta);
            System.out.println("Conta cadastrada com sucesso!");
            System.out.println();
            return true;
        }
        System.out.println("Conta ja cadastrada");
        System.out.println();
        return false;
    }

    public boolean remover(ContaBancaria conta){
        if(this.getBanco().contains(conta)){
            this.getBanco().remove(conta);
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
        for(ContaBancaria conta : this.getBanco()){
            if(conta.getCPF().equals(CPF)){
                tmp.add(conta);
            }
        }
        if(tmp.size() == 0){
            tmp = null;
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
