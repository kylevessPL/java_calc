package pl.piasta.kck.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.piasta.kck.calc.utils.Operation;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static pl.piasta.kck.calc.utils.Operation.ADD;
import static pl.piasta.kck.calc.utils.Operation.SHOW_RESULT;

public class Controller {

    @FXML
    private TextField resultField;

    private BigInteger currentValue = ZERO;
    private Operation latestOperation = ADD;
    private boolean resultShown;

    public void numButtonOnClick(ActionEvent actionEvent) {
        if (resultShown) {
            resultShown = false;
            resultField.clear();
        }
        String resultValue = ((Button) actionEvent.getSource()).getText();
        if (resultField.getText().equals("0")) {
            resultField.setText(resultValue);
        } else {
            resultField.appendText(resultValue);
        }
    }

    public void opButtonOnClick(ActionEvent actionEvent) {
        BigInteger value = BigInteger.valueOf(Long.parseLong(resultField.getText()));
        Operation operation = Operation.getByName(((Button) actionEvent.getSource()).getText());
        calculate(value, latestOperation);
        if (operation.equals(SHOW_RESULT)) {
            resultField.setText(currentValue.toString());
            resultShown = true;
            currentValue = ZERO;
            latestOperation = ADD;
        } else {
            latestOperation = operation;
            resultField.clear();
        }
    }

    public void clearButtonOnClick() {
        resultField.clear();
        resultField.setText("0");
    }

    private void calculate(BigInteger value, Operation operation) {
        switch (operation) {
            case ADD:
                currentValue = currentValue.add(value);
                break;
            case SUBTRACT:
                currentValue = currentValue.subtract(value);
                break;
            case MULTIPLY:
                currentValue = currentValue.multiply(value);
                break;
            case DIVIDE:
                currentValue = currentValue.divide(value);
                break;
        }
    }

}
