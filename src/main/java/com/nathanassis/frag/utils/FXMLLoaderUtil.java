package com.nathanassis.frag.utils;

import java.net.URL;

public final class FXMLLoaderUtil {
  private FXMLLoaderUtil() {}

  public static URL getLocation(String file) {
    String path = Constants.FXML_PATH + file + ".fxml";
    URL url = FXMLLoaderUtil.class.getResource(path);

    if (url == null) {
      throw new IllegalArgumentException("Resource not found: " + path);
    }

    return url;
  }
}
