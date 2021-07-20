package com.javacours.se.lesson5;

public class Main {

    public static void main(String[] args) {
        int al = args.length;
        byte [] secret;

        User user = new User(args);
        Computer computer = new Computer(al);

        if (!user.validate()) {
            return;
        }
        //computer.secret
        secret = computer.getSecretKey();
        int x = computer.getChoiceComputer();
        String hmac = computer.getHmacWithMessage(secret,args[x-1]);

        System.out.println("HMAC: "+hmac);

        user.getMenu();

        System.out.print("Enter your move:");
        int l = user.getUserChoice();

        if (l == 0) { return; }
        System.out.println("Your move:"+args[l-1]);

        System.out.println("Computer move:"+args[x-1]);

        if ((l>=0) && (l<=al)) {
            user.getResultGame(x,l);
        }

        computer.printSecretKey(secret);
    }

}
