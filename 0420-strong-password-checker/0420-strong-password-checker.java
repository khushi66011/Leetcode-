class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean lower = false;
        boolean upper = false;
        boolean digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            if (Character.isUpperCase(c)) upper = true;
            if (Character.isDigit(c)) digit = true;
        }

        int missing = 0;
        if (!lower) missing++;
        if (!upper) missing++;
        if (!digit) missing++;

        int replace = 0;
        int one = 0;
        int two = 0;

        for (int i = 0; i < n;) {
            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (len >= 3) {
                replace += len / 3;

                if (len % 3 == 0) {
                    one++;
                } else if (len % 3 == 1) {
                    two++;
                }
            }

            i = j;
        }

        if (n < 6) {
            return Math.max(6 - n, missing);
        }

        if (n <= 20) {
            return Math.max(missing, replace);
        }

        int delete = n - 20;

        // First, use deletions on sequences where len % 3 == 0
        int use = Math.min(delete, one);
        replace -= use;
        delete -= use;

        // Then, use 2 deletions on sequences where len % 3 == 1
        use = Math.min(delete, two * 2);
        replace -= use / 2;
        delete -= use;

        // Remaining deletions reduce replacements every 3 deletions
        replace -= delete / 3;

        return (n - 20) + Math.max(missing, replace);
    }
}