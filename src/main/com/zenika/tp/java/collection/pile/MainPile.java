package main.com.zenika.tp.java.collection.pile;

public class MainPile {

    public static void main(String[] args) {
        System.out.println("Pile par composition");
        PileParComposition pileParComposition = new PileParComposition();
        for (int i = 0; i < 10; i++) {
            pileParComposition.empiler(i);
        }
        while (!pileParComposition.estVide()) {
            System.out.print(pileParComposition.depiler() + " ");
        }

        System.out.println();

        System.out.println("Pile par héritage");
        PileParHeritage pileParHeritage = new PileParHeritage();
        for (int i = 0; i < 10; i++) {
            pileParHeritage.empiler(i);
        }
        while (!pileParHeritage.estVide()) {
            System.out.print(pileParHeritage.depiler() + " ");
        }

    }
}
