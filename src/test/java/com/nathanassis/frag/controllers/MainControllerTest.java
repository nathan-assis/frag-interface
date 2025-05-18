package com.nathanassis.frag.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Field;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class MainControllerTest extends ApplicationTest {
  private MainController controller;
  private Pane contentPane;

  @BeforeEach
  void setUp() throws Exception {
    controller = new MainController();

    Field contentField = MainController.class.getDeclaredField("content");
    contentField.setAccessible(true);

    contentPane = new Pane();
    contentField.set(controller, contentPane);
  }

  @Test
  @DisplayName("setContent deve carregar um Node de FXML válido e substituir o conteúdo")
  void testSetContentValid() throws IOException {
    controller.setContent("MessageContainer");
    assertFalse(contentPane.getChildren().isEmpty(), "contentPane deve ter pelo menos um filho");

    Node loaded = contentPane.getChildren().get(0);
    assertNotNull(loaded, "O Node carregado não deve ser null");

    assertTrue(loaded instanceof javafx.scene.Parent, "O Node carregado deve ser um Parent");
  }

  @Test
  @DisplayName("setContent deve lançar IllegalArgumentException para recurso inexistente")
  void testSetContentNonExisting() {
    String nonExistingFile = "NonExistingFile";
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.setContent(nonExistingFile),
        "Deve lançar IllegalArgumentException quando o recurso não for encontrado");
  }

  @Test
  @DisplayName("setContent deve lançar IllegalArgumentException para nome nulo")
  void testSetContentNull() {
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.setContent(null),
        "Deve lançar IllegalArgumentException quando o argumento file for null");
  }
}
