package co.com.jorge.lesson.three.workshop;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class BankAccount {
    private List<Transaction> transactions;

    public BankAccount() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // TODO 1: Implementar getTotalBalance utilizando streams y reduce
    public Optional<Double> getTotalBalance() {
        return Optional.of(transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum());
    }

    // TODO 2: Implementar getDeposits utilizando streams y filter
    public Optional<List<Transaction>> getDeposits() {
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getType().equals("deposit"))
                .collect(Collectors.toList()));
    }

    // TODO 3: Implementar getWithdrawals utilizando streams y filter
    public Optional<List<Transaction>> getWithdrawals() {
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getType().equals("withdrawal"))
                .collect(Collectors.toList()));
    }

    // TODO 4: Implementar filterTransactions utilizando Function y streams
    public Optional<List<Transaction>> filterTransactions(Function<Transaction, Boolean> predicate) {
        return Optional.of(transactions.stream()
                .filter(predicate::apply)
                .collect(Collectors.toList()));
    }

    // TODO 5: Implementar getTotalDeposits utilizando getDeposits y mapToDouble
    public Optional<Double> getTotalDeposits() {
        return Optional.of(getDeposits().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Transaction::getAmount)
                .sum());
    }

    // TODO 6: Implementar getLargestWithdrawal utilizando getWithdrawals y max
    public Optional<Transaction> getLargestWithdrawal() {
        return getWithdrawals().stream()
                .flatMap(Collection::stream)
                .max(Comparator.comparing(Transaction::getAmount));


    }

    // TODO 7: Implementar getTransactionsOnDate utilizando streams y filter
    public Optional<List<Transaction>> getTransactionsOnDate(String date) {
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList()));

    }

    // TODO 8: Implementar getAverageTransactionAmount utilizando streams y mapToDouble
    public OptionalDouble getAverageTransactionAmount() {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average();

    }

    // TODO 9: Implementar getTransactionsWithAmountGreaterThan utilizando streams y filter
    public Optional<List<Transaction>> getTransactionsWithAmountGreaterThan(double amount) {
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getAmount() > amount)
                .collect(Collectors.toList()));

    }

    // TODO 10: Implementar transfer utilizando addTransaction
    public static void transfer(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
        sourceAccount.addTransaction(new Transaction(-amount, "withdrawal", new Date().toString()));
        targetAccount.addTransaction(new Transaction(amount, "deposit", new Date().toString()));

    }

    // TODO 11: Implementar getTotalWithdrawals utilizando getWithdrawals y mapToDouble
    public Optional<Double> getTotalWithdrawals() {
        return Optional.of(getWithdrawals().stream()
                        .flatMap(Collection::stream)
                        .mapToDouble(Transaction::getAmount)
                        .sum());

    }

    // TODO 12: Implementar getTransactionsSummary utilizando streams, map y collect
    public Map<String, Double> getTransactionsSummary() {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)));

    }
}