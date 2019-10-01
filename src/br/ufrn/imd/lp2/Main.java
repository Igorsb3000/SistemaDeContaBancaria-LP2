package br.ufrn.imd.lp2;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Igor Silva, Marcio Tenorio, Lindonilson de Oliveira e Luiz Lopes (GRUPO 3)
 * @since 2019.2
 * @version 2.0.2
 */
public class Main{
    private static Scanner ler;
    private static Banco banco;

    public static void main(String[] args) {
        ler = new Scanner(System.in);
        banco = new Banco("Bradesco");
        int opcao;
        LocalDateTime dataAtual = LocalDateTime.now();

        ContaBancaria conta1 = new ContaPoupanca("JOAO", "100.000.000-11", 222, 100.00, dataAtual, dataAtual, false);
        ContaBancaria conta2 = new ContaPoupanca("MARIA", "100.000.000-02", 112, 200.00, dataAtual, null, true);
        ContaBancaria conta3 = new ContaCorrente("JOAO", "100.000.000-01", 110, 50.00, dataAtual, null, true);
        ContaBancaria conta4 = new ContaCorrente("MARIA", "100.000.000-02", 902, 10.00, dataAtual, dataAtual, false);
        ContaBancaria conta5 = new ContaCorrente("ZECA", "100.000.000-03", 2330, 250.00, dataAtual, null, true);

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

        System.out.println("***** Ordenado pelo CPF do Titular *****");
        Collections.sort(banco.getBanco(), new ContaCPFComparator());
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
            System.out.println("8- Pesquisa por CPF");
            System.out.println("9- Tipos de Ordenacoes");
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
                    desativarConta();
                    break;
                case 7:
                    pesquisarNomeTitularConta();
                    break;
                case 8:
                    pesquisarCPFTitularConta();
                    break;
                case 9:
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
            System.out.println("2- Ordenar pelo CPF do Titular");
            System.out.println("3- Ordenar por Nome do Titular e pelo CPF");
            System.out.println("4- Ordenar pelo Status da Conta");
            System.out.println("5- Ordenar por Nome do Titular e pelo Status");
            System.out.println("6- Ordenar por CPF e pelo Status");
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
                    Collections.sort(banco.getBanco(), new ContaCPFComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 3:
                    Collections.sort(banco.getBanco(), new ContaNomeECPFComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 4:
                    Collections.sort(banco.getBanco(), new ContaStatusComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 5:
                    Collections.sort(banco.getBanco(), new ContaNomeTitularEStatusComparator());
                    for(ContaBancaria conta : banco.getBanco()){
                        conta.mostrarDados();
                    }
                    break;
                case 6:
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

    private static void pesquisarCPFTitularConta() {
        String CPF;
        List<ContaBancaria> busca;

        ler.nextLine();
        do {
            System.out.println("Insira o CPF para busca(ex: 100.000.000-00): ");
            CPF = ler.nextLine();
        }while(CPF.length() != 14 || CPF.charAt(3) != '.' || CPF.charAt(7) != '.' || CPF.charAt(11) != '-');

        busca = banco.procurarContaPorCPF(CPF);

        if(busca.size() != 0){
            for(ContaBancaria conta : busca){
                conta.mostrarDados();
            }
            return;
        }
        System.out.println("Nao temos clientes com esse CPF");
    }
    private static void pesquisarNomeTitularConta() {
        String nome;
        List<ContaBancaria> busca;

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
    }

    private static void desativarConta() {
        String CPF;
        ler.nextLine();
        do {
            System.out.println("Insira seu CPF(ex: 100.000.000-00): ");
            CPF = ler.nextLine();
        }while(CPF.length() != 14 || CPF.charAt(3) != '.' || CPF.charAt(7) != '.' || CPF.charAt(11) != '-');
        banco.encerrarConta(CPF);
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
            do {
                System.out.println("Insira seu CPF(ex: 100.000.000-00): ");
                CPF = ler.nextLine();
            }while(CPF.length() != 14 || CPF.charAt(3) != '.' || CPF.charAt(7) != '.' || CPF.charAt(11) != '-');
            nome = nome.toUpperCase();
            conta.configurarConta(nome, CPF);
            return;
        }
        System.out.println("Conta inexistente");
    }

    private static void criarConta() {
        String nome, CPF;
        int opcao = -1;
        ContaBancaria conta;

        while(opcao != 0 && opcao != 1 && opcao != 2){
            System.out.println("0- Voltar ao Menu Anterior");
            System.out.println("1- Fazer o Cadastro");
            opcao = ler.nextInt();

            switch (opcao){
                case 0:
                    break;
                case 1:
                    ler.nextLine();
                    System.out.println("Insira o nome: ");
                    nome = ler.nextLine();
                    do {
                        System.out.println("Insira seu CPF(ex: 100.000.000-00): ");
                        CPF = ler.nextLine();
                    }while(CPF.length() != 14 || CPF.charAt(3) != '.' || CPF.charAt(7) != '.' || CPF.charAt(11) != '-');

                    nome = nome.toUpperCase();
                    conta = banco.criarConta(nome, CPF);
                    if(conta != null){
                        System.out.println("Numero da sua conta: " + conta.getNumeroConta());
                        break;
                    }
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
        }
    }

    private static void removerConta() {
            int numeroConta;
            System.out.println("Insira o numero da conta: ");
            numeroConta = ler.nextInt();
            ContaBancaria conta = banco.procurarConta(numeroConta);

            if(conta != null){
                banco.remover(conta);
            }
    }
    private  static void gerarRelatorio(){
        banco.mostrarDados();
    }
}
