package arrays.basic;

public class IntToBinary {

    public static void main(String[] args) {
         manualConversion();
         builtInJava();
    }

    static String manualConversion() {
        int num = 25;
        StringBuilder binary = new StringBuilder();

        int n = num;
        while (n > 0) {
            int remainder = n % 2;
            binary.insert(0, remainder);  // prepend remainder
            n = n / 2;
        }

        System.out.println("Integer: " + num);
        System.out.println("Binary: " + binary.toString());
        return binary.toString();
    }

    static String builtInJava(){
            int num = 25;

            // Convert integer to binary string
            String binary = Integer.toBinaryString(num);

            System.out.println("Integer: " + num);
            System.out.println("Binary: " + binary);
            return binary;
    }

}
