package com.zenika.tp.java.visibilite.package2;

import com.zenika.tp.java.visibilite.package1.ClassA;

public class ClassC extends ClassA {

    public void test() {
        ClassC a = new ClassC();
        // a.attributPackage = "testPackage"; // non visible par ClassC
        a.attributPublic = "testPublic";
        a.attributProtected = "testProtected";
        // a.attributPrivate = "testPrivate"; // non visible par ClassC
    }
}
