package entity;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import phys.AABB;
import world.Level;

public abstract class Entity {
    public Level level;
    /**
     * AABB Collision for the entity.
     */
    protected AABB aabb;
    protected Texture texture = new Texture();
    protected Sprite sprite = new Sprite();
    protected int HURT_COOLDOWN = 25;
    protected int CURENT_HURTING_COOLDOWN = 0;
    public Entity(Level level, Texture texture)
    {
        this.level = level;
        this.texture = texture;
        this.sprite.setTexture(this.texture);
        sprite.setOrigin(new Vector2f(this.texture.getSize().x / 2f,this.texture.getSize().y / 2f));
        this.setAABB();
    }
    public abstract void setAABB();
    public float getX()
    {
        return this.sprite.getPosition().x;
    }
    public float getY()
    {
        return this.sprite.getPosition().y;
    }

    /**
     * Called every tick
     */
    public void tick()
    {
        aabb.Update(this);
    }
    public void setLocation(float x,float y)
    {
        this.sprite.setPosition(x,y);
    }

    public Sprite getSprite() {
        return sprite;
    }
    public void render(RenderTarget target)
    {
        target.draw(this.sprite);
    }

    public AABB getAABB() {
        return aabb;
    }

    public double DistanceTo(Entity e1,Entity e2)
    {
        return Math.sqrt(Math.pow(e2.getX() - e1.getX(), 2) + Math.pow(e2.getY() - e1.getY(),2));
    }
}
