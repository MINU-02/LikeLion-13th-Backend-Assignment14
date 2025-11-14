package com.likelion.assignment14.air.application;

import com.likelion.assignment14.air.api.dto.response.AirListApiResponse;
import com.likelion.assignment14.air.client.AirApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AirService {

    private final AirApiClient airApiClient;

    public AirListApiResponse getAirQuality(String stationName) {
        return airApiClient.getAirQuality(stationName);
    }
}
