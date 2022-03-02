package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account With Atm allows the deposit
 * and the withdrawal using the ATM.
 * Each transaction done with the ATM implies paying a 1$ fee.
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount{

    public static final double FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(int userID, double amount) {
        final double amountATM = amount - FEE;
        if (checkUser(userID)) {
            balance += (amountATM);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        final double amountATM = amount + FEE;
        if (checkUser(userID) && isWithdrawAllowed(amountATM)) {
            balance -= (amountATM);
        }
    }
}
