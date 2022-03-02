package lab01.example.model;

/**
 * This abstract class implements all the main common functions of an implementation of bank account
 */
public abstract class AbstractBankAccount implements BankAccount {

    protected double balance;
    protected final AccountHolder holder;

    public AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    protected boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }
}
