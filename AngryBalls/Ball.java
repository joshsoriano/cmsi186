public class Ball {

    private double radius;
    private Vector location;
    private Vector initialVelocity;

    public Ball(double radius, Vector location, Vector initialVelocity) {
        this.radius = radius;
        this.location = location;
        this.initialVelocity = initialVelocity;
    }

    public Vector getLocation() {
        return location;
    }

    public Vector getInitialVelocity() {
        return initialVelocity;
    }

    public double getRadius() {
        return radius;
    }
    
    public void accelerate(Vector acceleration, double grain) {
        this.initialVelocity.add(acceleration.scale(grain)); 
    }

    public void move(double grain) {
        this.location.add(initialVelocity.scale(grain));
    }

    public boolean collides(Ball ball) {
        return ((Math.abs(this.getLocation().x() - ball.getLocation().x())) + (Math.abs(this.getLocation().y() - ball.getLocation().y()))) <= (this.getRadius() + ball.getRadius());
    }
}
