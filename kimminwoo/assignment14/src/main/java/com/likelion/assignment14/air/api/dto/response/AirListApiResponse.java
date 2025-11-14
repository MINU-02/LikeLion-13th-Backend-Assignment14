package com.likelion.assignment14.air.api.dto.response;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
public class AirListApiResponse {

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
        private Integer totalCount;

        @XmlElement(name = "pageNo")
        private Integer pageNo;

        @XmlElement(name = "numOfRows")
        private Integer numOfRows;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Items {
        @XmlElement(name = "item")
        private List<AirItem> item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class AirItem {
        // 측정소명
        private String stationName;

        // 데이터 시간 (YYYY-MM-DD HH)
        private String dataTime;

        // 미세먼지(PM10) 수치
        private String pm10Value;

        // 초미세먼지(PM2.5) 수치
        private String pm25Value;

        // 오존 농도
        private String o3Value;

        // 이산화질소 농도
        private String no2Value;

        // 아황산가스 농도
        private String so2Value;

        // 일산화탄소 농도
        private String coValue;
    }
}
