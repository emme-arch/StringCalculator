public class Calculate {
    public static int add(String input) {
        String deli = ",\n";
        if (input.startsWith("//")) {//Finding delimiters between // and \n  then pass everything after \n
            deli += input.substring(2, input.indexOf("\n"));
            input = input.substring(input.indexOf("\n"));
        }
        return add(input, "[" + deli + "]");
    }

    static int add(String numbers, String deli) {
        String[] arr = numbers.split("[" + deli + "]");
        StringBuilder negativeNumbers = new StringBuilder(); //Tracking negative numbers to be displayed later
        int sum = 0;
        try {
            for (String numberAtIndex : arr) {
                if (!numberAtIndex.trim().isEmpty() && (Character.isDigit(numberAtIndex.charAt(0)) || numberAtIndex.charAt(0) == '-')) {
                    if (!Character.isDigit(numbers.charAt(numbers.length() - 1)))
                        throw new IllegalArgumentException("ERROR: invalid input");
                    if (Integer.parseInt(numberAtIndex.trim()) < 0) {
                        negativeNumbers.append(numberAtIndex.trim()).append(" ");
                    } else if (Integer.parseInt(numberAtIndex.trim()) < 1000) {  //ignores integers greater than or equal to 1000
                        sum += Integer.parseInt(numberAtIndex.trim());
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR: invalid input");
        }
        if (negativeNumbers.length() > 0) // throw going to be handled by assertThrows
            throw new IllegalArgumentException("\nERROR: negatives not allowed " + negativeNumbers.toString().replace("[", "").replace("]", ""));
        return sum;
    }
}
