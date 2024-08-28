package co.com.jorge.lesson.one.workshop;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BankAccount {
    private List<Transaction> transactions;

    public BankAccount() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getTotalBalance() {
        Map<String, Function<Transaction, Double>> transactionTypeToAmount = new HashMap<>();
        transactionTypeToAmount.put("deposit", Transaction::getAmount);
        transactionTypeToAmount.put("withdrawal", tx -> -tx.getAmount());
        return transactions.stream()
                .map(transaction -> transactionTypeToAmount.getOrDefault(transaction.getType(), x -> 0.0).apply(transaction))
                .reduce(0.0, Double::sum);
    }

    public List<Transaction> getDeposits() {
        return transactions
                .stream()
                .filter(transaction -> transaction.getType().equals("deposit"))
                .collect(Collectors.toList());
    }

    public Optional<Transaction> getTransactionWithHighestAmount() {
        return transactions
                .stream()
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }
}
