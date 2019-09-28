package br.ufrn.imd.lp2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * @author Igor Silva
 * @since 2019.2
 * @version 2.0
 */
public class Main{
    private static Scanner ler;
    private static Banco banco;

    public static void main(String[] args) {
        ler = new Scanner(System.in);
        banco = new Banco("Bradesco");
        int opcao;

        do{
            System.out.println(" ------ ");
            System.out.println("| MENU |");
            System.out.println(" ------ ");
            System.out.println("0- Finalizar");
            System.out.println("1- Criar Conta");
            System.out.println("2- Selecionar Conta");
            System.out.println("3- Remover Conta");
            System.out.println("4- Gerar Relatorio");
            System.out.println("5- Configurar Conta");
            System.out.println("6- Encerrar Conta");
            System.out.println("7- Pesquisa por Nome");
            opcao = ler.nextInt();
            switch (opcao){
                case 0:
                    break;
                case 1:
                    criarConta();
                    break;
                case 2:
                    selecionarConta();
                    break;
                case 3:
                    removerConta();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    editarConta();
                    break;
                case 6:
                    fecharConta();
                    break;
                case 7:
                    pesquisarNomeTitularConta();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }while(opcao != 0);

    }

    private static void pesquisarNomeTitularConta() {
        String nome;
        ArrayList <ContaBancaria> busca = new ArrayList<>();

        ler.nextLine();
        System.out.println("Insira o nome da busca: ");
        nome = ler.nextLine();

        //TODO-> tem q converter todas as letras para minusculo para comparar

        busca = banco.procurarContaPorTitular(nome);

        if(busca.size() != 0){
            for(ContaBancaria conta : busca){
                conta.mostrarDados();
            }
            return;
        }
        System.out.println("Nao temos clientes com esse nome");
        return;
    }

    private static void fecharConta() {
        String CPF;
        int numero;

        System.out.println("Insira o numero da conta: ");
        numero = ler.nextInt();

        ContaBancaria conta = banco.procurarConta(numero);

        if(conta != null){
            conta.encerrarConta(conta.getCPF());
            return;
        }
        System.out.println("Conta inexistente");
        return;

    }

    private static void editarConta() {
        String nome, CPF;
        int numero;

        System.out.println("Insira o numero da conta: ");
        numero = ler.nextInt();

        ContaBancaria conta = banco.procurarConta(numero);

        if(conta != null){
            ler.nextLine();
            System.out.println("Insira seu nome: ");
            nome = ler.nextLine();
            System.out.println("Insira seu CPF: ");
            CPF = ler.nextLine();

            //TODO->problema: como passar os novos dados sem escrever por cima, pois precisamos pesquisar os dados antigos
            //resolvido: passei configurar e encerrar para a classe ContaBancaria
            conta.configurarConta(nome, CPF);
            return;
        }
        System.out.println("Conta inexistente");
        return;

    }

    private static void criarConta() {
        String nome, CPF;
        int opcao = -1, numero;
        Random random;
        ContaBancaria conta, auxiliar;

        while(opcao != 0 && opcao != 1 && opcao != 2){
            System.out.println("0- Voltar ao Menu Anterior");
            System.out.println("1- Conta Corrente");
            System.out.println("2- Conta Poupanca");
            opcao = ler.nextInt();

            switch (opcao){
                case 0:
                    break;
                case 1:
                    ler.nextLine();
                    System.out.println("Insira o nome: ");
                    nome = ler.nextLine();
                    System.out.println("Insira seu CPF: ");
                    CPF = ler.nextLine();
                    random = new Random();
                    numero = random.nextInt(10000)+1;
                    auxiliar = banco.procurarConta(numero);
                    while(auxiliar != null){ //garante um numero unico para cada conta
                        numero = random.nextInt(10000)+1;
                        auxiliar = banco.procurarConta(numero);
                    }
                    conta = new ContaCorrente(nome, CPF, numero, 0);
                    banco.inserir(conta);
                    System.out.println("Numero da sua conta: " + conta.getNumeroConta());
                    break;
                case 2:
                    ler.nextLine();
                    System.out.println("Insira o nome: ");
                    nome = ler.nextLine();
                    System.out.println("Insira seu CPF: ");
                    CPF = ler.nextLine();
                    random = new Random();
                    numero = random.nextInt(10000)+1;
                    auxiliar = banco.procurarConta(numero);
                    while(auxiliar != null){ //garante um numero unico para cada conta
                        numero = random.nextInt(10000)+1;
                        auxiliar = banco.procurarConta(numero);
                    }
                    conta = new ContaPoupanca(nome, CPF, numero, 0);
                    banco.inserir(conta);
                    System.out.println("Numero da sua conta: " + conta.getNumeroConta());
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }
    }

    private static void selecionarConta(){
        int numeroConta, opcao;
        double valor;
        System.out.println("Insira o numero da conta: ");
        numeroConta = ler.nextInt();
        ContaBancaria conta = banco.procurarConta(numeroConta);

        if(conta != null){
            do {
                System.out.println("0- Voltar ao Menu Anterior");
                System.out.println("1- Depositar");
                System.out.println("2- Sacar");
                System.out.println("3- Transferir");
                System.out.println("4- Gerar Relatorio");
                opcao = ler.nextInt();

                switch (opcao){
                    case 1:
                        System.out.println("Insira o valor do deposito: ");
                        valor = ler.nextDouble();
                        conta.depositar(valor);
                        break;
                    case 2:
                        System.out.println("Insira o valor do saque:");
                        valor = ler.nextDouble();
                        conta.sacar(valor);
                        break;
                    case 3:
                        System.out.println("Numero da Conta para tranferencia: ");
                        numeroConta = ler.nextInt();
                        ContaBancaria tmp = banco.procurarConta(numeroConta);
                        if(tmp != null){
                            System.out.println("Insira o valor a ser transferido: ");
                            valor = ler.nextDouble();
                            if(conta.transferir(tmp, valor)){
                                System.out.println("Transferencia feita com sucesso!");
                                break;
                            }
                            System.out.println("Valor do saque indisponivel!");
                            break;
                        }
                        System.out.println("Conta inexistente!");
                        break;
                    case 4:
                        conta.mostrarDados();
                }

            }while(opcao != 0);

        }else{
            System.out.println("Conta Inexistente");
            return;
        }
    }

    private static void removerConta() {
            int numeroConta;
            System.out.println("Insira o numero da conta: ");
            numeroConta = ler.nextInt();
            ContaBancaria conta = banco.procurarConta(numeroConta);

            if(conta != null){
                banco.remover(conta);
                return;
            }
            return;

    }
    private  static void gerarRelatorio(){
        banco.mostrarDados();
    }

}
