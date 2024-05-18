package org.example.tempratures;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField inputField;
    @FXML
    private ComboBox<String> unitComboBox;
    @FXML
    private Label celsiusOutput;
    @FXML
    private Label fahrenheitOutput;
    @FXML
    private Label kelvinOutput;
    @FXML
    public void initialize(){
        unitComboBox.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");;
    }
    @FXML
    protected void handleCovert() {
    try{
        double inputTempearture =Double.parseDouble(inputField.getText());
        String selectedunit =unitComboBox.getValue();

        double celsius,fahrenheit,kelvin;
        switch (selectedunit){
            case "Celsius":
                celsius=inputTempearture;
                fahrenheit =celsiusToFahrenheit(celsius);
                kelvin =celsiusToKelvin(celsius);
                break;
            case "Fahrenheit":
                fahrenheit=inputTempearture;
                celsius =fahrenheitToCelsius(fahrenheit);
                kelvin =celsiusToKelvin(celsius);
                break;
            case "Kelvin":
                kelvin=inputTempearture;
                celsius =kelvinToCelsius(kelvin);
                fahrenheit =celsiusToFahrenheit(celsius);
                break;
            default:
                throw new IllegalArgumentException("Invalid unit");
        }
        celsiusOutput.setText(String.format("%.2f",celsius));
        fahrenheitOutput.setText(String.format("%.2f",fahrenheit));
        kelvinOutput.setText(String.format("%.2f",kelvin));
    }catch (NumberFormatException ex){
        celsiusOutput.setText("Invalid input");
        fahrenheitOutput.setText("Invalid input");
        kelvinOutput.setText("Invalid input");
    }
    }
    private double celsiusToFahrenheit(double celsius){
        return celsius*9/5+32;
    }
    private double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit-32)*5/9;
    }
    private double celsiusToKelvin(double celsius){
        return celsius+273.15;
    }
    private double kelvinToCelsius(double kelvin){
        return kelvin-273.15;
    }
}