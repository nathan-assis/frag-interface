package com.nathanassis.frag.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {

  @Test
  @DisplayName("stringToUrl should return URL")
  void stringToUrl_ValidPath_ReturnsUrl() throws MalformedURLException {
    String path = Constants.FXML_PATH + "Chat.fxml";
    URL location = Utils.stringToUrl(path);
    assertNotNull(location, "URL shouldn't be null");

    URL expected = Utils.class.getResource(path);
    assertEquals(location, expected);
  }

  @Test
  @DisplayName("stringToUrl should throw IllegalArgumentException")
  void stringToUrl_InvalidPath_IllegalArgumentException() {
    String path = Constants.FXML_PATH + "Invalid.fxml";
    assertThrows(
        IllegalArgumentException.class,
        () -> Utils.stringToUrl(path),
        "Should throw IllegalArgumentException for resource not found");
  }
}
