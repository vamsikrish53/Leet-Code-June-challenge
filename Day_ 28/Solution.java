// https://leetcode.com/problems/reconstruct-itinerary/

class Solution {    
    Map<String,PriorityQueue<String>> destinations = new HashMap<>();
    List<String> paths = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {        
        for(List<String> ticket : tickets) {            
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            if(destinations.containsKey(from)) {
                destinations.get(from).add(to);
            } else {
                PriorityQueue<String> destionationsList = new PriorityQueue<>();
                destionationsList.add(to);
                destinations.put(from,destionationsList);
            }
        }
        
        dfs("JFK");
        return paths;
    }
    
    private void dfs(String startingPoint) {
        PriorityQueue<String> arrivals =  destinations.get(startingPoint);        
        while(arrivals !=null && !arrivals.isEmpty()) {
        dfs(arrivals.poll());
        }
        paths.add(0,startingPoint);
    }
}
