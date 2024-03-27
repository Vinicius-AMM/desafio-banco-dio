package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dataVencimento;
    private double valor;

    public Emprestimo(LocalDate dataVencimento, double valor) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return dataVencimento.format(dtf) + " - " + String.format("%.2f", valor);
    }

}
