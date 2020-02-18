import java.util.ArrayList;

public class Calculate {
    public static int add(String input) {
        StringBuilder delimiter = new StringBuilder(",\n");
        if (input.startsWith("//")) { // looking for delimiters with startIndex of 2 and endIndex of breakLine
            delimiter = new StringBuilder(input.substring(input.indexOf("//") + 2, input.indexOf("\n")));
            input = input.substring(input.indexOf("\n"));
        }
        delimiter = new StringBuilder("[" + delimiter + "]");
        return add(input, delimiter.toString());
    }

    static int add(final String numbers, String delimiter) {
        String[] arr = numbers.split("[" + delimiter + "]");
        ArrayList<Integer> negativeNumbers = new ArrayList<>(); //Tracking negative numbers to be displayed later
        int sum = 0;
        try {
            for (String ans : arr) {
                if (!ans.trim().isEmpty()) {
                    int i = Integer.parseInt(ans.trim()); // converting string to integer
                    if (i < 0) {
                        negativeNumbers.add(i);
                    } else if (i < 1000) {  //ignores integers greater than or equal to 1000
                        sum += i;
                    }
                }
            } //
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        if (!negativeNumbers.isEmpty()) // throw going to be handled by assertThrows
            throw new IllegalArgumentException("\nERROR: negatives not allowed " + negativeNumbers.toString().replace("[", "").replace("]", ""));
        return sum;
    }
}
