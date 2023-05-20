package sen3004.app3.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {

	private String fullName;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	private String gender;
	private Integer height;
	private Double weight;

	public int getAge() {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	public double getBodyMassIndex() {
		// kg / m^2
		return weight / Math.pow((height / 100.0), 2);
	}

	public String getBodyMassIndexString() {
		return String.format(Locale.ROOT, "%.2f", getBodyMassIndex());
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
