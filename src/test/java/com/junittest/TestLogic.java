package com.junittest;

import com.java.UserRegistration;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestLogic {
    @Test
    public void validateFirstLastName(){
        //assertEquals(false,UserRegistration.validateNameRegex("firstname"));
        assertTrue(UserRegistration.validateNameRegex("Firstname"));
        assertFalse(UserRegistration.validateNameRegex("lastname"));
    }
    @Test
    public void validateEmail(){
        assertTrue(UserRegistration.isValidEmail("abc@bl.co"));
        assertFalse(UserRegistration.isValidEmail(".abc@bl.co"));
    }
    @Test
    public void validateMobile(){
        assertTrue(UserRegistration.isValidMobNum("91 8989898989"));
        assertFalse(UserRegistration.isValidMobNum("91-8989898989"));
    }
    @Test
    public void validatePassword(){
        assertTrue(UserRegistration.isValidPassword("Pass9@word"));
        assertFalse(UserRegistration.isValidPassword("pass"));
    }
}