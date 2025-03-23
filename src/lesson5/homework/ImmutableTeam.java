package lesson5.homework;

import java.util.Set;

public class ImmutableTeam {
    private final String teamName;
    private final Set<ImmutablePerson> teamMembers;

    public ImmutableTeam(String teamName, Set<ImmutablePerson> teamMembers) {
        this.teamName = teamName;
        this.teamMembers = Set.copyOf(teamMembers);
    }

    public String getTeamName() {
        return teamName;
    }

    public Set<ImmutablePerson> getTeamMembers() {
        return teamMembers;
    }

    @Override
    public String toString() {
        return "ImmutableTeam{" +
                "teamName='" + teamName + '\'' +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
