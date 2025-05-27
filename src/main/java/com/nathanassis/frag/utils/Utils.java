package com.nathanassis.frag.utils;

import java.net.URL;

public final class Utils {
  private Utils() {}

  public static URL stringToUrl(String path) {
    URL url = Utils.class.getResource(path);

    if (url == null) {
      throw new IllegalArgumentException("FXML not found: " + path);
    }

    return url;
  }
}
