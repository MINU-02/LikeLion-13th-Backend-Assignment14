package com.likelion.assignment14.weather.application;

import com.likelion.assignment14.weather.api.dto.response.WeatherListApiResponse;
import com.likelion.assignment14.weather.client.WeatherApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    public String getWeatherForecastRaw(String date, String time, int nx, int ny) {
        return weatherApiClient.getWeatherForecastAsString(date, time, nx, ny);
    }

    public WeatherListApiResponse getWeatherForecastFromApi(String date, String time, int nx, int ny) {
        return weatherApiClient.getWeatherForecast(date, time, nx, ny);
    }
}
