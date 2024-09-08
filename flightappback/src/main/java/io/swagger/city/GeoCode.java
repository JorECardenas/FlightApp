/*
 * Airport & City Search
 *  Before using this API, we recommend you read our **[Authorization Guide](https://developers.amadeus.com/self-service/apis-docs/guides/authorization-262)** for more information on how to generate an access token.   Please also be aware that our test environment is based on a subset of the production, in test this API only contains data from the United States, Spain, United Kingdom, Germany and India. 
 *
 * OpenAPI spec version: 1.2.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.city;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * GeoCode
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-09-07T23:25:36.596623-07:00[America/Hermosillo]")

public class GeoCode {
  @SerializedName("latitude")
  private Double latitude = null;

  @SerializedName("longitude")
  private Double longitude = null;

  public GeoCode latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

   /**
   * latitude of the location
   * @return latitude
  **/
  @Schema(example = "43.580418", description = "latitude of the location")
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public GeoCode longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

   /**
   * longitude of the location
   * @return longitude
  **/
  @Schema(example = "7.125102", description = "longitude of the location")
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoCode geoCode = (GeoCode) o;
    return Objects.equals(this.latitude, geoCode.latitude) &&
        Objects.equals(this.longitude, geoCode.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoCode {\n");
    
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
