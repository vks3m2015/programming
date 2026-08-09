public class ReverseNumber {

    //https://leetcode.com/problems/reverse-integer/
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("  reverse Number == " + reverseNumber(12345));

    }

    public static int reverseNumber(int num) {
        int reverseNum = 0;

        while (num != 0) {
            int lastDigit = num % 10;

            // Check for overflow/underflow before updating ans
            if ((reverseNum > Integer.MAX_VALUE / 10) || (reverseNum < Integer.MIN_VALUE / 10)) {
                return 0; // Return 0 if reversing x would cause overflow/underflow
            }

            reverseNum = reverseNum * 10 + lastDigit;
            num = num / 10;
        }
        return reverseNum;
    }

    public static int reverse(int x) {
        long rev = 0;

        for (int num = x; num != 0; num /= 10) {
            rev = rev * 10 + num % 10;
        }


        if (rev <= Integer.MIN_VALUE || rev >= Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) rev;
        }

    }
}