package com.nathanassis.frag;

import org.junit.jupiter.api.BeforeAll;

public abstract class JavaFXTestBase {
  @BeforeAll
  public static void setupJavaFX() {
    TestUtils.initToolkit();
  }
}
