package com.generalbytes.batm.server.extensions.extra.vertcoin.sources.cryptocompare;

import com.generalbytes.batm.server.extensions.ICurrencies;
import com.generalbytes.batm.server.extensions.IRateSource;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import si.mazi.rescu.RestProxyFactory;

/**
 * Created by gertjaap on 02/27/18
 */

public class CryptoCompareRateSource implements IRateSource {
    private ICryptoCompareAPI api;

    public CryptoCompareRateSource() {
        api = RestProxyFactory.createProxy(ICryptoCompareAPI.class, "https://min-api.cryptocompare.com");
    }

    @Override
    public Set<String> getCryptoCurrencies() {
        Set<String> result = new HashSet<String>();
        result.add(ICurrencies.VTC);
        return result;
    }

    @Override
    public Set<String> getFiatCurrencies() {
        Set<String> result = new HashSet<String>();
        result.add(ICurrencies.USD);
        result.add(ICurrencies.EUR);
        return result;
    }


    @Override
    public String getPreferredFiatCurrency() {
        return ICurrencies.USD;
    }


    @Override
    public BigDecimal getExchangeRateLast(String cryptoCurrency, String fiatCurrency) {
        if (!getFiatCurrencies().contains(fiatCurrency)) {
            return null;
        }
        CryptoCompareResult result = api.getPrice("VTC",String.Join(getFiatCurrencies(),","));
        return result.getRate(fiatCurrency);
    }
}
