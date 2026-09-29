package com.expensetrackerapisdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UpdateCategoryRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("description")
  private JsonNullable<String> description;

  @JsonProperty("receipt_threshold")
  private JsonNullable<Double> receiptThreshold;

  @JsonProperty("currency")
  private JsonNullable<String> currency;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public Double getReceiptThreshold() {
    return receiptThreshold.orElse(null);
  }

  @JsonIgnore
  public String getCurrency() {
    return currency.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UpdateCategoryRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public UpdateCategoryRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public UpdateCategoryRequestBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> receiptThreshold = JsonNullable.undefined();

    @JsonProperty("receipt_threshold")
    public UpdateCategoryRequestBuilder receiptThreshold(Double value) {
      this.receiptThreshold = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> currency = JsonNullable.undefined();

    @JsonProperty("currency")
    public UpdateCategoryRequestBuilder currency(String value) {
      this.currency = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public UpdateCategoryRequestBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
