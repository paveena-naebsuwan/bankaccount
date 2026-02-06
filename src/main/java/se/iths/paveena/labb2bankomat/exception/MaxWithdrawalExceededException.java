package se.iths.paveena.labb2bankomat.exception;

public class MaxWithdrawalExceededException extends RuntimeException {
    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
