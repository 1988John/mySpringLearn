package com.foo.test;

public class Example {

     private static String message = "abcdfdsfdsfsdafasdf";
     private static String subMessage = null;

     public Example(String message) {
          Example.message = message;
     }

     static {
          /* Store the first 10 characters of the input message. */
          subMessage = message.substring(0, 10);
     }

     public String getSubMessage() {
          return subMessage;
     }

     public static void main(String[] args) {
          Example exampleClass = new Example("Test");
          System.out.println(exampleClass.getSubMessage());
     }
}