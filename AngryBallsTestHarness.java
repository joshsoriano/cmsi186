public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_VectorCreation();
        test_BallCreation();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_VectorCreation() {
        System.out.println("Testing Vector Constructors...");

        /* x() and y() Testing */

        Vector a = new Vector(5, 8);
        Vector b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(a.x() == 5);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(a.y() == 8);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(b.x() == 10);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(b.y() == 12);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        /* Add() Testing */

        a = new Vector(5, 8);
        b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(a.add(b).x() == 15);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(5, 8);
        b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(a.add(b).y() == 20);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(5, 8);
        b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(b.add(a).x() == 15);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(5, 8);
        b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(b.add(a).y() == 20);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        /* Scale() Testing */

        a = new Vector(5, 5);

        try {
            displaySuccessIfTrue(a.scale(2).x() == 10);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(5, 5);
        
        try {
            displaySuccessIfTrue(a.scale(2).y() == 10);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(b.scale(2).x() == 20);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b = new Vector(10, 12);

        try {
            displaySuccessIfTrue(b.scale(2).y() == 24);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    public static void test_BallCreation() {
        System.out.println("Testing Ball Constructors...");

        Ball c = new Ball(5.0, new Vector(0.0, 1.0), new Vector(5.0, 5.0)) ;

        /* getRadius() Test */

        try {
            displaySuccessIfTrue(c.getRadius() == 5.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        /* getLocation() Test */

        try {
            displaySuccessIfTrue(c.getLocation().x() == 0.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(c.getLocation().y() == 1.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        c.move(1);

        try {
            displaySuccessIfTrue(c.getLocation().x() == 5.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(c.getLocation().y() == 6.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }



    }
}
