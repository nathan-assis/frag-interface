package com.nathanassis.frag.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nathanassis.frag.JavaFXTestBase;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChatControllerTest extends JavaFXTestBase {

  @Test
  @DisplayName("addMessage should add new Label to VBox")
  void addMessage_ValidMessage_AddLabel() {
    ChatController controller = (ChatController) ControllerFactory.getInstance("Chat");
    controller.addMessage("Hello, world!");
    VBox messagesBox = getMessagesBox(controller);

    assertEquals(1, messagesBox.getChildren().size(), "Should have 1 message");
    assertTrue(messagesBox.getChildren().get(0) instanceof Label, "Should be a Label");
    assertEquals(
        "Hello, world!", ((Label) messagesBox.getChildren().get(0)).getText(), "Text should match");
  }

  private VBox getMessagesBox(ChatController controller) {
    try {
      var field = ChatController.class.getDeclaredField("messages");
      field.setAccessible(true);
      return (VBox) field.get(controller);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
