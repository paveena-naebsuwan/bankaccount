package se.iths.paveena.labb2bankomat.component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {

    private int balance = 0;

    public int deposit(int amount) {

        return balance += amount;
    }

    public int withdraw(int amount) {
        return balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
