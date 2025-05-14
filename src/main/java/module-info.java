module com.nathanassis.frag {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.nathanassis.frag to
      javafx.fxml;
  opens com.nathanassis.frag.controllers to
      javafx.fxml;

  exports com.nathanassis.frag;
}
