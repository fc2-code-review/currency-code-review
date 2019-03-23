package me.siyoon.currencycalculation.service;

import me.siyoon.currencycalculation.dto.CurrencyInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyCalculationServiceTest {
    @Autowired
    private CurrencyCalculationService currencyCalculationService;
    @Autowired
    private CurrencyInfoAPIService currencyInfoAPIService;

    @Test
    public void 송금국가_수취국가_통화를_입력하고_환율가져오기() {
        Double exchangeRate = currencyCalculationService.getExchangeRate("USD", "KRW");
        CurrencyInfo currencyInfo = currencyInfoAPIService.getCurrencyInfo();
        Assert.assertEquals(currencyInfo.getQuotes().get("USDKRW"), exchangeRate);
    }
}
