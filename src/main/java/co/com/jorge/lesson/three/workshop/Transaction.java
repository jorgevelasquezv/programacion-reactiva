package co.com.jorge.lesson.three.workshop;

class Transaction {
    private final double amount;
    private final String type; // "deposit" o "withdrawal"
    private final String date;

    public Transaction(double amount, String type, String date) {
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}