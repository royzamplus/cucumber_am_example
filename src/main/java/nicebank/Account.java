package nicebank;

/**
 * Created by liudi on 4/25/15.
 */
public class Account {
    private Money balance = new Money();

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public Money getBalance() {
        return balance;
    }
}
