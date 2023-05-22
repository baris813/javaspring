package sen3004.app4.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class FormData {

	@Min(value = 5, message = "Min value: 5" )
	private Integer numericField1 = 9;
	private Double numericField2;
	
	@Size(min = 3, max = 7)
	private String textField1;
	
	@Email
	private String textField2;
	private String textField3;
	
	@NotEmpty
	private String dropDownMenu;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateField;
	
	@NotEmpty
	private List<String> checkboxSelection;
	
	@NotEmpty
	private String radioButtonValue;

	public Integer getNumericField1() {
		return numericField1;
	}

	public void setNumericField1(Integer numericField) {
		this.numericField1 = numericField;
	}

	public Double getNumericField2() {
		return numericField2;
	}

	public void setNumericField2(Double numericField2) {
		this.numericField2 = numericField2;
	}

	public String getTextField1() {
		return textField1;
	}

	public void setTextField1(String textField1) {
		this.textField1 = textField1;
	}

	public String getTextField2() {
		return textField2;
	}

	public void setTextField2(String textField2) {
		this.textField2 = textField2;
	}

	public String getTextField3() {
		return textField3;
	}

	public void setTextField3(String textField3) {
		this.textField3 = textField3;
	}

	public String getDropDownMenu() {
		return dropDownMenu;
	}

	public void setDropDownMenu(String dropDownMenu) {
		this.dropDownMenu = dropDownMenu;
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
