package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Amenity {

    @SerializedName("description")
    private String description = null;

    @SerializedName("isChargeable")
    private Boolean isChargeable = null;

    @SerializedName("amenityType")
    private String amenityType = null;


}
