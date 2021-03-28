package com.telstra.telstrahomePageservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class HomePageDetails {

    private StockDetails stockDetails;
    private WeatherSummary weatherSummary;
}
