package com.nathanassis.frag.controllers;

import com.nathanassis.frag.core.Controller;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ChatController implements Controller {
  @FXML private VBox messages;
  @FXML private ScrollPane chatScroll;
  private Parent root;

  @Override
  public Parent getRoot() {
    return root;
  }

  @Override
  public void setRoot(Parent root) {
    this.root = root;
  }

  public void addMessage(String message) {
    Label label = new Label(message);

    this.messages.getChildren().add(label);

    chatScroll.setVvalue(1.0);
  }
}
