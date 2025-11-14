package com.likelion.assignment14.weather.client;

import com.likelion.assignment14.global.code.status.ErrorStatus;
import com.likelion.assignment14.global.exception.GeneralException;
import com.likelion.assignment14.weather.api.dto.response.WeatherListApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherApiClient {

    private final RestTemplate restTemplate;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    @Value("${weather.api.auth-key}")
    private String authKey;

    public String getWeatherForecastAsString(String date, String time, int nx, int ny) {
        try {
            String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);

            String url = String.format(
                    "%s/getVilageFcst?serviceKey=%s&numOfRows=10&pageNo=1&dataType=XML&base_date=%s&base_time=%s&nx=%d&ny=%d",
                    baseUrl, encodedKey, date, time, nx, ny
            );

            log.info("Weather API 요청 URL (String): {}", url);
            return restTemplate.getForObject(new URI(url), String.class);

        } catch (Exception e) {
            log.error("Weather API 호출 실패 (String)", e);
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }

    public WeatherListApiResponse getWeatherForecast(String date, String time, int nx, int ny) {
        try {
            String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);

            String url = String.format(
                    "%s/getVilageFcst?serviceKey=%s&numOfRows=10&pageNo=1&dataType=XML&base_date=%s&base_time=%s&nx=%d&ny=%d",
                    baseUrl, encodedKey, date, time, nx, ny
            );

            log.info("Weather API 요청 URL (DTO): {}", url);
            return restTemplate.getForObject(new URI(url), WeatherListApiResponse.class);

        } catch (Exception e) {
            log.error("Weather API 호출 실패 (DTO)", e);
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }
}
