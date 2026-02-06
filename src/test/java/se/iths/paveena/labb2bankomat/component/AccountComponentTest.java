package se.iths.paveena.labb2bankomat.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountComponentTest {

    private AccountComponent account;

    @BeforeEach
    public void setUp() {
        account = new AccountComponent();
    }

    @Test
    @DisplayName("Test whether balance is zero from the beginning")
    public void balanceBeginWithZero() {
        int result = account.getBalance();
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test whether balance is increasing when deposit")
    public void depositIncreaseBalance() {
        int result = account.deposit(500);
        assertEquals(500,result);
    }

    @Test
    @DisplayName("Test to take out when balance is empty")
    public void withdrawWhenBalanceEmpty() {
        int result = account.withdraw(500);
        assertEquals(-500, result);
    }

    @Test
    @DisplayName("Test deposit and withdraw in the same test")
    public void withDrawDecreaseBalance() {
        account.deposit(500);
        account.withdraw(100);
        int result = account.getBalance();
        assertEquals(400,result);
    }
}
