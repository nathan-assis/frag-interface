package com.nathanassis.frag.controllers;

import com.nathanassis.frag.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

  @FXML
  private void switchToSecondary() throws IOException {
    String path = "/com/nathanassis/frag/fxml/secondary.fxml";
    App.setRoot(path);
  }
}
