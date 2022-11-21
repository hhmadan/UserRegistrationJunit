package com.junittest;

import com.java.InvalidUserDetailsException;
import com.java.UserRegistration;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestLogic {
    @Test
    public void validateFirstLastName()throws InvalidUserDetailsException {
        //assertEquals(false,UserRegistration.validateNameRegex("firstname"));
        assertTrue(UserRegistration.isValidFirstName("Firstname"));
        try {
            UserRegistration.isValidLastName("lastname");
        }
        catch(InvalidUserDetailsException ie){
            System.out.println("Invalid Name");
        }
        //assertFalse(UserRegistration.validateNameRegex("lastname"));
    }
    @Test
    public void validateEmail()throws InvalidUserDetailsException {
        assertTrue(UserRegistration.isValidEmail("abc@bl.co"));
        try{
            UserRegistration.isValidEmail(".abc@bl.co");
        }
        catch (InvalidUserDetailsException ie){
            System.out.println(ie.getMessage());
        }
        //assertFalse(UserRegistration.isValidEmail(".abc@bl.co"));
    }
    @Test
    public void validateMobile()throws InvalidUserDetailsException {
        assertTrue(UserRegistration.isValidMobNum("91 8989898989"));
        try{
            UserRegistration.isValidMobNum("91-8989898989");
        } catch (InvalidUserDetailsException ie) {
            System.out.println(ie.getMessage());
        }
        //assertFalse(UserRegistration.isValidMobNum("91-8989898989"));
    }
    @Test
    public void validatePassword()throws InvalidUserDetailsException {
        assertTrue(UserRegistration.isValidPassword("Pass9@word"));
        try{
            UserRegistration.isValidPassword("pass");
        }
        catch (InvalidUserDetailsException ie){
            System.out.println(ie.getMessage());
        }
        //assertFalse(UserRegistration.isValidPassword("pass"));
    }
}