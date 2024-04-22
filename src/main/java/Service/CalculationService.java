package Service;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Model.Calculator;

@Stateless
public class CalculationService {
	
	@PersistenceContext(unitName = "calc")
	private EntityManager entityManager;
	
	public int calculate(Calculator calculator) {
	    int number1 = calculator.getNumber1();
	    int number2 = calculator.getNumber2();
	    String operation = calculator.getOperation();
	    int result = 0;

	    switch (operation) {
	        case "+":
	            result = number1 + number2;
	            break;
	        case "-":
	            result = number1 - number2;
	            break;
	        case "/":
	            if (number2 != 0) {
	                result = number1 / number2;
	            } else {
	                throw new IllegalArgumentException("Division by zero!");
	            }
	            break;
	        case "*":
	            result = number1 * number2;
	            break;
	        default:
	            throw new IllegalArgumentException("Wrong usage of operation: " + operation);
	    }

	    entityManager.persist(calculator);

	    return result;
	}

	

	public List<Calculator> getAllCalculations() {
		TypedQuery<Calculator> query = entityManager.createQuery("SELECT c FROM Calculator c", Calculator.class);
		return query.getResultList();
	}
}
