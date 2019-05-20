package hotelmng.model.person;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmployeeTest {


    @Test
    public void getCorrectAgeBirthYearBefore2000() {
        //GIVEN
        Employee employee = new Receptionist(1234, "2901111111111", "Vivi");

        //WHEN
        int response = employee.getAge();

        //THEN
        //assertEquals(29, response);
        assertThat(response, is(29));
    }

    @Test
    public void getCorrectAgeBirthYearAfter2000() {
        //GIVEN
        Employee employee = new Receptionist(1234, "2014444444444", "Vivi");
        //WHEN
        int response = employee.getAge();

        //THEN
        assertEquals(18, response);
    }
}