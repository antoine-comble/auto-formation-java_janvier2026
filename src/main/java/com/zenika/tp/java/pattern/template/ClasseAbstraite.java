package main.com.zenika.tp.java.pattern.template;

public abstract class ClasseAbstraite {
    public final void methodeTemplate() {
        operation1();
        operation2();
        operation3();
    }

    protected abstract void operation1();

    protected void operation2(){
        System.out.println("ClassAbstraite - Operation 2");
    }

    private void operation3() {
        System.out.println("ClassAbstraite - Operation 3");
    }

}
