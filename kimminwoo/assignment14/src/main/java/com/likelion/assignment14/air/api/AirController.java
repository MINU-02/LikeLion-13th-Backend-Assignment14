package com.likelion.assignment14.air.api;

import com.likelion.assignment14.air.api.dto.response.AirListApiResponse;
import com.likelion.assignment14.air.application.AirService;
import com.likelion.assignment14.global.code.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/air")
@RequiredArgsConstructor
public class AirController {

    private final AirService airService;

    @GetMapping
    public ResponseEntity<ApiResponse<AirListApiResponse>> getAir(
            @RequestParam String stationName
    ) {
        AirListApiResponse response = airService.getAirQuality(stationName);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}
