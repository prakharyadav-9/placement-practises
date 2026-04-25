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
      for(int i=0; i< words.length; i++){
        u = words[i];
        v = (i+1)>=words.length?words[i]: words[i+1];
        if(u.contains(v) && u.length()>v.length()) return "";
        makeGraph(u,v, map, graph);
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
        }
      }
      handleSingleString(i, u, map,graph);
      handleSingleString(i, v, map,graph);
    }
    private void handleSingleString(int i, String s, Map<Character, Node> map, Set<Node> graph){
      while(i<s.length()){
        char ch1 = s.charAt(i);
        if(map.containsKey(ch1) == false){
          Node node = new Node(ch1);
          graph.add(node);
          map.put(ch1, node);
        }
        i++;
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
