package entity;

import entity.ai.FollowEntityGoal;
import entity.player.Player;
import org.jsfml.graphics.Texture;
import phys.AABB;
import world.Level;

public class Zombie extends LivingEntity{
    public Zombie(Level level, Texture texture) {
        super(level, texture);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goals.addGoal(new FollowEntityGoal(this, Player.class));
    }

    @Override
    public void setAABB() {
    aabb = new AABB(16,32);
    }
}
