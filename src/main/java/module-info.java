module GuessNumber.GuessNumber {
    requires javafx.controls;
    requires javafx.fxml;

    opens GuessNumber.GuessNumber to javafx.fxml;
    exports GuessNumber.GuessNumber;
}
