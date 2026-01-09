package com.zenika.tp.java.pattern.template;

public class ClasseConcrete extends ClasseAbstraite {
    @Override
    protected void operation1() {
        System.out.println("ClassConcrete - Operation 1");
    }

    @Override
    protected void operation2() {
        System.out.println("ClassConcrete - Operation 2");
    }
}
