package application;

import entities.*;
import services.ContratoServico;
import services.RegraEmprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Cliente vinicius = new Cliente();
        vinicius.setNome("Vinicius");

        Conta cc = new ContaCorrente(vinicius);
        Conta poupanca = new ContaPoupanca(vinicius);

        cc.depositar(100);
        cc.transferir(80, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println("=== Simulador de emprestimo ===");
        ContratoEmprestimo contratovinicius = new ContratoEmprestimo(1, LocalDate.parse("27/02/2024", fmt), 2000.00);

        ContratoServico simulacao = new ContratoServico(new RegraEmprestimo());
        simulacao.processoContrato(contratovinicius, 23);
        System.out.println("Parcelas: ");
        for(Emprestimo emprestimo : contratovinicius.getEmprestimos()){
            System.out.println(emprestimo);
        }

    }
}