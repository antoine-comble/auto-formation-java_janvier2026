package com.zenika.tp.java.visibilite.package1;

public class ClassA {
    public String attributPublic;
    private String attributPrivate;
    protected String attributProtected;
    String attributPackage;

    public void test() {
        ClassA a = new ClassA();
        a.attributPackage = "testPackage";
        a.attributPublic = "testPublic";
        a.attributProtected = "testProtected";
        a.attributPrivate = "testPrivate";
    }
}
