package se.iths.paveena.labb2bankomat.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.paveena.labb2bankomat.component.AccountComponent;
import se.iths.paveena.labb2bankomat.exception.InsufficientFundsException;
import se.iths.paveena.labb2bankomat.exception.InvalidAmountException;
import se.iths.paveena.labb2bankomat.exception.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @InjectMocks
    private ATMService atmService;

    @Mock
    private AccountComponent accountComponent;

    // Felaktig flöde
    @Test
    @DisplayName("Invalid amount should throw exception")
    public void depositInvalidAmountThrowsException() {

        assertThrows(InvalidAmountException.class,
                () -> atmService.deposit(0));
    }

    @Test
    @DisplayName("Withdraw over max amount should throw exception")
    public void withdrawOverMaxThrowsException() {

        assertThrows(MaxWithdrawalExceededException.class,
                () -> atmService.withdraw(2000));
    }

    @Test
    @DisplayName("Withdraw with insufficient funds should throw exception")
    public void withdrawInsufficientFundsThrowsException() {

        when(accountComponent.getBalance()).thenReturn(0);

        assertThrows(InsufficientFundsException.class,
                () -> atmService.withdraw(500));
    }

    //Normal flöde
    @Test
    @DisplayName("Valid deposit should not throw exception")
    public void validDepositNoException() {

        assertDoesNotThrow(() -> atmService.deposit(500));

        verify(accountComponent).deposit(500);
    }

    @Test
    @DisplayName("Valid withdraw should not throw exception")
    public void validWithdrawNoException() {

        when(accountComponent.getBalance()).thenReturn(1000);

        assertDoesNotThrow(() -> atmService.withdraw(500));

        verify(accountComponent).withdraw(500);
    }

    @Test
    @DisplayName("Get balance should return correct value")
    public void getBalanceReturnsCorrectValue() {

        when(accountComponent.getBalance()).thenReturn(0);

        int balance = atmService.getBalance();

        assertEquals(0, balance);
    }
}
