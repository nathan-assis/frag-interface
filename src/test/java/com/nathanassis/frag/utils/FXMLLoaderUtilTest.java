package com.nathanassis.frag.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URL;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FXMLLoaderUtilTest {

  @Test
  @DisplayName("getLocation deve retornar URL válida para FXML existente")
  void testGetLocationExistingResource() {
    String file = "Main";
    URL location = FXMLLoaderUtil.getLocation(file);
    assertNotNull(location, "A URL não deve ser null para resource existente");

    String path = Constants.FXML_PATH + file + ".fxml";
    URL expectedLocation = FXMLLoaderUtil.class.getResource(path);
    assertEquals(location, expectedLocation);
  }

  @Test
  @DisplayName("getLocation deve lançar IllegalArgumentException para recurso inexistente")
  void testGetLocationNonExistingResource() {
    String nonExistingFile = "NonExistingFile";
    assertThrows(
        IllegalArgumentException.class,
        () -> FXMLLoaderUtil.getLocation(nonExistingFile),
        "Deve lançar IllegalArgumentException quando o recurso não for encontrado");
  }

  @Test
  @DisplayName("getLocation deve lançar IllegalArgumentException para input nulo")
  void testGetLocationNullInput() {
    assertThrows(
        IllegalArgumentException.class,
        () -> FXMLLoaderUtil.getLocation(null),
        "Deve lançar IllegalArgumentException quando o argumento for null");
  }

  @Test
  @DisplayName("getLocation deve lançar IllegalArgumentException para string vazia")
  void testGetLocationEmptyString() {
    String empty = "";
    assertThrows(
        IllegalArgumentException.class,
        () -> FXMLLoaderUtil.getLocation(empty),
        "Deve lançar IllegalArgumentException para string vazia");
  }

  @Test
  @DisplayName("getLocation deve lançar IllegalArgumentException para nome com extensão inclusa")
  void testGetLocationWithExtension() {
    String withExtension = "Main.fxml";
    assertThrows(
        IllegalArgumentException.class,
        () -> FXMLLoaderUtil.getLocation(withExtension),
        "Deve lançar IllegalArgumentException quando o nome já inclui '.fxml'");
  }

  @Test
  @DisplayName("getLocation deve lançar IllegalArgumentException para string com espaços")
  void testGetLocationWhitespace() {
    String whitespace = "   ";
    assertThrows(
        IllegalArgumentException.class,
        () -> FXMLLoaderUtil.getLocation(whitespace),
        "Deve lançar IllegalArgumentException para string contendo apenas espaços");
  }
}
