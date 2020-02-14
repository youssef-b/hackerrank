package contest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/contests/w37/challenges/two-efficient-teams/problem
 */
public class TwoEfficientTeams {

    // Complete the maximumEfficiency function below.
    public static final String SEP = ":";
    private static final Scanner scanner = new Scanner(System.in);

    static class Group {
        long efficiency;
        public List<String> members = new ArrayList<>();

        public Group(long efficiency) {
            this.efficiency = efficiency;
        }

    }

    static long maximumEfficiency(int n, int m) {

        List<Group> groups = new ArrayList<>();
        Map<String, Long> memo = new HashMap<>();

        for (int i = 1; i <= m; i++) {
            int membersCount = scanner.nextInt();
            long efficiency = scanner.nextLong();
            Group group = new Group(efficiency);
            for (int j = 0; j < membersCount; j++) {
                int member = scanner.nextInt();
                group.members.add("" + member);
            }
            groups.add(group);

        }

        return maxEfficiency(groups, memo, n, 1, "", "");

    }

    private static long maxEfficiency(List<Group> groups, Map<String, Long> memo, int totalEmployees, int employee, String team1, String team2) {

        String keyTeam1 = getKeyTeam(team1);
        String keyTeam2 = getKeyTeam(team2);
        String key1 = keyTeam1 + ";" + keyTeam2;
        String key2 = keyTeam2 + ";" + keyTeam1;
        if (memo.get(key1) != null) {
            return memo.get(key1);
        } else if (memo.get(key2) != null) {
            return memo.get(key2);
        } else if (employee > totalEmployees && (team1.isEmpty() || team2.isEmpty())) {
            memo.put(key1, -1l);
            return -1;
        } else if (employee > totalEmployees) {

            List<String> lTeam1 = Arrays.asList(team1.split(SEP));
            List<String> lTeam2 = Arrays.asList(team2.split(SEP));
            long efficiency = 0;
            for (Group group : groups) {
                if (lTeam1.containsAll(group.members)) {
                    efficiency += group.efficiency;
                } else if (lTeam2.containsAll(group.members)) {
                    efficiency += group.efficiency;
                }
            }
            memo.put(key1, efficiency);
            return efficiency;

        } else {
            int nextEmployee = employee + 1;
            String nexTeam1 = new StringBuilder(team1).append(SEP).append(employee).toString();
            String nexTeam2 = new StringBuilder(team2).append(SEP).append(employee).toString();
            long efficiency = Math.max(maxEfficiency(groups, memo, totalEmployees, nextEmployee, nexTeam1, team2),
                    maxEfficiency(groups, memo, totalEmployees, nextEmployee, team1, nexTeam2));
            memo.put(key1, efficiency);
            return efficiency;
        }

    }

    private static String getKeyTeam(String team) {
        String[] teamArr = team.split(SEP);
        Arrays.sort(teamArr);
        return Arrays.stream(teamArr).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {


        int n = scanner.nextInt();

        int m = scanner.nextInt();

        long result = maximumEfficiency(n, m);

        System.out.println(result);


        scanner.close();
    }
}
