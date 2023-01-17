public class PowerOfN {

    /***
     * 
     * 2^5 = 2^1 2^4
     * 2^4 = (2*2)^2
     * 4^2 = (2*2)^1
     * 2= (2*1)^0
     * 
     * @param args
     */
    public static void main(String[] args) {

        System.out.print(pow(2.0,3));
    }

    public static double pow(double givenNumber, int power) {

        boolean isPowerNegative = power < 0;
        if (isPowerNegative) {
            power *= -1;
        }
        double answer = 1;
        double dynamicPower = power;

        while (dynamicPower > 0) {

            if (dynamicPower % 2 == 1) {
                answer = answer * givenNumber;
                dynamicPower -= 1;
            } else {
                givenNumber = givenNumber * givenNumber;
                dynamicPower /= 2;
            }
        }

        if (isPowerNegative) {
            answer = (1.0) / answer;
        }
        return answer;

    }
}
