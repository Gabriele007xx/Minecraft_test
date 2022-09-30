package entity.ai;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
}
