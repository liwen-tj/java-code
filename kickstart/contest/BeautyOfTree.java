package kickstart.contest;

import java.util.*;

public class BeautyOfTree {
  private static HashMap<Integer, List<Integer>> trees = new HashMap<>();
  private static int[] path = new int[500001];

  private static void dfs(int pid, int height, int A, int[] pp) {
    path[height] = pid;
    if (height > A) pp[pid] = path[height - A];
    if (trees.containsKey(pid)) {
      List<Integer> children = trees.get(pid);
      for(Integer child : children) dfs(child, height + 1, A, pp);
    }
  }

  public static double solve(Scanner s) {
    int n = s.nextInt();
    int a = s.nextInt();
    int b = s.nextInt();
    trees.clear();
    for (int i = 2; i <= n ; i++) {
      int pid = s.nextInt();
      List<Integer> children;
      if (trees.containsKey(pid)) children = trees.get(pid);
      else children = new ArrayList<>();
      children.add(i);
      trees.put(pid, children);
    }
    int[] fa = new int[n+1];
    Arrays.fill(fa, -1);
    int[] fb = new int[n+1];
    Arrays.fill(fb, -1);

    // fa[i]: node_i upwards A steps, reaches node_fa[i]
    dfs(1, 1, a, fa);
    dfs(1, 1, b, fb);
    double[] pa = new double[n+1];
    double[] pb = new double[n+1];

    double ans = 0.0;
    for (int i = n; i >= 1; i--) {
      pa[i] += 1.0 / n;
      pb[i] += 1.0 / n;
      ans += (1 - (1-pa[i])*(1-pb[i]));
      if (fa[i] != -1) pa[fa[i]] += pa[i];
      if (fb[i] != -1) pb[fb[i]] += pb[i];
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      double ans = BeautyOfTree.solve(s);
      System.out.println(String.format("Case #%d: %f", i, ans));
    }
  }

}
