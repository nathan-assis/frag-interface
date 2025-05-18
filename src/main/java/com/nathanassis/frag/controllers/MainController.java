package com.nathanassis.frag.controllers;

import com.nathanassis.frag.utils.FXMLLoaderUtil;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class MainController {
  @FXML private Pane content;

  public void setContent(String file) throws IOException {
    URL location = FXMLLoaderUtil.getLocation(file);
    FXMLLoader loader = new FXMLLoader(location);

    Node contentNode = loader.load();
    content.getChildren().setAll(contentNode);
  }
}
