package fr.soatandduchess.handsOn.commands;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LoginCommandTest {
    
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
    public void should_match_the_ouptut_in_bytes() throws Exception {
        LoginCommand loginCommand = new LoginCommand("myName", "azerty");
        loginCommand.write(outputStream);

        Assertions.assertThat(outputStream.toByteArray())
                .containsOnly(-34, -83, 20, 1, 109, 121, 78, 97, 109, 101, 0, 97, 122, 101, 114, 116, 121, 0, -66, -17);
    }

}