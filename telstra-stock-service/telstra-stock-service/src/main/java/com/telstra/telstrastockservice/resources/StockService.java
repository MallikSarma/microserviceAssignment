package com.telstra.telstrastockservice.resources;

import com.telstra.telstrastockservice.model.StockDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/stock")
public class StockService {

    @GetMapping(value = "/{stockCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StockDetails getStockDetails(@PathVariable("stockCode")  String stockCode)  {
        Stock stock = null;
    try {
       stock =  YahooFinance.get(stockCode);

    }catch (Exception e){
        e.printStackTrace();
    }
        return new StockDetails(stock.getName(),stock.getQuote().getPrice(), stock.getQuote().getChange()
                , stock.getCurrency(), stock.getQuote().getBid());
        // return "stock"+stockCode;
    }
   /* public StockDetails getStocksDetails(String stockCode) throws IOException {

        Stock stock =  YahooFinance.get(stockCode);
       return new StockDetails(stock.getName(),stock.getQuote().getPrice(), stock.getQuote().getChange()
        , stock.getCurrency(), stock.getQuote().getBid());
        // return "stock"+stockCode;
    }
    public static void main(String[] args) throws IOException{
        StockService f = new StockService();
        System.out.println(f.getStocksDetails("TLS"));
    }*/
}
