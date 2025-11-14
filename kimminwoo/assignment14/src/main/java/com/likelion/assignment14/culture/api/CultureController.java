package com.likelion.assignment14.culture.api;

import com.likelion.assignment14.culture.api.dto.response.CultureListApiResponse;
import com.likelion.assignment14.culture.application.CultureService;
import com.likelion.assignment14.global.code.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 문화행사 관련 API
@RestController
@RequestMapping("/api/cultures")
@RequiredArgsConstructor
public class CultureController {

    private final CultureService cultureService;

    @GetMapping("/raw")
    public ResponseEntity<String> getCultureRaw(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "1") int size) {

        String response = cultureService.getCultureEventsRaw(page, size);
        return ResponseEntity.ok(response);
    }

    // 문화행사 목록 API 직접 조회
    @GetMapping("/from-api")
    public ResponseEntity<ApiResponse<CultureListApiResponse>> getCultureFromApi(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "1") int size) {

        CultureListApiResponse response = cultureService.getCultureEventsFromApi(page, size);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}
