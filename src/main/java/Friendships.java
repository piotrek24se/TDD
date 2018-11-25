import java.util.*;

public class Friendships {

    private final Map<String, List<String>> friendships = new HashMap();

    public void makeFriends(String firstPerson, String secondPerson) {
        addFriend(firstPerson, secondPerson);
        addFriend(secondPerson, firstPerson);
    }

    private void addFriend(String firstPerson, String secondPerson) {
        if (!friendships.containsKey(firstPerson)) {
            friendships.put(firstPerson, new ArrayList());
        }
        friendships.get(firstPerson).add(secondPerson);
    }

    public List<String> getFriends(String person) {
        if (!friendships.containsKey(person))
            return Collections.emptyList(); // to samo co return new ArrayList<>();
        return friendships.get(person);
    }

    public boolean areFriends(String firstPerson, String secondPerson) {
        return friendships.containsKey(firstPerson)
                && friendships.containsKey(secondPerson)
                && friendships.get(firstPerson).contains(secondPerson)
                && friendships.get(secondPerson).contains(firstPerson);
    }
}
