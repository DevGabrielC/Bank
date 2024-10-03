package co.devgabrielc.bank;

import com.sun.jdi.Value;

public class Account {
    // definindo uma constante
    static final int MAX_LENGTH = 30;

    private String ag; // agencia
    private String cc; // conta corrente
    private String name; // nome
    private double balance;
    private Log logger;

    public Account(String ag, String cc, String name) { // construtor
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    // metodo para verificar se o nome possui mais de 30 caracteres, se possuir, vai salvar até o 30 caractere
    public void setName(String name) {
        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    public void deposit (double value) {
        balance += value;
        logger.out("DEPOSITO - R$" + String.format("%.2f", value) + " Sua conta agora é de R$" + String.format("%.2f", balance));
    }

    public boolean withDraw(double value) {
        if (balance < value) {
            logger.out("SAQUE - R$" + String.format("%.2f", value) + " Seu saldo atual é de R$" + String.format("%.2f", balance));
            return false;
        } else {
            balance -= value;
            logger.out("SAQUE - R$" + String.format("%.2f", value) + " Sua conta agora é de R$" + String.format("%.2f", balance));
            return true;
        }

    }

    public String toString() {
        return "A conta: " + this.name + " | Agencia: " + this.ag + " | CC: " + this.cc + " | Possui: R$" + String.format("%.2f", balance);
    }

    public double getBalance() {
        return balance;
    }
}
