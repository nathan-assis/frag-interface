package com.nathanassis.frag;

import com.nathanassis.frag.controllers.ControllerFactory;
import com.nathanassis.frag.core.Controller;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  private static Scene scene = null;

  @Override
  public void start(Stage stage) throws IOException {
    Controller controller = ControllerFactory.getInstance("Chat");

    scene = new Scene(controller.getRoot(), 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
