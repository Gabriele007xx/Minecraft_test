package entity;

import org.jsfml.graphics.Texture;
import phys.AABB;
import world.Level;

public class Zombie extends LivingEntity{
    public Zombie(Level level, Texture texture) {
        super(level, texture);
    }

    @Override
    public void setAABB() {
    aabb = new AABB(16,32);
    }
}
