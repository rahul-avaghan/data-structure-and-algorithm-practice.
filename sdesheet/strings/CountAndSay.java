public class CountAndSay {
    public static void main(String[] args) {

        long n = 1112222132  ;
        int count = 1;
        char[] str = String.valueOf(n).toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < str.length; i++) {

            if (str[i] == str[i - 1]) {
                count++;
            } else {

                ans.append(count).append(str[i - 1]);

                count = 1;
            }

        }
        ans.append(count).append(str[str.length -1]);
        System.out.println(ans);
    }
}
