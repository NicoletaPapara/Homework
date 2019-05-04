package hotelmng.model.person;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {


    @Test
    public void getCorrectAgeBirthYearBefore2000() {
        //GIVEN
        Employee employee = new Receptionist(1234, "2901111111111", "Vivi");

        //WHEN
        int response = employee.getAge();

        //THEN
        assertEquals(29,response);
    }

    @Test
    public void getCorrectAgeBirthYearAfter2000(){
        //GIVEN
        Employee employee = new Receptionist(1234, "2014444444444", "Vivi");
        //WHEN
        int response = employee.getAge();

        //THEN
        assertEquals(18,response);
    }
}