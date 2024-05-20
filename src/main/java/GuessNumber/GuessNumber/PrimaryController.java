package GuessNumber.GuessNumber;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField textInput;

    @FXML
    private Button guessButton;

    @FXML
    private Label messageLabel;

    @FXML
    private Label countLabel;

    @FXML
    private Button newGameButton;

    @FXML
    private Button endButton;

    // NICHT VERGESSEN!
    private RndNumber model;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new RndNumber(10);

        endButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.init();
                updateView();
            }
        });

        guessButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateModel();
                model.auswertungTipp();
                updateView();
            }
        });
    }

    public void updateModel() {
        model.setTippEingabe(textInput.getText());
    }

    public void updateView() {
        messageLabel.setText(model.getMessage());
        countLabel.setText("Attempts: " + model.getVersuche());
    }

}
