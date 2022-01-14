package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>();
        File myFile;
        Scanner input = null;
        try {
            myFile = new File("movies.txt");
            input = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (input != null) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                movies.add(line);
            }
        }
        int randomIndex = (int) (Math.random()*movies.size());
        String luckyMovie = movies.get(randomIndex);
        StringBuilder movieBuilder = new StringBuilder(luckyMovie.replaceAll("[a-zA-Z]","-"));
        int wrong = 0;
        int maxwrong = 10;
        char guess;
        StringBuilder trials = new StringBuilder("");
        input = new Scanner(System.in);
        System.out.println("You can only make " + maxwrong + " mistakes");
        while(wrong < maxwrong && movieBuilder.indexOf("-")!=-1)
        {
            System.out.println("wrong guesses= " + wrong);
            System.out.println("so far you tried: "+trials);
            System.out.println(movieBuilder);
            System.out.println("input a char and try your luck");
            guess = input.next().charAt(0);
            if(trials.toString().indexOf(guess)!=-1)
            {
                System.out.println("Already tried this one before!");
                continue;
            }
            trials.append(guess);
            boolean changed = false;
            int index = luckyMovie.toLowerCase().indexOf((int) guess);
            while(index!=-1){
                movieBuilder.setCharAt(index,luckyMovie.charAt(index));
                changed=true;
                index = luckyMovie.toLowerCase().indexOf((int) guess,index+1);
            }
            if(!changed)
                wrong++;
        }
        System.out.println(luckyMovie);

    }
}