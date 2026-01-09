package com.zenika;

public class PremierProgramme {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hello " + args[0] + " " + args[1]);
        System.out.println("Somme des nombres pairs entre 0 et 100 inclus : " + pair() );
        fibo(0);System.out.println("");
        fibo(1);System.out.println("");
        fibo(10);System.out.println("");
        fibo(15);System.out.println("");
    }

    public static int pair() {
        int somme = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                somme = somme + i;
            }
        }
        return somme;
    }

    public static void fibo(int n) {
        System.out.print("Fibonacci(" + n + ") : ");
        int premier = 0;
        int second = 1;
        int somme = 0;
        if(n < 2) {
            System.out.print(premier + " ");
        }
        if (n == 1) {
            System.out.print(second + " ");
        } else if (n > 1) {
            System.out.print(premier + " ");
            System.out.print(second + " ");
        }
        for (int i = 2; i < n; i++) {
            somme = premier + second;
            System.out.print(somme + " ");
            premier = second;
            second = somme;
        }
    }
}