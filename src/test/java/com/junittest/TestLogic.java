package com.junittest;

import com.java.InvalidUserDetailsException;
import com.java.UserRegistration;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestLogic {
    @Test
    public void validateFirstLastName()throws InvalidUserDetailsException {
        UserRegistration user = new UserRegistration();
        boolean output = user.isValidFirstName.ValidateUserEntries("Firstname");
        assertTrue(output);

        // Custom exception for invalid lastname
        try {
            user.isValidLastName.ValidateUserEntries("lastname");
        }
        catch(InvalidUserDetailsException ie) {
            //assertEquals("Invalid Last Name..!",ie.getMessage());
            System.out.println(ie.getMessage());
        }
    }
    @Test
    public void validateEmail()throws InvalidUserDetailsException {
        UserRegistration user = new UserRegistration();
        boolean output = user.isValidEmail.ValidateUserEntries("abc@bl.co");
        assertTrue(output);
        try{
            user.isValidEmail.ValidateUserEntries(".abc@bl.co");
        }
        catch (InvalidUserDetailsException ie) {
            System.out.println(ie.getMessage());
        }
    }
    @Test
    public void validateMobile() throws InvalidUserDetailsException {
        UserRegistration user = new UserRegistration();
        boolean output = user.isValidMobNum.ValidateUserEntries("91 8989898989");
        assertTrue(output);
        try{
            user.isValidMobNum.ValidateUserEntries("91-8989898989");
        } catch (InvalidUserDetailsException ie) {
            System.out.println(ie.getMessage());
        }
        //assertFalse(UserRegistration.isValidMobNum("91-8989898989"));
    }
    @Test
    public void validatePassword()throws InvalidUserDetailsException {
        UserRegistration user = new UserRegistration();
        boolean output = user.isValidPassword.ValidateUserEntries("Pass9@word");
        assertTrue(output);
        try{
            user.isValidPassword.ValidateUserEntries("pass");
        }
        catch (InvalidUserDetailsException ie){
            System.out.println(ie.getMessage());
        }
        //assertFalse(UserRegistration.isValidPassword("pass"));
    }
}