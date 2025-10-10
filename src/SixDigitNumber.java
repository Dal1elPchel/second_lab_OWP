import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixDigitNumber {
    private static final Pattern pattern = Pattern.compile("[1-9]\\d{5}");
    private String currentNumber;
    private boolean checked;
    private static ArrayList<SixDigitNumber> numbers = new ArrayList<>();

    public SixDigitNumber(String userNumber) {
        if (userNumber != null && !userNumber.isEmpty()) {
            this.currentNumber = userNumber;
            this.checked = false;
        }
    }

    public boolean getChecked() {
        return this.checked;
    }

    public String getCurrentNumber() {
        return this.currentNumber;
    }

    public void check_currentNumber() {
        Matcher matcher = pattern.matcher(this.currentNumber);

        this.checked = matcher.matches();
    }

    public static void add_to_numbers(SixDigitNumber sdn) {
        numbers.add(sdn);
    }

    public static void print_all_valid() {
        for (SixDigitNumber i: numbers) {
            if (i.getChecked()) {
                System.out.println(i.getCurrentNumber());
            }
        }
    }

}
