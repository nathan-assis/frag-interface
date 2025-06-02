package com.nathanassis.frag.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nathanassis.frag.JavaFXTestBase;
import com.nathanassis.frag.core.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerFactoryTest extends JavaFXTestBase {
  @Test
  @DisplayName("getInstance should return Controller")
  void getInstance_ValidFxml_ReturnsController() {
    String fxml = "Chat";
    Controller result = ControllerFactory.getInstance(fxml);

    assertNotNull(result, "Controller shouldn't be null");
    assertTrue(
        result instanceof ChatController, "Controller should be an instance of ChatController");
  }

  @Test
  @DisplayName("getInstance should return same Controller instance")
  void getInstance_ValidFxml_ReturnsExistingController() {
    String fxml = "Chat";
    Controller first = ControllerFactory.getInstance(fxml);
    Controller second = ControllerFactory.getInstance(fxml);

    assertSame(first, second, "Should return the same instance across multiple calls");
  }

  @Test
  @DisplayName("getInstance should throw IllegalArgumentException")
  void stringToUrl_InvalidPath_IllegalArgumentException() {
    String fxml = "Invalid";
    assertThrows(
        IllegalArgumentException.class,
        () -> ControllerFactory.getInstance(fxml),
        "Should throw IllegalArgumentException for controller not found");
  }
}
