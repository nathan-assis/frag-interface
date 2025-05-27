package com.nathanassis.frag.core;

import com.nathanassis.frag.utils.Constants;

public enum View {
  CHAT("Chat");

  private final String file;

  View(String file) {
    this.file = file;
  }

  public String fullPath() {
    return Constants.FXML_PATH + file + ".fxml";
  }

  public static View fromFile(String file) {
    for (View view : View.values()) {
      if (view.file.equals(file)) {
        return view;
      }
    }
    throw new IllegalArgumentException("FXML not found: " + file);
  }
}
