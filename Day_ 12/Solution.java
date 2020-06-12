// https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {

    List<Integer> numsArray;
    Map<Integer,Integer> numsMap;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.numsArray = new ArrayList<Integer>();
        this.numsMap = new HashMap<Integer,Integer>();
        this.random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(numsMap.containsKey(val))
            return false;
        numsMap.put(val,numsArray.size());
        numsArray.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!numsMap.containsKey(val))
            return false;
        int numsSize = numsArray.size();
        int index = numsMap.get(val);
        if(index < numsSize - 1) { // If the current element it not last one then swap it
            int lastElement = numsArray.get(numsSize - 1);
            numsArray.set(index,lastElement);
            numsMap.put(lastElement,index);
        }
        
        numsMap.remove(val);
        numsArray.remove(numsSize - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numsArray.get(random.nextInt(numsArray.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
