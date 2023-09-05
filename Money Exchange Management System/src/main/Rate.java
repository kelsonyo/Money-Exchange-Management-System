package main;

public class Rate {

	private CurrencyMEMS baseCurrency;
	private CurrencyMEMS targetCurrency;
	private double exchangeRate;

	public Rate(CurrencyMEMS baseCurrency, CurrencyMEMS targetCurrency, double exchangeRate) {
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.exchangeRate = exchangeRate;
	}

	public Rate(String baseCurrencyCode, String baseCurrencyName, String targetCurrencyCode, String targetCurrencyName,
			double exchangeRate) {
		this.baseCurrency = new CurrencyMEMS(baseCurrencyCode, baseCurrencyName);
		this.targetCurrency = new CurrencyMEMS(targetCurrencyCode, targetCurrencyCode);
		this.exchangeRate = exchangeRate;
	}

	public CurrencyMEMS getBaseCurrency() {
		return baseCurrency;
	}

	public CurrencyMEMS getTargetCurrency() {
		return targetCurrency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setBaseCurrency(CurrencyMEMS baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public void setTargetCurrency(CurrencyMEMS targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

}
