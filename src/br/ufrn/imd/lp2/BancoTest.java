package br.ufrn.imd.lp2;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BancoTest {

    @Test
    public void inserirCliente() {
        //Arranje
        Banco banco = new Banco("Caixa");
        LocalDateTime dataAtual = LocalDateTime.now();
        ContaBancaria contaCorrente = new ContaCorrente("FULANO", "100.000.000-01", 123, 300, dataAtual, null, true);
        ContaBancaria contaPoupanca = new ContaPoupanca("BELTRANO", "100.000.000-02", 456, 500, dataAtual, null, true);

        //Act
        boolean resultado1 = banco.inserir(contaCorrente);
        boolean resultado2 = banco.inserir(contaPoupanca);

        //Assert
        assertTrue(resultado1);
        assertTrue(resultado2);
    }


    @Test
    public void removerCliente(){
        //Arranje
        Banco banco = new Banco("Caixa");
        LocalDateTime dataAtual = LocalDateTime.now();
        ContaBancaria contaCorrente = new ContaCorrente("FULANO", "100.000.000-01", 123, 300, dataAtual, null, true);
        ContaBancaria contaPoupanca = new ContaPoupanca("BELTRANO", "100.000.000-02", 456, 500, dataAtual, null, true);

        //Act
        banco.inserir(contaCorrente);

        boolean resultado1 = banco.remover(contaCorrente);
        boolean resultado2 = banco.remover(contaPoupanca);

        //Assert
        assertTrue(resultado1);
        assertFalse(resultado2);
    }

    @Test
    public void procurarCliente(){
        //Arranje
        Banco banco = new Banco("Caixa");
        LocalDateTime dataAtual = LocalDateTime.now();
        ContaBancaria contaCorrente = new ContaCorrente("FULANO", "100.000.000-01", 123, 300, dataAtual, null, true);
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
        assertTrue(resultado1);
    }



}