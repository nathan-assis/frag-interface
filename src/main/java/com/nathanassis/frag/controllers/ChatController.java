package com.nathanassis.frag.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ChatController {
    @FXML private VBox messageList;

    public void addMessage(String message) {
        Label label = new Label(message);

        messageList.getChildren().add(label);
    }
}
