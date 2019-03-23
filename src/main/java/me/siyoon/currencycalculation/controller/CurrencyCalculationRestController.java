package me.siyoon.currencycalculation.controller;

import lombok.RequiredArgsConstructor;
import me.siyoon.currencycalculation.service.CurrencyCalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyCalculationRestController {
    private final CurrencyCalculationService currencyCalculationService;

    @GetMapping("/exchange-rate")
    public ResponseEntity getExchangeRate(@RequestParam String sendingCountry, @RequestParam String receivingCountry) {
        Double exchangeRate = currencyCalculationService.getExchangeRate(sendingCountry, receivingCountry);
        return ResponseEntity.ok(exchangeRate);
    }

}
