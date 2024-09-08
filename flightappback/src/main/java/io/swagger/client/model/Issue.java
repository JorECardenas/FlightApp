/*
 * Flight Offers Search
 *  Before using this API, we recommend you read our **[Authorization Guide](https://developers.amadeus.com/self-service/apis-docs/guides/authorization)** for more information on how to generate an access token.   Please also be aware that our test environment is based on a subset of the production, if you are not returning any results try with big cities/airports like LON (London) or NYC (New-York).
 *
 * OpenAPI spec version: 2.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.IssueSource;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Issue
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-09-05T13:16:41.117316-07:00[America/Hermosillo]")

public class Issue {
  @SerializedName("code")
  private Long code = null;

  @SerializedName("detail")
  private String detail = null;

  @SerializedName("source")
  private IssueSource source = null;

  @SerializedName("status")
  private Integer status = null;

  @SerializedName("title")
  private String title = null;

  public Issue code(Long code) {
    this.code = code;
    return this;
  }

   /**
   * an application-specific error code
   * @return code
  **/
  @Schema(description = "an application-specific error code")
  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public Issue detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * explanation of the error
   * @return detail
  **/
  @Schema(description = "explanation of the error")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Issue source(IssueSource source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @Schema(description = "")
  public IssueSource getSource() {
    return source;
  }

  public void setSource(IssueSource source) {
    this.source = source;
  }

  public Issue status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * the HTTP status code applicable to this error
   * @return status
  **/
  @Schema(description = "the HTTP status code applicable to this error")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Issue title(String title) {
    this.title = title;
    return this;
  }

   /**
   * a short summary of the error
   * @return title
  **/
  @Schema(description = "a short summary of the error")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Issue issue = (Issue) o;
    return Objects.equals(this.code, issue.code) &&
        Objects.equals(this.detail, issue.detail) &&
        Objects.equals(this.source, issue.source) &&
        Objects.equals(this.status, issue.status) &&
        Objects.equals(this.title, issue.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, detail, source, status, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Issue {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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