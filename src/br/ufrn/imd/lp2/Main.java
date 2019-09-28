package br.ufrn.imd.lp2;

import java.util.ArrayList;
import java.util.Collections;
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

        ContaBancaria conta1 = new ContaPoupanca("IGOR", "1234", 222, 0);
        ContaBancaria conta2 = new ContaPoupanca("LINDONILSON", "1234", 112, 0);
        ContaBancaria conta3 = new ContaCorrente("MARCIO", "12345", 110, 0);
        ContaBancaria conta4 = new ContaCorrente("LUIZ", "12345", 902, 0);
        ContaBancaria conta5 = new ContaCorrente("IGOR", "1234567", 2330, 0);

        conta2.encerrarConta("12345");
        conta5.encerrarConta("1234567");

        banco.inserir(conta1);
        banco.inserir(conta2);
        banco.inserir(conta3);
        banco.inserir(conta4);
        banco.inserir(conta5);

        System.out.println("***** Ordenado por Nome do Titular *****");
        Collections.sort(banco.getBanco());
        for(ContaBancaria conta : banco.getBanco()){
            conta.mostrarDados();
        }
        System.out.println();

        System.out.println("***** Ordenado por Nome e CPF do Titular *****");
        Collections.sort(banco.getBanco(), new ContaNomeECPFComparator());
        for(ContaBancaria conta : banco.getBanco()){
            conta.mostrarDados();
        }
        System.out.println();

        System.out.println("***** Ordenado pelo Status da Conta *****");
        Collections.sort(banco.getBanco(), new ContaStatusComparator());
        for(ContaBancaria conta : banco.getBanco()){
            conta.mostrarDados();
        }
        System.out.println();

        System.out.println("***** Ordenado por Nome do Titular e pelo Status *****");
        Collections.sort(banco.getBanco(), new ContaNomeTitularEStatusComparator());
        for(ContaBancaria conta : banco.getBanco()){
            conta.mostrarDados();
        }
        System.out.println();

        System.out.println("***** Ordenado por CPF do Titular e pelo Status *****");
        Collections.sort(banco.getBanco(), new ContaCPFTitularEStatusComparator());
        for(ContaBancaria conta : banco.getBanco()){
            conta.mostrarDados();
        }

        banco.remover(conta1);
        banco.remover(conta2);
        banco.remover(conta3);
        banco.remover(conta4);
        banco.remover(conta5);

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
            System.out.println("8- Tipos de Ordenacoes");
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
                case 8:
                    ordenarBanco();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }while(opcao != 0);

    }

    private static void ordenarBanco() {
        int opcao = -1;

        while(opcao != 0 && opcao != 1 && opcao != 2){
            System.out.println("0- Voltar ao Menu Anterior");
            System.out.println("1- Ordenar por Nome do Titular");
            System.out.println("2- Ordenar por Nome do Titular e pelo CPF");
            System.out.println("3- Ordenar pelo Status da Conta");
            System.out.println("4- Ordenar por Nome do Titular e pelo Status");
            System.out.println("5- Ordenar por CPF e pelo Status");
            opcao = ler.nextInt();

            switch (opcao){
                case 0:
                    break;
                case 1:
                    Collections.sort(banco.getBanco());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 2:
                    Collections.sort(banco.getBanco(), new ContaNomeECPFComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 3:
                    Collections.sort(banco.getBanco(), new ContaStatusComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 4:
                    Collections.sort(banco.getBanco(), new ContaNomeTitularEStatusComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 5:
                    Collections.sort(banco.getBanco(), new ContaCPFTitularEStatusComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }
    }

    private static void pesquisarNomeTitularConta() {
        String nome;
        ArrayList <ContaBancaria> busca = new ArrayList<>();

        ler.nextLine();
        System.out.println("Insira o nome da busca: ");
        nome = ler.nextLine();

        //Transformar todos os caracteres para maiusculo, facilita a busca
        nome = nome.toUpperCase();
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
                    nome = nome.toUpperCase();
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
                    nome = nome.toUpperCase();
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
