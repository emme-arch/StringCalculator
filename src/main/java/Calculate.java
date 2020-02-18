import java.util.ArrayList;

public class Calculate {
    public static int add(String input) {
        StringBuilder delimeter = new StringBuilder(",\n");
        if (input.startsWith("//")) {
            delimeter = new StringBuilder(input.substring(input.indexOf("//") + 2, input.indexOf("\n")));
            input = input.substring(input.indexOf("\n"));
        }
        delimeter = new StringBuilder("[" + delimeter + "]");
        return add(input, delimeter.toString());
    }

    static int add(final String numbers, String delimiter) {
        String[] arr = numbers.split("[" + delimiter + "]");
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        try {
            for (String ans : arr) {
                if (!ans.trim().isEmpty()) {
                    int i = Integer.parseInt(ans.trim());
                    if (i < 0) {
                        negativeNumbers.add(i);
                    } else if (i < 1000) {
                        sum += i;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        if (!negativeNumbers.isEmpty())
            throw new IllegalArgumentException("\nERROR: negatives not allowed " + negativeNumbers.toString().replace("[", "").replace("]", ""));
        return sum;
    }
}
