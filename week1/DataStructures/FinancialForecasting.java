import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Recursive method to predict future value based on past growth rate
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base case: if no more years left, return the present value
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: calculate the value for the next year
        return predictFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Memoized version to predict future value
    public static double predictFutureValue(double presentValue, double growthRate, int years, Map<Integer, Double> memo) {
        // Base case: if no more years left, return the present value
        if (years == 0) {
            return presentValue;
        }
        // Check if the result for the given years is already computed
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        // Recursive case: calculate the value for the next year and store it in memo
        double futureValue = predictFutureValue(presentValue * (1 + growthRate), growthRate, years - 1, memo);
        memo.put(years, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Example initial value
        double growthRate = 0.05; // 5% annual growth rate
        int years = 10; // Predict for the next 10 years

        // Using simple recursive approach
        double futureValueSimple = predictFutureValue(presentValue, growthRate, years);
        System.out.println("Predicted future value after " + years + " years using simple recursion: $" + futureValueSimple);

        // Using memoized recursive approach
        Map<Integer, Double> memo = new HashMap<>();
        double futureValueMemoized = predictFutureValue(presentValue, growthRate, years, memo);
        System.out.println("Predicted future value after " + years + " years using memoized recursion: $" + futureValueMemoized);
    }
}

