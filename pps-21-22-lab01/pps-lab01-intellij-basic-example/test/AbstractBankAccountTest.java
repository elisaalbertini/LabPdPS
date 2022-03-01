import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the AbstractBankAccount implementation
 */
abstract class AbstractBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @BeforeEach
    public void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }
}