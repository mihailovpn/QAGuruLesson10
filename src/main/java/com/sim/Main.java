package com.sim;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Bug bug = new Bug();
        BugoFix bugoFix = new BugoFix();

        System.out.println("Программа до бага:");
        program.sayWhatYouCan();
        bug.takeRoot(program);
        System.out.println("Программа после бага:");
        program.sayWhatYouCan();

        bugoFix.fixTheBug(program);
        System.out.println("Программа после багофикса:");
        program.sayWhatYouCan();


    }
}
