package com.nathanassis.frag.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {

  @Test
  @DisplayName("fromFile should return View")
  void fromFile_ValidFile_ReturnsView() {
    String file = "Chat";
    View result = View.fromFile(file);

    assertNotNull(result, "View shouldn't be null");
    assertEquals(result, View.CHAT);
  }

  @Test
  @DisplayName("fromFile should throw IllegalArgumentException")
  void fromFile_InvalidFile_IllegalArgumentException() {
    String file = "Invalid";

    assertThrows(
        IllegalArgumentException.class,
        () -> View.fromFile(file),
        "Should throw IllegalArgumentException for FXML not found");
  }

  @Test
  @DisplayName("fullPath should return String")
  void fullPath_ReturnsString() {
    View view = View.CHAT;
    String result = view.fullPath();
    String expected = "/com/nathanassis/frag/fxml/Chat.fxml";

    assertEquals(result, expected);
  }
}
