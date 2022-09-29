package entity;

import org.jsfml.graphics.Texture;
import world.Level;

public abstract class LivingEntity extends Entity{

    public LivingEntity(Level level, Texture texture) {
        super(level,texture);
    }

}
