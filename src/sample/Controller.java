package sample;

import javafx.event.ActionEvent;

import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField FirstNameField = new TextField();

    @FXML
    private TextField emailField = new TextField();

    @FXML
    private TextField LastNameField = new TextField();

    @FXML
    private Button submitButton;

    @FXML
    private Button clearButton;

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        if (!FirstNameField.getText().equals("") && !LastNameField.getText().equals("") && !emailField.getText().equals(""))
        {
            try {
                FileWriter csvWriter=new FileWriter("data.csv");
                csvWriter.append(FirstNameField.getText());
                csvWriter.append(",");
                csvWriter.append(LastNameField.getText());
                csvWriter.append(",");
                csvWriter.append(emailField.getText());
                csvWriter.append("\n");

                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleClearButtonAction(ActionEvent actionEvent) {
        FirstNameField.setText("");
        LastNameField.setText("");
        emailField.setText("");
    }
}
