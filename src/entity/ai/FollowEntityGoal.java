package entity.ai;

import entity.LivingEntity;

public class FollowEntityGoal extends Goal {
    private LivingEntity entity;
    private LivingEntity target;

    private final Class targetType;
    public FollowEntityGoal(LivingEntity entity, Class entityToFollow)
    {
        this.entity = entity;
        this.targetType = entityToFollow;
    }
    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean canContinueToUse() {

        return entity.DistanceTo(entity, target) <= 32*32;
    }

    @Override
    public void tick() {
        super.tick();

    }
    private void FindTarget()
    {

    }
}
