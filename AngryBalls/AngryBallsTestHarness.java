public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_VectorCreation();
        test_Scale();
        test_BallCreation();
        test_AccelerateAndMove();
        test_Simulation();


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

        Vector location = new Vector(0.0, 0.0);
        Vector initialVelocity = new Vector (20.0, 30.0);
        Vector acceleration = new Vector (0.0, -9.8);
        Ball ball = new Ball(5.0, location, initialVelocity);


        try {
            displaySuccessIfTrue(ball.getRadius() == 5.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(ball.getLocation().x() == 0.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(ball.getLocation().y() == 0.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    public static void test_AccelerateAndMove() {
        System.out.println("Testing accelerate and move method...");

        Vector location = new Vector(0.0, 0.0);
        Vector initialVelocity = new Vector (20.0, 30.0);
        Vector acceleration = new Vector (0.0, -9.8);
        Ball ball = new Ball(5.0, location, initialVelocity);

        ball.accelerate(acceleration, 1.0);
        ball.move(1.0);

        try {
            displaySuccessIfTrue(ball.getLocation().x() == 20.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(ball.getLocation().y() == 20.2);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }
    }

    public static void test_Simulation() {

        /* NON-COLLIDING BALLS TEST*/
        Double redBallRadius = 10.0;
        Vector redBallLocation = new Vector(0.0, 1.0);
        Vector redBallInitialVelocity = new Vector(50.0, 50.0);
        Ball redBall = new Ball(redBallRadius, redBallLocation, redBallInitialVelocity);

        Double blueBallRadius = 10.0;
        Vector blueBallLocation = new Vector(1280.0, 1.0);
        Vector blueBallInitialVelocity = new Vector(-50.0, 50.0);
        Ball blueBall = new Ball(blueBallRadius, blueBallLocation, blueBallInitialVelocity);
        
        Double grain = 1.0;
        Vector acceleration = new Vector(0, -9.8);

        double numberOfCollides = 0;
        double timeStamp = -1;
        double time = 0;
        Vector redBallTimeStamp = new Vector(0, 0);
        Vector blueBallTimeStamp = new Vector(0, 0);

        while ((redBall.getLocation().y() > 0) || (blueBall.getLocation().y() > 0)) {
            
            if (redBall.collides(blueBall) && numberOfCollides == 0) {
                redBallTimeStamp.x = redBall.getLocation().x();
                redBallTimeStamp.y = redBall.getLocation().y();
                blueBallTimeStamp.x = blueBall.getLocation().x();
                blueBallTimeStamp.y = blueBall.getLocation().y();
                timeStamp = time;
                numberOfCollides += 1;
            }
            
            if (redBall.getLocation().y() > 0) {
                redBall.move(grain);
                redBall.accelerate(acceleration, grain);
            }

            if (blueBall.getLocation().y() > 0) {
                blueBall.move(grain);
                blueBall.accelerate(acceleration, grain);
            }
            time += grain;
        }

        System.out.println("Testing non-colliding balls [SIMULATION]...");

        try {
            displaySuccessIfTrue(numberOfCollides == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        /* COLLIDING BALLS TEST */
        redBallRadius = 5.0;
        redBallLocation = new Vector(0.0, 1.0);
        redBallInitialVelocity = new Vector(80.0, 50.0);
        redBall = new Ball(redBallRadius, redBallLocation, redBallInitialVelocity);

        blueBallRadius = 5.0;
        blueBallLocation = new Vector(1280.0, 1.0);
        blueBallInitialVelocity = new Vector(-80.0, 50.0);
        blueBall = new Ball(blueBallRadius, blueBallLocation, blueBallInitialVelocity);
        
        grain = 1.0;
        acceleration = new Vector(0, -9.8);

        numberOfCollides = 0;
        timeStamp = -1;
        time = 0;
        redBallTimeStamp = new Vector(0, 0);
        blueBallTimeStamp = new Vector(0, 0);

        while ((redBall.getLocation().y() > 0) || (blueBall.getLocation().y() > 0)) {
            
            if (redBall.collides(blueBall) && numberOfCollides == 0) {
                redBallTimeStamp.x = redBall.getLocation().x();
                redBallTimeStamp.y = redBall.getLocation().y();
                blueBallTimeStamp.x = blueBall.getLocation().x();
                blueBallTimeStamp.y = blueBall.getLocation().y();
                timeStamp = time;
                numberOfCollides += 1;
            }
            
            if (redBall.getLocation().y() > 0) {
                redBall.move(grain);
                redBall.accelerate(acceleration, grain);
            }

            if (blueBall.getLocation().y() > 0) {
                blueBall.move(grain);
                blueBall.accelerate(acceleration, grain);
            }
            time += grain;
        }

        System.out.println("Testing colliding balls [SIMULATION]...");

        try {
            displaySuccessIfTrue(numberOfCollides > 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(timeStamp == 8.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(redBallTimeStamp.x() == 640.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(redBallTimeStamp.y() == 126.60000000000002);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(blueBallTimeStamp.x() == 640.0);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }

        try {
            displaySuccessIfTrue(blueBallTimeStamp.y() == 126.60000000000002);
        } catch(Exception e) {
            displaySuccessIfTrue(false); 
        }
    }
}
