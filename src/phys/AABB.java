package phys;

public class AABB {
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    public AABB(double x, double y)
    {
        this.minX -= x;
        this.maxX += x;
        this.minY -= y;
        this.maxY += y;
    }
    public boolean intersects(AABB box)
    {
        return this.minX <= box.maxX && this.maxX >= box.minX && this.minY <= box.maxY && this.maxY >= box.minY;
    }
    public boolean intersects(Vec2 vec2)
    {
        return vec2.x() >= this.minX && vec2.x() <= this.maxX && vec2.y() >= this.minY && vec2.y() <= this.maxY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }
}
