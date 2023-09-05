package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreviousRate {

	private CurrencyMEMS baseCurrency;
	private CurrencyMEMS targetCurrency;
	private List<Double> historicalRates;
	private List<Date> historicalDates;

	public PreviousRate(CurrencyMEMS baseCurrency, CurrencyMEMS targetCurrency) {
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.historicalRates = new ArrayList<>();
		this.historicalDates = new ArrayList<>();
	}

	public PreviousRate(String baseCurrencyCode, String baseCurrencyName, String targetCurrencyCode,
			String targetCurrencyName) {
		this.baseCurrency = new CurrencyMEMS(baseCurrencyCode, baseCurrencyName);
		this.targetCurrency = new CurrencyMEMS(targetCurrencyCode, targetCurrencyCode);
		this.historicalRates = new ArrayList<>();
		this.historicalDates = new ArrayList<>();
	}

	public CurrencyMEMS getBaseCurrency() {
		return baseCurrency;
	}

	public CurrencyMEMS getTargetCurrency() {
		return targetCurrency;
	}

	public List<Double> getHistoricalRates() {
		return historicalRates;
	}

	public List<Date> getHistoricalDates() {
		return historicalDates;
	}

}
