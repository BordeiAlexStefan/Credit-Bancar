package currency;

import files.CSVUtils;

public class CurrencyConverter {
    public static Float calculateExchangeRate(Currency oldCurrency, Currency newCurrency) {
        CSVUtils.getInstance().appendToCSV("exchange_rate", Thread.currentThread().getName());
        return oldCurrency.getExchangeRate(newCurrency);
    }
}
