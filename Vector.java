public class Vector {

    private double x;
    private double y;
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double x() {
        return x;
    }
    
    public double y() {
        return y;
    }

    public Vector add(Vector v) {
        this.x = (this.x + v.x);
        this.y = (this.y + v.y);
        Vector addedVector = new Vector(this.x, this.y);
        return addedVector;
        /* Find way to add without creating a new vector */
    }

    public Vector scale(double magnitude) {
        this.x = (this.x * magnitude);
        this.y = (this.y * magnitude);
        Vector scaledVector = new Vector(this.x, this.y);
        return scaledVector;
        /* Find way to add without creating a new vector */
    }

}
