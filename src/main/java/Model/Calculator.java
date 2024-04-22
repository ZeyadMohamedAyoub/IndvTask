package Model;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Calculation")
public class Calculator  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	public Calculator() {}
	
	@Column(name = "Number1")
	int number1;
	
	@Column(name = "Number2")
	int number2;
	
	@Column(name = "Operation")
	String operation;

	public int getNumber1() {
		return number1;
	}
	
	public int getNumber2() {
		return number2;
	}
	
	public String getOperation() {
		return operation;
	}
	
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
