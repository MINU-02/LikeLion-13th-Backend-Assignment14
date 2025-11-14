package com.likelion.assignment14.culture.api.dto.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// 문화행사 리스트 API 응답
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
public class CultureListApiResponse {

    // 응답 헤더
    private Header header;

    // 응답 본문
    private Body body;

    // 응답 헤더 정보
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Header {
        // 결과 코드
        private String resultCode;

        // 결과 메시지
        private String resultMsg;
    }

    // 응답 본문 데이터
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Body {
        // 전체 건수
        private Integer totalCount;

        // 페이지 번호
        @XmlElement(name = "PageNo")
        private Integer pageNo;

        // 페이지당 행 수
        @XmlElement(name = "numOfrows")
        private Integer numOfRows;

        // 문화행사 목록
        private Items items;
    }

    // 문화행사 아이템 목록
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Items {
        // 문화행사 배열
        @XmlElement(name = "item")
        private List<CultureListItem> item;
    }

    // 문화행사 리스트 정보
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class CultureListItem {
        // 서비스 분류
        private String serviceName;

        // 문화행사 고유번호
        private String seq;

        // 문화행사 제목
        private String title;

        // 시작일 (yyyyMMdd)
        private String startDate;

        // 종료일 (yyyyMMdd)
        private String endDate;

        // 장소명
        private String place;

        // 분야명
        private String realmName;

        // 지역
        private String area;

        // 시군구
        private String sigungu;

        // 썸네일 이미지
        private String thumbnail;

        // 경도
        private String gpsX;

        // 위도
        private String gpsY;
    }
}