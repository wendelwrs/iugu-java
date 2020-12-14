package com.iugu.responses;

import com.iugu.enums.ItemType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("item_type")
    private ItemType itemType;

    @JsonProperty("data")
    private DataResponse data;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public DataResponse getData() {
        return data;
    }

}
