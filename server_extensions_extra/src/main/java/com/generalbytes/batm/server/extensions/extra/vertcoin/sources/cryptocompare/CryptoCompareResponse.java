package com.generalbytes.batm.server.extensions.extra.vertcoin.sources.cryptocompare;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by gertjaap on 02/27/18.
 */

public class CryptoCompareResponse {
    @JsonProperty("USD")
    private BigDecimal usd;

    @JsonProperty("EUR")
    private BigDecimal eur;


    public BigDecimal getUSD() {
        return usd;
    }

    public void setUSD(BigDecimal usd) {
        this.usd = usd;
    }

     public BigDecimal getEUR() {
        return eur;
    }

    public void setEUR(BigDecimal eur) {
        this.eur = eur;
    }

    public BigDecimal getRate(string symbol) {
        switch(symbol) {
            case "EUR":
                return eur;
            case "USD":
                return usd;
            default:
                return null;
        }
    }
}
