package entity.ai;

import entity.LivingEntity;

public class FollowEntityGoal extends Goal {
    private LivingEntity entity;
    private Class entityToFollow;
    public FollowEntityGoal(LivingEntity entity, Class entityToFollow)
    {
        this.entity = entity;
        this.entityToFollow = entityToFollow;
    }
    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

    }
}
