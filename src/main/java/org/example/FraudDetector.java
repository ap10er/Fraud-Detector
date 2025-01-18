package org.example;

import java.util.Objects;

class FraudDetector {

    boolean isFraud(Transaction transaction, Trader trader) {
        return checkPokemonName(trader)
                || checkOneMillionAmount(transaction)
                || checkTraderName(trader)
                || checkCountry(trader)
                || checkCountryAndAmount(transaction, trader);
    }

    public boolean checkPokemonName(Trader trader) {
        return trader.getFullName().equals("Pokemon");
    }

    public boolean checkOneMillionAmount(Transaction transaction) {
        return transaction.getAmount() > 1000000;
    }

    public boolean checkTraderName(Trader trader) {
        return trader.getFullName().equals("Synney");
    }

    public boolean checkCountry(Trader trader) {
        return trader.getCountry().equals("Jamaica");
    }

    public boolean checkCountryAndAmount(Transaction transaction, Trader trader) {
        return trader.getCountry().equals("Germany") && transaction.getAmount() > 1000;
    }
}

