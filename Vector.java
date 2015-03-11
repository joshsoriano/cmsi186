public class Vector {

    public double x;
    public double y;

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
        this.x = this.x + v.x;
        this.y = this.y + v.y;
        Vector sum = new Vector(this.x, this.y);
        return sum;
    }

    public Vector scale(double magnitude) {
        this.x = this.x * magnitude;
        this.y = this.y * magnitude;
        Vector vectorScaled = new Vector(this.x, this.y);
        return vectorScaled;
    }
}
