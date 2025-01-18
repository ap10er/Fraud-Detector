package org.example;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class FraudRuleCountryAndAmountTest {
    FraudRuleCountryAndAmount fraudRuleCountryAndAmount = new FraudRuleCountryAndAmount();

    @Test
    public void shouldBeFraud() {
        Trader trader = new Trader("Zorro", "Berlin", "Germany");
        Transaction transaction = new Transaction(trader, 1001);
        assertTrue(fraudRuleCountryAndAmount.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud_1000() {
        Trader trader = new Trader("Zorro", "Berlin", "Germany");
        Transaction transaction = new Transaction(trader, 1000);
        assertFalse(fraudRuleCountryAndAmount.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud_LessThan_1000() {
        Trader trader = new Trader("Zorro", "Berlin", "Germany");
        Transaction transaction = new Transaction(trader, 10);
        assertFalse(fraudRuleCountryAndAmount.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud_OtherCountry() {
        Trader trader = new Trader("Zorro", "Berlin", "Italy");
        Transaction transaction = new Transaction(trader, 1001);
        assertFalse(fraudRuleCountryAndAmount.isFraud(transaction));
    }
}
