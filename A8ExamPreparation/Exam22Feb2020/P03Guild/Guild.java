package A8ExamPreparation.Exam22Feb2020.P03Guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    public String name;
    public int capacity;
    public List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        Player player = this.roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);

        if (player != null) {
            this.roster.remove(player);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        this.roster.stream()
                .filter(player1 -> player1.getName().equals(name))
                .findFirst()
                .ifPresent(player -> player.setRank("Member"));
    }

    public void demotePlayer(String name) {
        this.roster.stream()
                .filter(player1 -> player1.getName().equals(name))
                .findFirst()
                .ifPresent(player -> player.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] kicked = this.roster
                .stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);

        this.roster.removeAll(List.of(kicked));

        return kicked;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Players in the guild: %s:", this.name)).append(System.lineSeparator());
        this.roster.forEach(player -> sb.append(player).append(System.lineSeparator()));

        return sb.toString().trim();
    }


}
