package com.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static boolean validateNameRegex(String input) {
        String regex = "[A-Z][a-z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public UserRegistrationInterface isValidFirstName = (String fName)->  {      // validate first name
        if (validateNameRegex(fName)) {
            System.out.println("Your First Name ==> " + fName);
        }else{
            throw new InvalidUserDetailsException("Invalid First Name");
        }
        return true;
    };
    public UserRegistrationInterface isValidLastName = (String lName) -> {       // validate last name
        if(validateNameRegex(lName)){
            System.out.println("Your Last Name ==> "+lName);
        } else {
            throw new InvalidUserDetailsException("Invalid Last Name..!");
        }
        return true;
    };
    public UserRegistrationInterface isValidEmail = (String email) -> {          // validate email-id
        String regex = "^[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_-]+)*@(?:[a-zA-Z0-9]+\\.)+[a-zA-Z]{2,5}$";

        if (Pattern.compile(regex).matcher(email).matches()) {
            System.out.println("This is valid mail-id ==> " +email);
        } else {
            throw new InvalidUserDetailsException("This is Invalid mail-id ==> " +email);
        }
        return true;
    };
    public UserRegistrationInterface isValidMobNum = (String mobNum) -> {        // validation for mobile number
        String regex = "[0-9]{2}+\\s+[789][0-9]{9}";        // \\s provides single space
        if (Pattern.compile(regex).matcher(mobNum).matches()) {
            System.out.println("Your Mobile Number ==> " + mobNum);
        } else {
            throw new InvalidUserDetailsException("Invalid Mobile Number..!");
        }
        return true;
    };
    public UserRegistrationInterface isValidPassword = (String password) -> {     // validation for password
        // Rule1-Password can be alphanumeric with minimum 8 and above characters
        // Rule2-Password must have at least 1 Upper case letter
        // Rule3-Password must have at least 1 numeric
        // Rule4-Password must have at least 1 special character

        String regex = "^(?=.*[A-Z])" +                     // at least 1 uppercase
                "(?=.*\\d)" +                               // at least 1 numeric
                "(?=.*[!@#$%^&*_?])" +                      // at least 1 special character
                "[a-zA-Z\\d!@#$%^&*_?]*.{8,}$";             // repeat alphanumerics with minimum of 8 characters

        if(Pattern.compile(regex).matcher(password).matches()){
            System.out.println("Great..! Perfect Password");
        } else {
            throw new InvalidUserDetailsException("Invalid Password..!");
        }
        return true;
    };
//    public static void main(String[] args) throws InvalidUserDetailsException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter First Name: ");
//        String fName = sc.next();
//        isValidFirstName(fName);        // check if input matches the regex
//
//        System.out.println("Enter Last Name: ");
//        String lName = sc.next();
//        isValidLastName(lName);         // validating last name
//
//        System.out.println("Enter Email-id: ");
//        String email = sc.next();
//        isValidEmail(email);            // validating email-id
//
//        System.out.println("Enter Mobile Number: ");
//        sc.nextLine();
//        String mobNum = sc.nextLine();
//        isValidMobNum(mobNum);          // validating mobile number
//
//        System.out.println("Create Password");
//        String password = sc.next();
//        isValidPassword(password);      // validating password
//    }
}