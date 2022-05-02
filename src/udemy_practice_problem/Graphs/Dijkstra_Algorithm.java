package udemy_practice_problem.Graphs;

import java.util.*;

public class Dijkstra_Algorithm {
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    public static void main(String[] args) {

        int[][] input = new int[][] {{2,1,1}, {2,3,1}, {3,4,1}};

        int result = networkDelayTime(input, 4, 2);


        System.out.println(result);

    }

    static public int networkDelayTime(int[][] times, int k, int n) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((a) -> a[1]));
        int[] minTimes = new int[k+1];
        buildGraph(times);
        Arrays.fill(minTimes, Integer.MAX_VALUE);

        q.add(new int[]{n,0});
        minTimes[n]=0;
        while(!q.isEmpty()) {

            int[] curr = q.poll();
            int currNode = curr[0];
            int currTime = curr[1];

            if(minTimes[currNode] >= currTime) {
                if(graph.containsKey(currNode)) {
                    for(int[] pair: graph.get(currNode)) {
                        //     minTimes[pair[0]] = Math.min(minTimes[pair[0]], minTimes[pair[0]]);
                        if(minTimes[pair[0]] >= minTimes[currNode] + pair[1]) {
                            minTimes[pair[0]] = minTimes[currNode]+ pair[1];
                            q.add(new int[]{pair[0], minTimes[pair[0]]});
                        }
                    }
                }
            }
        }

        int time = Integer.MIN_VALUE;
        for(int i=1;i<=k;i++) {
            time = Math.max(time, minTimes[i]);
        }


        return time == Integer.MAX_VALUE ? -1: time;
    }

    static void buildGraph(int[][] times) {
        for(int[] i: times) {
           // graph.computeIfAbsent(i[0], new ArrayList<int[]>().add(new int[] {i[1], i[2]}));
            if(!graph.containsKey(i[0])) {
                graph.put(i[0], new ArrayList<>());
            }

            List<int[]> list = graph.get(i[0]);

            list.add(new int[]{i[1], i[2]});
        }
    }
}
