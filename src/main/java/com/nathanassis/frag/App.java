package com.nathanassis.frag;

import com.nathanassis.frag.controllers.MainController;
import com.nathanassis.frag.utils.FXMLLoaderUtil;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  private static FXMLLoader loader = new FXMLLoader();
  private static Scene scene = null;
  private static String file = "Main";

  private static void initLoader() {
    URL location = FXMLLoaderUtil.getLocation(file);
    loader.setLocation(location);
  }

  private void setMainContent() throws IOException {
    MainController controller = loader.getController();
    if (controller != null) {
      controller.setContent("Logo");
    } else {
      throw new IOException("Controller not found.");
    }
  }

  @Override
  public void start(Stage stage) throws IOException {
    initLoader();

    Parent main = loader.load();
    setMainContent();

    scene = new Scene(main, 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
