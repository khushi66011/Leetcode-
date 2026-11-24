class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights,
                          int src, int dst, int k) {

        vector<int> res(n, 1e9);

        res[src] = 0;

        for (int i = 0; i <= k; i++) {

            vector<int> temp = res;

            for (int j = 0; j < flights.size(); j++) {

                int u = flights[j][0];
                int v = flights[j][1];
                int wt = flights[j][2];

                if (res[u] != 1e9 &&
                    res[u] + wt < temp[v]) {

                    temp[v] = res[u] + wt;
                }
            }

            res = temp;
        }

        if (res[dst] == 1e9) {
            return -1;
        }

        return res[dst];
    }
};
