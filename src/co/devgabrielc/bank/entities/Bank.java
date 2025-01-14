package co.devgabrielc.bank.entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String ag;
    private List<Account> accounts;
    private int lastAccount = 1;

    public Bank(String ag) {
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // Adicionar contas no Arraylist
    public void insertAccount(Account account) {
        accounts.add(account);
    }

    public Account generateAccount(String name) {
        Account account = new Account(ag, " " + lastAccount, name);
        lastAccount++;
        return account;
    }

    // Retornar valor total no Banco
    public void outputTotal() {
        double total = 0;
        for (Account account : accounts) {
            double accountBalance = account.getBalance();
            total += accountBalance;
        }
        System.out.println("Valor em Banco: R$" + String.format("%.2f", total));
    }
}
