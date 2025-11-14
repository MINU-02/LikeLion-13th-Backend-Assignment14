package com.likelion.assignment14.weather.api;

import com.likelion.assignment14.global.code.dto.ApiResponse;
import com.likelion.assignment14.weather.api.dto.response.WeatherListApiResponse;
import com.likelion.assignment14.weather.application.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/raw")
    public ResponseEntity<String> getWeatherRaw(
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam int nx,
            @RequestParam int ny) {

        String response = weatherService.getWeatherForecastRaw(date, time, nx, ny);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/from-api")
    public ResponseEntity<ApiResponse<WeatherListApiResponse>> getWeatherFromApi(
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam int nx,
            @RequestParam int ny) {

        WeatherListApiResponse response = weatherService.getWeatherForecastFromApi(date, time, nx, ny);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}
