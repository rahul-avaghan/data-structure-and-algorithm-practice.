public class NaturalNumber {

    public static void main(String[] args) {

        System.out.println(naturalNumberSum(1));

    }

    public static Integer naturalNumberSum(Integer input) {

        if (input == 1) {
            return input;
        }
        return naturalNumberSum(input - 1) + input;
    }
}

// n(2) -> n(1,0) -> 1