class Solution {

    private long findHours(int[] piles, int speed) {

        long hours = 0;

        for (int bananas : piles) {
            hours += (bananas + speed - 1L) / speed;
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int bananas : piles) {
            high = Math.max(high, bananas);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = findHours(piles, mid);

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}