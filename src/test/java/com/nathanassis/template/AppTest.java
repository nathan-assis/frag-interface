package com.nathanassis.template;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AppTest {
  @Test
  public void shouldCreateAppInstance() {
    App appTest = new App();
    assertNotNull(appTest);
  }
}
