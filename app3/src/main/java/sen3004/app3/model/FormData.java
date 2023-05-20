package sen3004.app3.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class FormData {

	private int numericField;
	private String textField;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateField;
	private List<String> checkboxSelection;
	private String radioButtonValue;

	public int getNumericField() {
		return numericField;
	}

	public void setNumericField(int numericField) {
		this.numericField = numericField;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public LocalDate getDateField() {
		return dateField;
	}

	public void setDateField(LocalDate dateField) {
		this.dateField = dateField;
	}

	public List<String> getCheckboxSelection() {
		return checkboxSelection;
	}

	public void setCheckboxSelection(List<String> checkboxSelection) {
		this.checkboxSelection = checkboxSelection;
	}

	public String getRadioButtonValue() {
		return radioButtonValue;
	}

	public void setRadioButtonValue(String radioButtonValue) {
		this.radioButtonValue = radioButtonValue;
	}

}
