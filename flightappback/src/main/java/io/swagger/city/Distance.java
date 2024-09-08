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
 * Distance
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-09-07T23:25:36.596623-07:00[America/Hermosillo]")

public class Distance {
  @SerializedName("value")
  private Integer value = null;

  /**
   * unit of the distance
   */
  @JsonAdapter(UnitEnum.Adapter.class)
  public enum UnitEnum {
    @SerializedName("KM")
    KM("KM"),
    @SerializedName("MI")
    MI("MI");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static UnitEnum fromValue(String input) {
      for (UnitEnum b : UnitEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<UnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UnitEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public UnitEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return UnitEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("unit")
  private UnitEnum unit = null;

  public Distance value(Integer value) {
    this.value = value;
    return this;
  }

   /**
   * great-circle distance between two locations. This distance thus do not take into account traffic conditions; international boundaries; mountains; water; or other elements that might make the a nearby location hard to reach.
   * @return value
  **/
  @Schema(example = "152", description = "great-circle distance between two locations. This distance thus do not take into account traffic conditions; international boundaries; mountains; water; or other elements that might make the a nearby location hard to reach.")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Distance unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

   /**
   * unit of the distance
   * @return unit
  **/
  @Schema(example = "KM", description = "unit of the distance")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Distance distance = (Distance) o;
    return Objects.equals(this.value, distance.value) &&
        Objects.equals(this.unit, distance.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Distance {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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
