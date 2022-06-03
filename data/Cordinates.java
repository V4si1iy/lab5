package data;

public class Cordinates {
    private int x;
    private double y;

    public Cordinates(int x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y-coordinate.
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }

    @Override
    public int hashCode() {
        return (int) y +  x;
   }

   @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj instanceof Cordinates) {
          Cordinates coordinatesObj = (Cordinates) obj;
           return (x == coordinatesObj.getX()) && (y == coordinatesObj.getY());
        }
        return false;
    }
}
