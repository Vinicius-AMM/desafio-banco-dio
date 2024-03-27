package entities;

import exceptions.BusinessException;
import interfaces.IConta;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia = 1;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    /*limite de retirada tambem pode ser utilizado sendo definido antes pelo cliente
    caso nao queira liberar o saldo total
    mas aqui utilizei ela recebendo o mesmo valor que o saldo somente para exemplo
     */
    private double limiteRetirada;


    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public double getLimiteRetirada() {
        return limiteRetirada = saldo;
    }

    public void setLimiteRetirada(double limiteRetirada) {
        this.limiteRetirada = limiteRetirada;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void sacar(double valor) {
        validacaoSaque(valor);
        saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private void validacaoSaque(double valor){
        if(valor > getLimiteRetirada()){
            throw new BusinessException("Erro no saque: o valor excede o limite de retirada");
        }
        if(valor > getSaldo()){
            throw new BusinessException("Saldo insuficiente para concluir transacao!");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
