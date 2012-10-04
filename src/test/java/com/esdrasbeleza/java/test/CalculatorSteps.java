package com.esdrasbeleza.java.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.esdrasbeleza.java.Calculator;

public class CalculatorSteps {

	private Calculator calculator;
	private int number;
	private int result;
	private Exception exception;
	
	@Given("a number $number")
	public void aNumber(int number) {
		calculator = new Calculator();
		this.number = number; 
	}
	
	@When("we multiply it by $number")
	public void multiplyBy(int number) {
		result = calculator.multiply(this.number, number);
	}
	
	@When("we divide it by $number")
	public void divideBy(int number) {
		try {
			result = calculator.divide(this.number, number);
		}
		catch (ArithmeticException e) {
			exception = e;
		}
	}
	
	@Then("the result is $number")
	public void assertResult(int number) {
		assertThat(result, equalTo(number));
	}
	
	@SuppressWarnings("unchecked")
	@Then("we get an error")
	public void assertException() {
		assertThat(exception, allOf(notNullValue(), instanceOf(ArithmeticException.class)));
	}
	
}
