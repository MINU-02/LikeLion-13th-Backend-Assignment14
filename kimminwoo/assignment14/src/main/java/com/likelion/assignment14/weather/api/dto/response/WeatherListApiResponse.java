package com.likelion.assignment14.weather.api.dto.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
public class WeatherListApiResponse {

    private Header header;
    private Body body;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Body {
        private Items items;
        private int pageNo;
        private int numOfRows;
        private int totalCount;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Items {
        @XmlElement(name = "item")
        private List<WeatherItem> item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class WeatherItem {
        private String baseDate;   // 발표일자
        private String baseTime;   // 발표시각
        private String category;   // 항목명 (TMP, SKY, POP 등)
        private String fcstDate;   // 예보일자
        private String fcstTime;   // 예보시각
        private String fcstValue;  // 예보값
        private String nx;         // 예보지점 X좌표
        private String ny;         // 예보지점 Y좌표
    }
}
