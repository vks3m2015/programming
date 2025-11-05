public class DigitSum {


    public static void main(String[] args) {
       digitSum(12345);
    }


    static void digitSum(int num) {

        int sum = 0;
      while (num  >=  10) {

            sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum = sum + digit;
                num = num / 10;
            }
            System.out.println(" in sum = "+ sum);
            num = sum;
        }
        System.out.println(" sum = "+ sum);
    }
}
