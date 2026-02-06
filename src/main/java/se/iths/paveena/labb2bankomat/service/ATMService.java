package se.iths.paveena.labb2bankomat.service;

import org.springframework.stereotype.Service;
import se.iths.paveena.labb2bankomat.component.AccountComponent;
import se.iths.paveena.labb2bankomat.exception.InsufficientFundsException;
import se.iths.paveena.labb2bankomat.exception.InvalidAmountException;
import se.iths.paveena.labb2bankomat.exception.MaxWithdrawalExceededException;

@Service
public class ATMService {
    private AccountComponent accountComponent;
    private static final int MAX_WITHDRAWAL = 1000;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }
        accountComponent.deposit(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new MaxWithdrawalExceededException("You have reached the maximum amount");
        }

        int currentBalance = accountComponent.getBalance();

        if (amount > currentBalance ) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        accountComponent.withdraw(amount);
    }

    public int getBalance() {
        return accountComponent.getBalance();
    }
}
