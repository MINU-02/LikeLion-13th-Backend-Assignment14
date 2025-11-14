package com.likelion.assignment14.air.client;

import com.likelion.assignment14.air.api.dto.response.AirListApiResponse;
import com.likelion.assignment14.global.code.status.ErrorStatus;
import com.likelion.assignment14.global.exception.GeneralException;
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
public class AirApiClient {

    private final RestTemplate restTemplate;

    @Value("${air.api.base-url}")
    private String baseUrl;

    @Value("${air.api.auth-key}")
    private String authKey;

    public AirListApiResponse getAirQuality(String stationName) {
        try {
            String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);
            String encodedStation = URLEncoder.encode(stationName, StandardCharsets.UTF_8);

            String url = String.format(
                    "%s/getMsrstnAcctoRltmMesureDnsty?serviceKey=%s&returnType=XML&numOfRows=10&pageNo=1&stationName=%s&dataTerm=DAILY&ver=1.0",
                    baseUrl, encodedKey, encodedStation
            );

            log.info("Air API 요청 URL: {}", url);

            AirListApiResponse response = restTemplate.getForObject(new URI(url), AirListApiResponse.class);

            if (response == null) {
                throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
            }

            return response;

        } catch (Exception e) {
            log.error("Air API 호출 실패", e);
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }
}
