package com.junittest;
import com.java.InvalidUserDetailsException;
import com.java.UserRegistration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmailParameterisedTest{
    private final String input;
    private final boolean result;
    UserRegistration user;

    @Before
    public void initialize() {
        this.user = new UserRegistration();
    }
    public EmailParameterisedTest(String input, boolean result) {
        this.input = input;
        this.result = result;
    }
    @Test
    public void testUserEmail() throws InvalidUserDetailsException {
        assertEquals(result, UserRegistration.isValidEmail(input));
    }

    @Parameters
    public static Collection emails() {
        return Arrays.asList(
                new Object[][] { { "abc@yahoo.com", true }, { "abc.100@yahoo.com", true },
                        { "abc111@abc.com", true }, { "abc@1.com", true },
                        { "abc@gmail.com.aa.au ", false }, { "abc..2002@gmail. com" , false },
                        { "abc" , false }, { "abc @.com.m" , false },
                        { "abc @%*.com" , false }});
    }
}