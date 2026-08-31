import java.util.*;

class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);

        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);

        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int removeIndex = map.get(val).iterator().next();

        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        list.set(removeIndex, lastElement);
        map.get(val).remove(removeIndex);
        map.get(lastElement).add(removeIndex);
        map.get(lastElement).remove(lastIndex);
        list.remove(lastIndex);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
