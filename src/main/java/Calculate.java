import java.util.ArrayList;

public class Calculate {
    public static int add(String input) {
        String deli = ",\n";
        if (input.startsWith("//")) {
            deli += input.substring(2, input.indexOf("\n"));
            input = input.substring(input.indexOf("\n"));
        }
        return add(input, "[" + deli + "]");
    }

    static int add(final String numbers, String deli) {
        String[] arr = numbers.split("[" + deli + "]");
        ArrayList<Integer> negativeNumbers = new ArrayList<>(); //Tracking negative numbers to be displayed later
        int sum = 0;
        try {
            for (String numberAtIndex : arr) {
                if (!numberAtIndex.trim().isEmpty() && (Character.isDigit(numberAtIndex.charAt(0)) || numberAtIndex.charAt(0) == '-' )) {
                    if (Integer.parseInt(numberAtIndex.trim()) < 0) {
                        negativeNumbers.add(Integer.parseInt(numberAtIndex.trim()));
                    } else if (Integer.parseInt(numberAtIndex.trim()) < 1000) {  //ignores integers greater than or equal to 1000
                        sum += Integer.parseInt(numberAtIndex.trim());
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR: invalid input");
        }
        if (!negativeNumbers.isEmpty()) // throw going to be handled by assertThrows
            throw new IllegalArgumentException("\nERROR: negatives not allowed " + negativeNumbers.toString().replace("[", "").replace("]", ""));
        return sum;
    }
}
