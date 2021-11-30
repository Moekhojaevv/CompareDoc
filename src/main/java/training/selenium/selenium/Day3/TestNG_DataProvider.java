package training.selenium.selenium.Day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.Generic;

public class TestNG_DataProvider extends Generic{
	/*
	 * @Test(dependsOnMethods="testMethod2") public void testMethod1() {
	 * System.out.println("Inside My Test ng method testMethod 1 "); }
	 */
	
	@Test(dataProvider="ABC")
	public void testMethod2(String sValue,int sNumb) {
		System.out.println("Inside My Test ng method testMethod 2 with Value:"+sValue +" and Number="+sNumb);
	}

	@Test()
	public void testMethod3() {
		System.out.println("Inside My Test ng method testMethod 3");
	}	
	

	@DataProvider (name = "ABC")
	public Object[][] dpMethod() {
	    return new Object [][] { {"First-Value",1}, {"Second-Value",2}};
	}

}
