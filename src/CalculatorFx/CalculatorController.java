package CalculatorFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class CalculatorController {

	@FXML
	private Label result;
	private long number1 = 0;
	private String operator = "";
	private boolean start= true;
	private Model model=new Model();

	@FXML
	public void processNumbers(ActionEvent event) {
		if(start) {
			result.setText("");
			start=false;
		}
		String value= ((Button)event.getSource()).getText(); //number
		result.setText(result.getText()+value);

	}

	@FXML
	public void processOperrators(ActionEvent event) {
		String value= ((Button)event.getSource()).getText();   // operator
		if(!value.equals("=")){
			if(!operator.isEmpty()) // eger bir deger girildiyse girilen degeri dondur
				return;
			
			operator=value;
			number1 = Long.parseLong(result.getText());
			result.setText("");
		}else {
			if(operator.isEmpty())
				return;
			long number2=Long.parseLong(result.getText());
			
			float output = model.calculator(number1, number2, operator);
			result.setText(String.valueOf(output));
			operator="";
			start=true;
		}

	}
}
