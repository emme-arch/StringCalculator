import java.util.ArrayList;
import java.util.regex.Pattern;

public class  Calculate {


    private static IIOProvider _iio;
    private static Pattern _inputParsingRegex = Pattern.compile("(?<definition>//(?<delimiter>.+)\n).*");
    private static Pattern pattern = Pattern.compile("(?<definition>//(?<delimiter>.+)\n).*");

    static String _input;
    private static final int Value = 1000;

    public static int add(String input) {
        StringBuilder delimeter = new StringBuilder(",\n");
        if (input.startsWith("//")){
            delimeter = new StringBuilder(input.substring(input.indexOf("//") + 2, input.indexOf("\n")));
            String[] arr = delimeter.toString().split("[,]");
            for (String s : arr){
                delimeter.append(s);
            }
            input = input.substring(input.indexOf("\n"));
        }
        delimeter = new StringBuilder("[" + delimeter + "]");
        return add(input, delimeter.toString());
    }
    static int add(final String numbers, String delimiter) {
        String[] arr = numbers.split("[" + delimiter + "]");
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        int sum =0;
        try{
            for (String ans : arr){
                if (!ans.trim().isEmpty()){
                    int i = Integer.parseInt(ans.trim());
                    if (i<0){
                        negativeNumbers.add(i);
                        } else if (i < Value) {
                            sum += i;
                    }
                }
            }
        } catch (Exception ignored){

        }
        if (negativeNumbers.size() > 1){
            StringBuilder negative = new StringBuilder();
            for (int i = 0; i < negativeNumbers.size() -1; i++){
                negative.append(negativeNumbers.get(i)).append(", ");
            }
            negative.append(negativeNumbers.get(negativeNumbers.size()-1));
            throw new IllegalArgumentException("\nERROR: negatives not allowed -1,-2");
        }
        return sum;
    }

}
