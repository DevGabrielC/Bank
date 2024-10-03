package co.devgabrielc.bank;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Bank Santander = new Bank("0001");

        // Criar uma conta (agência, conta, nome)
        // Limite de caracteres para o usuário em 12 caracteres
        while (true) {
            // C: Criar conta
            // E: Sair (exit)
            System.out.println("O que deseja fazer? C: Criar conta, E: Sair do programa");
            String operation = sc.nextLine();

            if (operation.equals("C")) {
                System.out.println("Digite o seu nome");
                String name = sc.nextLine();
                Account account = Santander.generateAccount(name);
                Santander.insertAccount(account);
                operateAccount(account);
            } else if (operation.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido! Tente novamente.");
            }
        }

        List<Account> accountList = Santander.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }

        Santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner sc = new Scanner(System.in);
        // Depositar, Saque, Sair
        while (true) {
            System.out.println("O que deseja fazer? D: Deposito, S: Saque, E: Sair");
            // D = Deposito
            // S = Saque
            // E = Sair (exit)
            String operation = sc.nextLine();

            if (operation.equals("D")){
                System.out.println("Qual valor deseja depositar? ");
                double value = sc.nextDouble();
                account.deposit(value);
            } else if (operation.equals("S")) {
                System.out.println("Qual valor deseja sacar? ");
                double value = sc.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Ops! Não foi possivel sacar o valor R$" + value);
                }
            } else if (operation.equals("E")){
                break;
            } else {
                System.out.println("Comando inválido! Tente novamente.");
            }

            sc = new Scanner(System.in);
        }
    }
}