import java.util.ArrayList;
import java.util.List;

public class  Calculate {
    static String input;
    static int sum;
    private static IIOProvider _iio;
    public static int add(String s) {
           if(s == null) throw new NullPointerException("s");
           if (s.isEmpty()) return 0;
           input = s;
           int number = Integer.parseInt(s);
           EnsureNonNegatives(number);
           sum = add(number);
           OutValue();
        return sum;
    }

    private static void OutValue(int sum) {
        if (_iio != null)
            _iio.Out(sum.toString(CultureInfo.InvariantCulture));
    }

    private static void EnsureNonNegatives(List<Integer> number) throws Exception {
        List<Integer> negatives = new ArrayList<>() {
        };
        for (int num : number){
            if (num < 0)
            {
                negatives.add(num);
            }
            if (negatives.size() > 0){
                throw new Exception("negative not allowed");
            }

        }
    }

    static int add(int...a) {
        for (int c = 0; c < a.length; c++) {
            sum = sum + a[c];
        }
        return sum;
    }

}
