import java.util.*;

class Solution {
    private class Node{
        char ch;
        Set<Node> neighbors;
        Node(char ch){
          this.ch = ch;
          this.neighbors = new HashSet<>();
        }
        @Override
        public String toString(){
          return "[char:"+ ch +", neighbors:"+ neighbors.toString()+"]\n";
        }
    }
    public String foreignDictionary(String[] words) {
      Set<Node> graph = new HashSet<>();
      Map<Character, Node> map = new HashMap<>();
      String u;
      String v;
      // BUG FIX #1: Loop only through consecutive pairs (i to i+1)
      // Original had: for(int i=0; i< words.length; i++) with ternary operator 
      // if(i+1>=words.length) assigning words[i], causing comparison of word with itself
      for(int i=0; i< words.length-1; i++){
        u = words[i];
        v = words[i+1];
        // BUG FIX #2: Check if u is a PREFIX of v but u is longer (invalid case)
        // Original used u.contains(v) which checks substring, not prefix
        // Valid ordering: if u is prefix of v, u must come before v
        // Invalid: if u is longer than v and v is a prefix of u
        if(u.startsWith(v) && u.length()>v.length()) return "";
        makeGraph(u,v, map, graph);
      }
      
      // BUG FIX #4: Handle single word or words with no comparisons
      // When only 1 word exists, the loop doesn't execute, so no characters are added
      // Even with multiple words, some characters might only appear in later words
      // All characters must be in the map for topological sort to work correctly
      for(String word : words) {
        for(char ch : word.toCharArray()) {
          if(!map.containsKey(ch)) {
            Node node = new Node(ch);
            graph.add(node);
            map.put(ch, node);
          }
        }
      }
      
      return topoSort(graph, map);
    }
    private void makeGraph( String u, String v, Map<Character, Node> map, Set<Node> graph){
      int i=0;
      for(i=0; i<u.length() && i< v.length();i++ ){
        char ch1= u.charAt(i);
        char ch2 = v.charAt(i);
        Node uNode = map.getOrDefault(ch1, new Node(ch1));
        map.put(ch1, uNode);
        Node vNode = map.getOrDefault(ch2, new Node(ch2));
        map.put(ch2, vNode);
        if(ch1!=ch2){
          uNode.neighbors.add(vNode);
          graph.add(uNode);
          graph.add(vNode);
          // BUG FIX #3: Break after finding first difference
          // Original code continued loop after first difference, extracting multiple edges
          // Example: "rftt" vs "te" would incorrectly extract r->t AND f->e
          // This causes cycles: t->f->e->r->t
          // Lexicographic order only uses the FIRST differing character
          break;
        }
      }
    }

    private String topoSort(Set<Node> graph, Map<Character, Node> map){
      // System.out.println(graph);
      // System.out.println(graph.size());
      int indegree[] = new int[26];
            StringBuilder ans = new StringBuilder();
      for(Node node: graph){
        for(Node neigh: node.neighbors){
          indegree[neigh.ch - 'a'] +=1;
        }
      }
      // System.out.println(Arrays.toString(indegree));
      Queue<Node> q = new LinkedList<>();
      for(char nodeKey: map.keySet() ){
        if(indegree[nodeKey - 'a'] == 0){
          // System.out.print(nodeKey+" ");
          q.offer(map.get(nodeKey));
        }
      }
      // System.out.println(q.size());
      while(q.isEmpty() == false){
        Node node = q.poll();
        // System.out.println("node: "+node.ch+" queue: "+q.size());
        ans.append(node.ch);
        for(Node neigh: node.neighbors){
          char neighCh = neigh.ch;
          // System.out.println("node: "+ node.ch+" neighbor: "+neighCh);
          if((--indegree[neighCh - 'a']) == 0){
            // System.out.println("--adding: "+neighCh);
            q.offer(neigh);
          }
        }
      }
      return ans.length()==map.size()?ans.toString():"";
    }
}
