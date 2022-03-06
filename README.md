# SpringCurrency
Simple web service on SpringBoot using Kotlin that receive a currency rate from NBP API.

The servise has endpoints that return JSON:
- *GET /api/exchange-rates/**{code}*** to get currency exchange rate PLN to **{code}** for the last 5 business days.
- *GET /api/gold-price/average* to get an average gold price for the last 14 business days.
