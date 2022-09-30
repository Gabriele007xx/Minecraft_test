package entity.ai;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GoalSelector {
    private final Set<Goal> goals = new HashSet<>();
    public GoalSelector()
    {

    }
    public void addGoal(Goal goal)
    {
        this.goals.add(goal);
    }
    public void removeGoals()
    {
        this.goals.clear();
    }
    public void tick()
    {
        Iterator<Goal> iterators = goals.iterator();
        while(iterators.hasNext())
        {
            Goal goal = iterators.next();
            if(goal.canUse())
            {
                goal.start();
                while(goal.canContinueToUse()) {
                    goal.tick();
                }
                goal.stop();
            }
        }
    }
}
