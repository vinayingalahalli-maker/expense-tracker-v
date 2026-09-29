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
public class ListExpensesParameters {

  /**
   * Filter by status: unclaimed | claimed
   */
  @JsonProperty("status")
  private JsonNullable<String> status;

  /**
   * Filter by category ID
   */
  @JsonProperty("category_id")
  private JsonNullable<String> categoryId;

  /**
   * Filter expenses on or after this date (ISO 8601: YYYY-MM-DD)
   */
  @JsonProperty("from_date")
  private JsonNullable<String> fromDate;

  /**
   * Filter expenses on or before this date (ISO 8601: YYYY-MM-DD)
   */
  @JsonProperty("to_date")
  private JsonNullable<String> toDate;

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
  public String getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public String getCategoryId() {
    return categoryId.orElse(null);
  }

  @JsonIgnore
  public String getFromDate() {
    return fromDate.orElse(null);
  }

  @JsonIgnore
  public String getToDate() {
    return toDate.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListExpensesParametersBuilder {

    private JsonNullable<String> status = JsonNullable.undefined();

    @JsonProperty("status")
    public ListExpensesParametersBuilder status(String value) {
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> categoryId = JsonNullable.undefined();

    @JsonProperty("category_id")
    public ListExpensesParametersBuilder categoryId(String value) {
      this.categoryId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> fromDate = JsonNullable.undefined();

    @JsonProperty("from_date")
    public ListExpensesParametersBuilder fromDate(String value) {
      this.fromDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> toDate = JsonNullable.undefined();

    @JsonProperty("to_date")
    public ListExpensesParametersBuilder toDate(String value) {
      this.toDate = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public ListExpensesParametersBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
