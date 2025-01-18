package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FraudDetectorTest {

    private final FraudDetector fraudDetector = new FraudDetector();

    @Test
    public void shouldConfirmFraud() {
        Trader trader = new Trader("Pokemon", "Minsk", "Belarus");
        Transaction transaction = new Transaction(trader, 2);
        assertTrue(fraudDetector.isFraud(transaction, trader));
    }

    @Test
    public void shouldNotBeFraud() {
        Trader trader = new Trader("Dmitry", "London", "Great Britain");
        Transaction transaction = new Transaction(trader, 200);
        assertFalse(fraudDetector.isFraud(transaction, trader));
    }

    @Test
    public void shouldCheckAmountMore1Million() {
        Trader trader = new Trader("Algerd", "Minsk", "Belarus");
        Transaction transaction = new Transaction(trader, 1000001);
        assertTrue(fraudDetector.isFraud(transaction, trader));
    }

    @Test
    public void shouldFailedAllFromSynney() {
        Trader trader = new Trader("Synney", "Synney", "FairyTale");
        Transaction transaction = new Transaction(trader, 34565);
        assertTrue(fraudDetector.isFraud(transaction, trader));
    }

    @Test
    public void shouldDeclineByCountry(){
        Trader trader = new Trader("Kesha", "qweasd", "Jamaica");
        Transaction transaction = new Transaction(trader, 34565);
        assertTrue(fraudDetector.isFraud(transaction, trader));
    }

    @Test
    public void shouldCheckCountryAndAmount() {
        Trader trader = new Trader("Konstantin", "Doichland", "Germany");
        Transaction transaction = new Transaction(trader, 100012);
        assertTrue(fraudDetector.isFraud(transaction, trader));

    }

}
