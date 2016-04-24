package c7.calc;

/**
 * Created by Think on 2016/4/24.
 */
public class MaxCalculatorImpl implements MaxCalculator {
    @Override
    public double max(double a, double b) {
        return a>b?a:b;
    }
}
