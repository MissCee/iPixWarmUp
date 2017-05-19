package ch.fhnw.edu.ivis.ipix.step_2;

public final class Pixel {

    public static final Pixel NONE = new Pixel(Double.NaN, Double.NaN, Double.NaN);

    private final double x;
    private final double y;
    private final double brightness;

    public Pixel(double x, double y, double brightness) {
        this.x = x;
        this.y = y;
        this.brightness = brightness;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getBrightness() {
        return brightness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pixel pixel = (Pixel) o;

        if (Double.compare(pixel.x, x) != 0) return false;
        if (Double.compare(pixel.y, y) != 0) return false;
        return Double.compare(pixel.brightness, brightness) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(brightness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
