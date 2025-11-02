//Anthony Nguyen, csd-420 Assignment 8, 11/01/2025
//The purpose of this program is to demonstrate the basic capabilities
//of the Thread class and the Runnable interface.

import java.util.Random; //only package needed

class MyRunnable implements Runnable {
    private String threadName;
    private String outputMessage;
    private final int LIMIT = 10000; //specified number of characters

    public MyRunnable(String name, String message) { //constructor to accept thread type and content
        this.threadName = name;
        this.outputMessage = message;
    }

    @Override
    public void run() {
        System.out.println(threadName + " thread is starting.");
        Random random = new Random();
        StringBuilder generatedString = new StringBuilder(LIMIT);//create new string to print the finished randomized line
        
        for (int i = 0; i < LIMIT; i++) { //each iteration selects a random character to add to the string
            int randomIndex = random.nextInt(outputMessage.length());
            char randomChar = outputMessage.charAt(randomIndex);
            generatedString.append(randomChar);
        }
        System.out.println(threadName + " thread has printed " + "\n" + generatedString + "\n");//print finished string
    }
}

public class AnthonyThreeThreads {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Symbolic", "`~!@#$%^&*()_+-={}|[]:;'<>?,./"));
        Thread thread2 = new Thread(new MyRunnable("Alphabetic", "pqowieurytlaksjdhfgmznxbcvQPWOEIRUTYALSKDJFHGZMXNCBV"));
        Thread thread3 = new Thread(new MyRunnable("Numeric", "0123456789"));

        //three threads start concurrently, will not print 1 then 2 then 3
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {//wait for threads to finish before joining main
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}