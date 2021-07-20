package com.javacours.se.lesson5;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class User {
    String [] args;
    int al;

    public User(String [] args){
        this.args = args;
        this.al = args.length;
    }

    public boolean validate () {
        int al = args.length;
        if (al<3) {
            System.out.println("Enter more than 2 strings, for example, Rock Paper Scissors: ");
            return false;
        } else if (al%2 != 1) {
            System.out.println("Enter an even number of strings, for example, Rock Paper Scissors: ");
            return false;
        } else {
            Set<String> mySet = new LinkedHashSet<String>(Arrays.asList(args));
            if (mySet.size() != al) {
                System.out.println("Enter all the different lines: ");
                return false;
            }
        }
        return true;
    }

    public void getMenu() {
        for (int i = 0; i < al; i ++) {         //user
            System.out.println(i+1+"  "+args[i]);
        }
        System.out.println(0+"  Menu");
    }

    public int getUserChoice() {
        int l = 0;
        boolean inputError = true;
        while (inputError) {
            try {
                Scanner s = new Scanner(System.in);   //Enter your move:  user
                l = s.nextInt();
                if ((l>=0) && (l<=al)) {
                    inputError = false;
                }
                else {
                    System.out.println("Enter the correct value: ");
                }
            }
            catch (Exception e){
                inputError = true;
                System.out.println("Enter the correct value: ");
            }
        };
        return l;
    }

    public void getResultGame (int x,int l) {
        int g = (al/2);
        if (x == l) {           // NICHIA POPEDA LOSE  user
            System.out.println("Draw: ");
        } else {
            if (l<=al) {
                if (x>=g+1) {
                    if ((l>=x-g) && (l<x)) {
                        System.out.println("You lose:(");
                    }
                    else {
                        System.out.println("You win!");
                    }
                }  else {
                    if ((l<=x+g) && (l>x)) {
                        System.out.println("You win");
                    } else {
                        System.out.println("You lose");
                    }
                }
            }
        }
    }
}
