package co.com.jorge.lesson.three.workshop;


public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.addTransaction(new Transaction(100, "deposit", "2024-05-13"));
        account.addTransaction(new Transaction(50, "withdrawal", "2024-05-14"));
        account.addTransaction(new Transaction(200, "deposit", "2024-05-15"));
        account.addTransaction(new Transaction(150, "deposit", "2024-05-16"));
        account.addTransaction(new Transaction(75, "withdrawal", "2024-05-17"));

        // Prueba las funcionalidades aquí
        // Puedes comentar estas líneas y pedir a los estudiantes que las descomenten una vez que hayan completado los TODOs

        account.getTotalBalance().ifPresent(balance -> System.out.println("Saldo total: " + balance));
        account.getTotalDeposits().ifPresent(total -> System.out.println("Total de depósitos: " + total));
        account.getLargestWithdrawal().ifPresent(transaction -> System.out.println("Retiro de mayor monto: " + transaction.getAmount()));
        account.getTransactionsOnDate("2024-05-13").ifPresent(transactions -> transactions.forEach(transaction -> System.out.println(transaction.getAmount())));
        account.getAverageTransactionAmount().ifPresent(average -> System.out.println("Promedio de montos: " + average));
        account.getTransactionsWithAmountGreaterThan(100).ifPresent(transactions -> transactions.forEach(transaction -> System.out.println(transaction.getAmount())));
        BankAccount targetAccount = new BankAccount();
        BankAccount.transfer(account, targetAccount, 50);
        targetAccount.getTotalBalance().ifPresent(balance -> System.out.println("Saldo total de la cuenta destino: " + balance));
        account.getTotalWithdrawals().ifPresent(total -> System.out.println("Total de retiros: " + total));
        account.getTransactionsSummary().forEach((type, sum) -> System.out.println("Tipo: " + type + ", Total: " + sum));
    }
}
