
package br.ufrn.imd.lp2;
import org.junit.Test;

import java.time.LocalDateTime;

public class ContaBancariaTest {
    @Test
    /**
     * Item 6 do exercicio
     */
    public void testandoDuasContas(){
        Banco banco = new Banco("Caixa");
        LocalDateTime dataAtual = LocalDateTime.now();
        ContaBancaria contaCorrente = new ContaCorrente("FULANO", "100.000.000-01", 123, 0, dataAtual, null, true);
        ContaBancaria contaPoupanca = new ContaPoupanca("BELTRANO", "100.000.000-02", 456, 0, dataAtual, null, true);

        Relatorio  relatorio = new Relatorio();

        banco.inserir(contaCorrente);
        banco.inserir(contaPoupanca);

        contaCorrente.depositar(200); // -5 da taxa
        contaPoupanca.depositar(200);

        contaCorrente.sacar(100); // -5 da taxa
        contaPoupanca.sacar(700);

        relatorio.gerarRelatorio((Imprimivel) contaCorrente);
        relatorio.gerarRelatorio((Imprimivel) contaPoupanca);
    }

}
