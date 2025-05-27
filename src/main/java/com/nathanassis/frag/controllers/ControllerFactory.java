package com.nathanassis.frag.controllers;

import com.nathanassis.frag.core.Controller;
import com.nathanassis.frag.core.View;
import com.nathanassis.frag.utils.Utils;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ControllerFactory {
  private static ChatController chatController = null;

  private ControllerFactory() {}

  public static Controller getInstance(String fxml) {
    View view = View.fromFile(fxml);

    switch (view) {
      case CHAT:
        if (chatController == null) {
          FXMLLoader loader = new FXMLLoader(Utils.stringToUrl(view.fullPath()));
          Parent root = null;
          try {
            root = loader.load();
          } catch (IOException e) {
            System.err.println("Error loading FXML: " + fxml);
          }

          chatController = loader.getController();
          chatController.setRoot(root);
        }

        return chatController;
      default:
        throw new IllegalArgumentException("No controller found for view: " + view);
    }
  }
}
