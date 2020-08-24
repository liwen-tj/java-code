package dynamic_programmming;

import java.util.*;

public class Projects {
    public static int find(List<List<Long>> dayRewards, long target) {
        int low = 0;
        int hig = dayRewards.size() - 1;
        while (low <= hig) {
            int mid = (low + hig) / 2;
            if (dayRewards.get(mid).get(0) < target) low++;
            else hig--;
        }
        return hig;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<List<Long>> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Long> item = new ArrayList<>();
            for (int j = 0; j < 3; j++) item.add(s.nextLong());
            items.add(item);
        }
        items.sort(Comparator.comparingLong(o -> o.get(1)));

        List<List<Long>> maxRewards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Long> item = items.get(i);
            if (maxRewards.isEmpty()) maxRewards.add(Arrays.asList(item.get(1), item.get(2)));
            else {
                int id = Projects.find(maxRewards, item.get(0));
                List<Long> last = maxRewards.get(maxRewards.size() - 1);
                if (id < 0) {
                    if (last.get(1) < item.get(2)) maxRewards.add(Arrays.asList(item.get(1), item.get(2)));
                } else {
                    long tmp = maxRewards.get(id).get(1) + item.get(2);
                    if (last.get(1) < tmp) maxRewards.add(Arrays.asList(item.get(1), tmp));
                }
            }
        }

        long res = maxRewards.get(maxRewards.size() - 1).get(1);
        System.out.println(res);
    }
}

//#include <bits/stdc++.h>
//    using namespace std;
//
//    struct activity {
//    long startDay;
//    long endDay;
//    long reward;
//    };
//
//    bool compare(activity a, activity b) {
//    return a.endDay < b.endDay;
//    }
//
//    int findTarget(vector<activity> maxRewards, long target) {
//    int low = 0;
//    int hig = maxRewards.size() - 1;
//    while (low <= hig) {
//    int mid = (low + hig) / 2;
//    if (maxRewards.at(mid).endDay < target) low++;
//    else hig--;
//    }
//    return hig;
//    }
//
//    int main()
//    {
//    int n;
//    cin >> n;
//    activity arr[n];
//    for(int i = 0; i < n; ++i) cin >> arr[i].startDay >> arr[i].endDay >> arr[i].reward;
//    sort(arr, arr + n, compare);
//
//    vector<activity> maxRewards;
//    maxRewards.push_back(arr[0]);
//    for(int i = 1; i < n; ++i) {
//    int id = findTarget(maxRewards, arr[i].startDay);
//    long lastReward = maxRewards.at(maxRewards.size() - 1).reward;
//    if (id >= 0) {
//    long tmp = maxRewards.at(id).reward + arr[i].reward;
//    if (tmp > lastReward) {
//    arr[i].reward = tmp;
//    maxRewards.push_back(arr[i]);
//    }
//    }
//    else if (arr[i].reward > lastReward) maxRewards.push_back(arr[i]);
//    }
//
//    long ans = maxRewards.at(maxRewards.size() - 1).reward;
//    cout << ans << endl;
//    return 0;
//    }
