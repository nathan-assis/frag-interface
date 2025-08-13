module com.nathanassis.frag {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.net.http;
  requires com.fasterxml.jackson.databind;

  opens com.nathanassis.frag to
      javafx.fxml;
  opens com.nathanassis.frag.controllers to
      javafx.fxml;
  opens com.nathanassis.frag.dto to
      com.fasterxml.jackson.databind;
  opens com.nathanassis.frag.services to
      com.fasterxml.jackson.databind;

  exports com.nathanassis.frag;
}
