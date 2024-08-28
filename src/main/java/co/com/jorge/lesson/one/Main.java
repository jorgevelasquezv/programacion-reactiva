package co.com.jorge.lesson.one;

import co.com.jorge.lesson.one.workshop.BankAccount;
import co.com.jorge.lesson.one.workshop.Transaction;

public class Main {
    private static final String TRANSACTION_TYPE_DEPOSIT = "deposit";
    private static final String TRANSACTION_TYPE_WITHDRAWAL = "withdrawal";

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        bankAccount.addTransaction(new Transaction(100, TRANSACTION_TYPE_DEPOSIT, "2021-01-01"));
        bankAccount.addTransaction(new Transaction(200, TRANSACTION_TYPE_DEPOSIT, "2021-01-02"));
        bankAccount.addTransaction(new Transaction(300, TRANSACTION_TYPE_WITHDRAWAL, "2021-01-03"));
        bankAccount.addTransaction(new Transaction(400, TRANSACTION_TYPE_WITHDRAWAL, "2021-01-04"));
        bankAccount.addTransaction(new Transaction(500, TRANSACTION_TYPE_DEPOSIT, "2021-01-05"));

        System.out.println("Total balance: " + bankAccount.getTotalBalance());
        System.out.println("Deposits: " + bankAccount.getDeposits());
        System.out.println("Transaction with highest amount: " +
                bankAccount
                .getTransactionWithHighestAmount()
                .orElseThrow());

    }
}
