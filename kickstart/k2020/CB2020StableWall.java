package kickstart.k2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CB2020StableWall {

  public static void solve(int T, Scanner s) {
    int r = s.nextInt();
    int c = s.nextInt();
    char[][] arr = new char[r][c];
    HashMap<Character, List<Character>> dep = new HashMap<>();
    for (int i = 0; i < r; i++) {
      arr[i] = s.next().toCharArray();
      for (int j = 0; j < c; j++) {
        if (!dep.containsKey(arr[i][j])) {
          dep.put(arr[i][j], new ArrayList<>());
        }
      }
    }


    for (int i = 0; i < r - 1; i++) {
      for (int j = 0; j < c; j++) {
        char u = arr[i][j];
        char d = arr[i+1][j];
        if (u != d && !dep.get(u).contains(d)) {
          List<Character> v = dep.get(u);
          v.add(d);
          dep.put(u, v);
        }
      }
    }

    List<Character> ans = new ArrayList<>();
    while(true) {
      boolean has = false;
      for(Character ks : dep.keySet()) {
        if (ans.contains(ks)) continue;
        List<Character> v = dep.get(ks);
        boolean empty = true;
        for (Character ch : v) {
          if (!ans.contains(ch)) {
            empty = false;
            break;
          }
        }
        if (empty) {
          ans.add(ks);
          has = true;
        }
      }
      if (!has) break;
    }

    if (ans.size() != dep.keySet().size()) {
      System.out.println(String.format("Case #%d: -1", T));
    } else {
      System.out.println(String.format("Case #%d: %s", T, ans.stream().map(String::valueOf).collect(Collectors.joining())));
    }

  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 1; i <= T; i++) {
      CB2020StableWall.solve(i, s);
    }
  }
}
