import java.util.ArrayList;
import java.util.Arrays;

public class CompareRevision {

    public static void main(String[] args) {

        String v1 = "0.3.2";
        String v2 = "2.0.4";

        System.out.println(compareVersions(v1,v2)); ;
    }

    private static int compareVersions(String v1, String v2) {
        String[] st1 = v1.split("\\.");
        String[] st2 = v2.split("\\.");

        int max = Math.max(st1.length, st2.length);

        for (int i = 0; i < max; i++) {

            int num1 = i > st1.length ? 0 : Integer.parseInt(st1[i]);
            int num2 = i > st2.length ? 0 : Integer.parseInt(st2[i]);

            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;

        }
        return 0;

    }
}
