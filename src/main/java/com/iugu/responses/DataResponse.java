package com.iugu.responses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse {

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("holder_name")
    private String holderName;

    @JsonProperty("display_number")
    private String displayNumber;

    @JsonProperty("month")
    private Integer month;

    @JsonProperty("year")
    private Integer year;

    public String getBrand() {
        return brand;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Data{" +
                "brand=" + brand +
                ", holderName=" + holderName +
                ", displayNumber=" + displayNumber +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
