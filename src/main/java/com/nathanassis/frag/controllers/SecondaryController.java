package com.nathanassis.frag.controllers;

import com.nathanassis.frag.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

  @FXML
  private void switchToPrimary() throws IOException {
    String path = "/com/nathanassis/frag/fxml/primary.fxml";
    App.setRoot(path);
  }
}
