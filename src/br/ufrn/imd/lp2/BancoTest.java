package br.ufrn.imd.lp2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BancoTest {

    @Test
    public void inserirCliente() {
        //Arranje
        Banco banco = new Banco("Caixa");
        ContaBancaria contaCorrente = new ContaCorrente("fulano", "122222", 123, 300);
        ContaBancaria contaPoupanca = new ContaPoupanca("beltrano", "12233", 456, 500);

        //Act
        boolean resultado1 = banco.inserir(contaCorrente);
        boolean resultado2 = banco.inserir(contaPoupanca);

        //Assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado1);
        assertEquals(resultado_esperado, resultado2);
    }


    @Test
    public void removerCliente(){
        //Arranje
        Banco banco = new Banco("Caixa");
        ContaBancaria contaCorrente = new ContaCorrente("fulano", "122222", 123, 300);
        ContaBancaria contaPoupanca = new ContaPoupanca("beltrano", "12233", 456, 500);

        //Act
        banco.inserir(contaCorrente);
        banco.inserir(contaPoupanca);
        boolean resultado1 = banco.remover(contaCorrente);
        boolean resultado2 = banco.remover(contaPoupanca);

        //Assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado1);
        assertEquals(resultado_esperado, resultado2);
    }

    @Test
    public void procurarCliente(){
        //Arranje
        Banco banco = new Banco("Caixa");
        ContaBancaria contaCorrente = new ContaCorrente("fulano", "122222", 123, 300);
        boolean resultado1;

        //Act
        banco.inserir(contaCorrente);
        ContaBancaria tmp = banco.procurarConta(123);
        if(tmp.getNumeroConta() == 123){
            resultado1 = true;
        }else{
            resultado1 = false;
        }

        //Assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado1);
    }



}