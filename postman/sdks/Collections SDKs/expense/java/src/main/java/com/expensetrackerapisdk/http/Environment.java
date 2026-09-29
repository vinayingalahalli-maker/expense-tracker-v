package com.expensetrackerapisdk.http;

import lombok.Getter;

/**
 * Predefined environment configurations for the SDK.
 * Each environment represents a different base URL (e.g., production, staging, development).
 */
@Getter
public enum Environment {
  DEFAULT("http://localhost:8000"),
  LOCALHOST8000("http://localhost:8000");

  private final String url;

  Environment(String url) {
    this.url = url;
  }
}
