package com.likelion.assignment14.culture.application;

import com.likelion.assignment14.culture.api.dto.response.CultureListApiResponse;
import com.likelion.assignment14.culture.client.CultureApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CultureService {
    private final CultureApiClient cultureApiClient;

    public String getCultureEventsRaw(int page, int size) {
        return cultureApiClient.getCultureEventsAsString(page, size);
    }

    public CultureListApiResponse getCultureEventsFromApi(int page, int size) {
        return cultureApiClient.getCultureEvents(page, size);
    }
}
