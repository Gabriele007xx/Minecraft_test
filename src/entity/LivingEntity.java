package entity;

import entity.ai.GoalSelector;
import org.jsfml.graphics.Texture;
import world.Level;

public abstract class LivingEntity extends Entity{
    protected GoalSelector goals = new GoalSelector();
    public LivingEntity(Level level, Texture texture) {
        super(level,texture);
    }
    protected void registerGoals()
    {

    }

}
