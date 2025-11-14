package com.likelion.assignment14.culture.client;

import com.likelion.assignment14.culture.api.dto.response.CultureListApiResponse;
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
public class CultureApiClient {

    private final RestTemplate restTemplate;

    @Value("${culture.api.base-url}")
    private String baseUrl;     // API 시작 주소

    @Value("${culture.api.auth-key}")
    private String authKey;     // 공공데이터 포털에서 발급받은 인증키

    // 디버깅용, API를 호출하고 응답을 문자열 그대로 반환하는 메서드
    public String getCultureEventsAsString(int pageNo, int numOfRows) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);

        // String.format을 사용해 API 요청 URL을 동적으로 조립
        String url = String.format("%s/period2?serviceKey=%s&PageNo=%d&numOfrows=%d", baseUrl, encodedKey, pageNo, numOfRows);

        try {
            /*
            1. new URI(url) : 조립된 URL로 URI 객체를 생성
            2. restTemplate.getForObject: GET 요청
            3. 응답(XML)을 string 객체로 받기
            */
            return restTemplate.getForObject(new URI(url), String.class);
        } catch (Exception e) {
            // API 호출 중 예외(URI 문법 오류, 네트워크 오류 등)가 발생하면 로그를 남깁니다.
            log.error("Culture API 호출 실패 (String)", e);
            // 미리 정의해둔 global.exception.GeneralException으로 변환하여 예외를 던집니다.
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }

    // API를 호출하고 응답(XML)을 'CultureListApiResponse' Dto 객체로 자동 파싱하여 반환하는 메서드
    public CultureListApiResponse getCultureEvents(int pageNo, int numOfRows) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);

        // String.format을 사용해 API 요청 URL을 동적으로 조립
        String url = String.format("%s/period2?serviceKey=%s&PageNo=%d&numOfrows=%d", baseUrl, encodedKey, pageNo, numOfRows);

        try {
            /*
            1. new URI(url) : 조립된 URL로 URI 객체를 생성
            2. restTemplate.getForObject: GET 요청
            3. 응답(XML)을 JAXB가 자동으로 CultureListApiResponse.class 객체로 변환 후 받기
            */
            return restTemplate.getForObject(new URI(url), CultureListApiResponse.class);
        } catch (Exception e) {
            // API 호출 중 예외(URI 문법 오류, 네트워크 오류 등)가 발생하면 로그를 남깁니다.
            log.error("Culture API 호출 실패 (String)", e);
            // 미리 정의해둔 global.exception.GeneralException으로 변환하여 예외를 던집니다.
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }
}
