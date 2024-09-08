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
import io.swagger.city.Address;
import io.swagger.city.Analytics;
import io.swagger.city.Distance;
import io.swagger.city.GeoCode;
import io.swagger.city.Links;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Location
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-09-07T23:25:36.596623-07:00[America/Hermosillo]")

public class Location {
  @SerializedName("id")
  private String id = null;

  @SerializedName("self")
  private Links self = null;

  @SerializedName("type")
  private String type = null;

  /**
   * location sub type
   */
  @JsonAdapter(SubTypeEnum.Adapter.class)
  public enum SubTypeEnum {
    @SerializedName("AIRPORT")
    AIRPORT("AIRPORT"),
    @SerializedName("CITY")
    CITY("CITY"),
    @SerializedName("POINT_OF_INTEREST")
    POINT_OF_INTEREST("POINT_OF_INTEREST"),
    @SerializedName("DISTRICT")
    DISTRICT("DISTRICT");

    private String value;

    SubTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static SubTypeEnum fromValue(String input) {
      for (SubTypeEnum b : SubTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<SubTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SubTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public SubTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return SubTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("subType")
  private SubTypeEnum subType = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("detailedName")
  private String detailedName = null;

  @SerializedName("timeZoneOffset")
  private String timeZoneOffset = null;

  @SerializedName("iataCode")
  private String iataCode = null;

  @SerializedName("geoCode")
  private GeoCode geoCode = null;

  @SerializedName("address")
  private Address address = null;

  @SerializedName("distance")
  private Distance distance = null;

  @SerializedName("analytics")
  private Analytics analytics = null;

  @SerializedName("relevance")
  private Double relevance = null;

  /**
   * category of the location
   */
  @JsonAdapter(CategoryEnum.Adapter.class)
  public enum CategoryEnum {
    @SerializedName("SIGHTS")
    SIGHTS("SIGHTS"),
    @SerializedName("BEACH_PARK")
    BEACH_PARK("BEACH_PARK"),
    @SerializedName("HISTORICAL")
    HISTORICAL("HISTORICAL"),
    @SerializedName("NIGHTLIFE")
    NIGHTLIFE("NIGHTLIFE"),
    @SerializedName("RESTAURANT")
    RESTAURANT("RESTAURANT"),
    @SerializedName("SHOPPING")
    SHOPPING("SHOPPING");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static CategoryEnum fromValue(String input) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<CategoryEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CategoryEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public CategoryEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return CategoryEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("category")
  private CategoryEnum category = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("rank")
  private String rank = null;

  public Location id(String id) {
    this.id = id;
    return this;
  }

   /**
   * id of the ressource
   * @return id
  **/
  @Schema(description = "id of the ressource")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Location self(Links self) {
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @Schema(description = "")
  public Links getSelf() {
    return self;
  }

  public void setSelf(Links self) {
    this.self = self;
  }

  public Location type(String type) {
    this.type = type;
    return this;
  }

   /**
   * the resource name
   * @return type
  **/
  @Schema(example = "location", description = "the resource name")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Location subType(SubTypeEnum subType) {
    this.subType = subType;
    return this;
  }

   /**
   * location sub type
   * @return subType
  **/
  @Schema(example = "AIRPORT", description = "location sub type")
  public SubTypeEnum getSubType() {
    return subType;
  }

  public void setSubType(SubTypeEnum subType) {
    this.subType = subType;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

   /**
   * short name of the location
   * @return name
  **/
  @Schema(example = "Paris CDG", description = "short name of the location")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location detailedName(String detailedName) {
    this.detailedName = detailedName;
    return this;
  }

   /**
   * detailed name of the location. For a city location it contains city name and country code. For an airport location it contains city name; country code and airport full name
   * @return detailedName
  **/
  @Schema(example = "Paris/FR: Charles de Gaulle", description = "detailed name of the location. For a city location it contains city name and country code. For an airport location it contains city name; country code and airport full name")
  public String getDetailedName() {
    return detailedName;
  }

  public void setDetailedName(String detailedName) {
    this.detailedName = detailedName;
  }

  public Location timeZoneOffset(String timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
    return this;
  }

   /**
   * timezone offset of the location at the date of the API call (including daylight saving time)
   * @return timeZoneOffset
  **/
  @Schema(example = "+01:00", description = "timezone offset of the location at the date of the API call (including daylight saving time)")
  public String getTimeZoneOffset() {
    return timeZoneOffset;
  }

  public void setTimeZoneOffset(String timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
  }

  public Location iataCode(String iataCode) {
    this.iataCode = iataCode;
    return this;
  }

   /**
   * IATA code of the location. ([IATA table codes](http://www.iata.org/publications/Pages/code-search.aspx) here)
   * @return iataCode
  **/
  @Schema(example = "CDG", description = "IATA code of the location. ([IATA table codes](http://www.iata.org/publications/Pages/code-search.aspx) here)")
  public String getIataCode() {
    return iataCode;
  }

  public void setIataCode(String iataCode) {
    this.iataCode = iataCode;
  }

  public Location geoCode(GeoCode geoCode) {
    this.geoCode = geoCode;
    return this;
  }

   /**
   * Get geoCode
   * @return geoCode
  **/
  @Schema(description = "")
  public GeoCode getGeoCode() {
    return geoCode;
  }

  public void setGeoCode(GeoCode geoCode) {
    this.geoCode = geoCode;
  }

  public Location address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @Schema(description = "")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Location distance(Distance distance) {
    this.distance = distance;
    return this;
  }

   /**
   * Get distance
   * @return distance
  **/
  @Schema(description = "")
  public Distance getDistance() {
    return distance;
  }

  public void setDistance(Distance distance) {
    this.distance = distance;
  }

  public Location analytics(Analytics analytics) {
    this.analytics = analytics;
    return this;
  }

   /**
   * Get analytics
   * @return analytics
  **/
  @Schema(description = "")
  public Analytics getAnalytics() {
    return analytics;
  }

  public void setAnalytics(Analytics analytics) {
    this.analytics = analytics;
  }

  public Location relevance(Double relevance) {
    this.relevance = relevance;
    return this;
  }

   /**
   * score value calculated based on distance and analytics
   * @return relevance
  **/
  @Schema(example = "9.6584", description = "score value calculated based on distance and analytics")
  public Double getRelevance() {
    return relevance;
  }

  public void setRelevance(Double relevance) {
    this.relevance = relevance;
  }

  public Location category(CategoryEnum category) {
    this.category = category;
    return this;
  }

   /**
   * category of the location
   * @return category
  **/
  @Schema(example = "HISTORICAL", description = "category of the location")
  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public Location tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Location addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * list of tags related to the location
   * @return tags
  **/
  @Schema(description = "list of tags related to the location")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Location rank(String rank) {
    this.rank = rank;
    return this;
  }

   /**
   * the rank is the position compared to other locations based on how famous is a place. 1 being the highest.
   * @return rank
  **/
  @Schema(example = "1", description = "the rank is the position compared to other locations based on how famous is a place. 1 being the highest.")
  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.id, location.id) &&
        Objects.equals(this.self, location.self) &&
        Objects.equals(this.type, location.type) &&
        Objects.equals(this.subType, location.subType) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.detailedName, location.detailedName) &&
        Objects.equals(this.timeZoneOffset, location.timeZoneOffset) &&
        Objects.equals(this.iataCode, location.iataCode) &&
        Objects.equals(this.geoCode, location.geoCode) &&
        Objects.equals(this.address, location.address) &&
        Objects.equals(this.distance, location.distance) &&
        Objects.equals(this.analytics, location.analytics) &&
        Objects.equals(this.relevance, location.relevance) &&
        Objects.equals(this.category, location.category) &&
        Objects.equals(this.tags, location.tags) &&
        Objects.equals(this.rank, location.rank);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, self, type, subType, name, detailedName, timeZoneOffset, iataCode, geoCode, address, distance, analytics, relevance, category, tags, rank);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    detailedName: ").append(toIndentedString(detailedName)).append("\n");
    sb.append("    timeZoneOffset: ").append(toIndentedString(timeZoneOffset)).append("\n");
    sb.append("    iataCode: ").append(toIndentedString(iataCode)).append("\n");
    sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    analytics: ").append(toIndentedString(analytics)).append("\n");
    sb.append("    relevance: ").append(toIndentedString(relevance)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
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