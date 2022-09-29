package entity.player;

import entity.LivingEntity;
import org.jsfml.graphics.Texture;
import phys.AABB;
import world.Level;

public class Player extends LivingEntity {
    public Player(Level level, Texture texture) {
        super(level, texture);
    }

    @Override
    public void setAABB() {
    aabb = new AABB(16,32);
    }
}
