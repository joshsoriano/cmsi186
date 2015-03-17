public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_VectorCreation();
        test_Scale();
        test_BallCreation();
        test_Move();


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

        Vector a = new Vector(5.0, 8.0);
        Vector b = new Vector(10.0, 12.0);

        try {
            displaySuccessIfTrue(a.x() == 5.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(a.y() == 8.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(b.x() == 10.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(b.y() == 12.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(5.0, 8.0);
        b = new Vector(10.0, 12.0);

        try {
            displaySuccessIfTrue(a.add(b).x() == 15.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(5.0, 8.0);
        b = new Vector(10.0, 12.0);

        try {
            displaySuccessIfTrue(a.add(b).y() == 20.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(6.5, 2.5);
        b = new Vector(12.5, 13.5);

        try {
            displaySuccessIfTrue(b.add(a).x() == 19.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(b.y() == 16.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        a = new Vector(0.0, 0.0);
        b = new Vector(0.0, -9.8);

        try {
            displaySuccessIfTrue(b.add(a).x() == 0.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(b.y() == -9.8);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    public static void test_Scale() {
        System.out.println("Testing scale method...");

        Vector v = new Vector(2.0, 3.0);

        try {
            displaySuccessIfTrue(v.scale(2).x() == 4.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        v = new Vector (2.0, 3.0);

        try {
            displaySuccessIfTrue(v.scale(2).y() == 6.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    public static void test_BallCreation() {
        System.out.println("Testing Ball Constructor, getRadius, and getLocation...");

        Ball c = new Ball(5.0, new Vector(0.0, 1.0), new Vector(5.0, 5.0));

        try {
            displaySuccessIfTrue(c.getRadius() == 5.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

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
    }

    public static void test_Move() {
        System.out.println("Testing move method...");

        Vector location = new Vector(0.0, 0.0);
        Vector initialVelocity = new Vector (20.0, 30.0);
        Vector acceleration = new Vector (0.0, -9.8);
        Ball c = new Ball(5.0, location, initialVelocity);

        c.accelerate(acceleration, 1.0);
        c.move(1.0);

        try {
            displaySuccessIfTrue(c.getLocation().x() == 20.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(c.getLocation().y() == 20.2);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }
    }
}
