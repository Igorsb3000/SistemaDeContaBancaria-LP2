package br.ufrn.imd.lp2;
import org.junit.Test;

public class ContaBancariaTest {

    @Test
    /**
     * Item 6 do exercicio
     */
    public void testandoDuasContas(){
        ContaBancaria contaCorrente = new ContaCorrente("Igor", "22344", 1223, 0);
        ContaBancaria contaPoupanca = new ContaPoupanca("Luciano", "34444", 1334, 0);
        Relatorio  relatorio = new Relatorio();

        contaCorrente.depositar(200); // -5 da taxa
        contaPoupanca.depositar(200);

        contaCorrente.sacar(100); // -5 da taxa
        contaPoupanca.sacar(700);

        relatorio.gerarRelatorio(contaCorrente);
        relatorio.gerarRelatorio(contaPoupanca);
    }

}