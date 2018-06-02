package fr.soatandduchess.handsOn.commands;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AddEmployeeCmdTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void initialize_common_variables() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void should_print_the_bytes_version_of_the_address() throws Exception {
        AddEmployeeCmd addEmployeeCmd = createAnEmployeeCmd();

        addEmployeeCmd.write(outputStream);

        byte[] actual = outputStream.toByteArray();
        Assertions.assertThat(actual)
                .containsOnly(-34, -83, 34, 2, 109, 101, 0, 109, 111, 110, 32, 97, 100, 114, 101, 115, 115, 101, 0, 112, 97, 114, 105, 115, 0, 73, 68, 70, 0, 49, 48, 0, -66, -17);
    }

    private AddEmployeeCmd createAnEmployeeCmd() {
        String name = "me";
        String address = "mon adresse";
        String city = "paris";
        String dept = "IDF";
        int yearlySalary = 10;
        return new AddEmployeeCmd(name, address, city, dept, yearlySalary);
    }

}