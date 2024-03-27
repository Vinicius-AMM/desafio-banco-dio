package services;

import entities.ContratoEmprestimo;
import entities.Emprestimo;

import java.time.LocalDate;
import java.util.Locale;

public class ContratoServico {
    private RegraEmprestimo regraEmprestimo;
    public ContratoServico(RegraEmprestimo regraEmprestimo){
        this.regraEmprestimo = regraEmprestimo;
    }

    public void processoContrato(ContratoEmprestimo contratoEmprestimo, int meses){
        double valorBasico = contratoEmprestimo.getValorTotal() / meses;
        for(int i = 1; i <= meses; i++){
            LocalDate dataVencimento = contratoEmprestimo.getData().plusMonths(i);
            double juros = regraEmprestimo.taxa(valorBasico, i);
            double taxa = regraEmprestimo.taxaPagamento(valorBasico + juros);
            double quantia = valorBasico + juros + taxa;
            contratoEmprestimo.getEmprestimos().add(new Emprestimo(dataVencimento, quantia));
        }
    }
}
