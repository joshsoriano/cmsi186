public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_VectorCreation();

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
    }
}
