module CalculatorFx {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens CalculatorFx to javafx.graphics, javafx.fxml;
}
