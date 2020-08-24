package kickstart.k2018.C;

import java.util.*;

public class C1 {

  public static void solve(Scanner s) {
    int n = s.nextInt();
    int[] degree = new int[n+1];
    Arrays.fill(degree, 0);
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = s.nextInt();
      int y = s.nextInt();

      List<Integer> tx;
      if (graph.containsKey(x)) tx = graph.get(x);
      else tx = new ArrayList<>();
      tx.add(y);
      graph.put(x, tx);

      List<Integer> ty;
      if (graph.containsKey(y)) ty = graph.get(y);
      else ty = new ArrayList<>();
      ty.add(x);
      graph.put(y, ty);

      degree[x] += 1;
      degree[y] += 1;
    }

    // 1. get the circle
    while(true) {
      boolean ends = true;
      for (int i = 1; i < n+1; i++) {
        if (degree[i] == 1) {
          ends = false;
          degree[i] = 0;
          List<Integer> nodes = graph.get(i);
          for(Integer node : nodes) {
            if (degree[node] > 0) degree[node] -= 1;
          }
        }
      }
      if (ends) break;
    }

    // 2. bfs
    int[] results = new int[n+1];
    Arrays.fill(results, -1);
    int path = 0;
    List<Integer> circleNodes = new ArrayList<>();
    for (int i = 1; i < n+1; i++) {
      if (degree[i] > 0) {
        circleNodes.add(i);
        results[i] = path;
      }
    }

    List<Integer> extendNodes = circleNodes;
    while(extendNodes.size() > 0) {
      path++;
      List<Integer> newNodes = new ArrayList<>();
      for(Integer node : extendNodes) {
        List<Integer> ns = graph.get(node);
        for(Integer nn : ns) {
          if (results[nn] < 0) {
            results[nn] = path;
            newNodes.add(nn);
          }
        }
      }
      extendNodes = newNodes;
    }

    for (int i = 1; i < n+1; i++) {
      int out = results[i];
      if (i < n) System.out.print(out + " ");
      else System.out.println(out);
    }

  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      System.out.print(String.format("Case #%d: ", i));
      C1.solve(s);
    }
  }
}
