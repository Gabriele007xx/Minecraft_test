package phys;

import entity.Entity;

public class AABB {
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double sizeX;
    private double sizeY;
    public AABB(double x, double y)
    {
        this.sizeX = x;
        this.sizeY = y;

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

    @Override
    public String toString() {
        return "MinX: " + minX + " MaxX: " + maxX + " MinY: " + minY + "MaxY: " + maxY;
    }
    public void Update(Entity entity)
    {
        this.maxX = entity.getX() + sizeX;
        this.maxY = entity.getY() + sizeY;
        this.minX = entity.getX() - sizeX;
        this.minY = entity.getY() - sizeY;
    }

}
