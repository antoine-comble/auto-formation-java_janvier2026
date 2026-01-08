package main.com.zenika.tp.java.collection.pile;

import java.util.logging.Logger;

public class MainPile {

    private static final Logger logger = Logger.getLogger(MainPile.class.getName());

    public static void main(String[] args) {
        logger.info("Pile par composition");
        testPile(new PileParComposition());

        System.out.println();

        System.out.println("Pile par héritage");
        testPile(new PileParHeritage());
    }

    private static void testPile(Pile pileParComposition) {
        for (int i = 0; i < 10; i++) {
            pileParComposition.empiler(i);
        }
        while (!pileParComposition.estVide()) {
            System.out.print(pileParComposition.depiler() + " ");
        }
    }
}
