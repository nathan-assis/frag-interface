package com.nathanassis.frag;

import javafx.application.Platform;

public class TestUtils {
  private static boolean toolkitInitialized = false;

  public static void initToolkit() {
    if (!toolkitInitialized) {
      try {
        Platform.startup(() -> {});
        toolkitInitialized = true;
      } catch (IllegalStateException e) {
        // Toolkit já iniciado
      }
    }
  }
}
