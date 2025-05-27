package com.nathanassis.frag.controllers;

import com.nathanassis.frag.services.ChatApiService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

public class MessageContainerController {
  @FXML private TextArea messageInput;
  @FXML private Button sendMessageButton;

  @FXML
  public void initialize() {
    messageInput.setOnKeyPressed(
        event -> {
          if (event.getCode() == KeyCode.ENTER) {
            handleSendMessage();
          }
        });
  }

  @FXML
  private void handleSendMessage() {
    String message = messageInput.getText().trim();
    if (message.isEmpty()) {
      return;
    }

    ChatController chat = (ChatController) ControllerFactory.getInstance("Chat");
    chat.addMessage(message);
    sendMessage(message);
  }

  private void sendMessage(String message) {
    Task<String> task =
        new Task<>() {
          @Override
          protected String call() throws Exception {
            return ChatApiService.sendMessage(message).join();
          }
        };

    task.setOnSucceeded(
        evt -> {
          String response = task.getValue();
          System.out.println("Resposta da API: " + response);
          messageInput.clear();
        });

    task.setOnFailed(
        evt -> {
          Throwable ex = task.getException();
          System.err.println("Erro ao enviar mensagem: " + ex.getMessage());
          messageInput.clear();
        });

    new Thread(task).start();
  }
}
