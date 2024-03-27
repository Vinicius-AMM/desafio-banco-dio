package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoEmprestimo {
    private Integer numero;
    private LocalDate data;
    private double valorTotal;
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public ContratoEmprestimo(Integer numero, LocalDate data, double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
