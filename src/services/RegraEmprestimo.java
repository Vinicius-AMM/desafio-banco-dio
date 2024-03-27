package services;

public class RegraEmprestimo {
    private static final double JUROS = 0.10;
    private static final double JUROS_MENSAL = 0.03;

    public double taxaPagamento(double valor){
        return valor * JUROS;
    }
    public double taxa(double valor, int meses){
        return valor * JUROS_MENSAL * meses;
    }



}
