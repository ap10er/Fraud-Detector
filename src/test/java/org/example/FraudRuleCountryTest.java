package org.example;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class FraudRuleCountryTest
{
    FraudRuleCountry fraudRuleCountry = new FraudRuleCountry();

    @Test
    public void shouldBeFraud() {
        Trader trader = new Trader("Zorro", "Kingston", "Jamaica");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudRuleCountry.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud() {
        Trader trader = new Trader("Zorro", "Kingston", "Italy");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudRuleCountry.isFraud(transaction));
    }
}
