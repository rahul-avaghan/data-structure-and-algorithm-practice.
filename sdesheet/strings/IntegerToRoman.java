public class IntegerToRoman {

    public static void main(String[] args) {
        int givenNumber = 1400;
        Integer[] numbers = { 1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1 };

        String[] letters = { "M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I" };

        String[][] mapping = new String[numbers.length][letters.length];
        for (int i = 0; i < numbers.length; i++) {
            String[] arr = { letters[i], numbers[i].toString() };
            mapping[i] = arr;
        }

        int count = 0;
        String romanNumber = "";
        for (int i = 0; i < mapping.length; i++) {

            Integer number = Integer.valueOf(mapping[i][1]);
            String value = mapping[i][0];

            count = givenNumber / number;
            if (count > 0) {
                while (count > 0) {
                    romanNumber += value;
                    count--;
                }
                givenNumber = givenNumber % number;
            }
            if (givenNumber == 0) {
                break;
            }
        }

        System.out.println("Converted number is " + romanNumber);

    }
}
