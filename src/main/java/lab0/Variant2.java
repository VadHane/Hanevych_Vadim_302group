package lab0;

public class Variant2 {
    public enum NOTES_ENUM{
        BAD, UNSATISFACTORY, SATISFACTORY, GOOD, EXCELLENT
    }

    /**
     *
     * @param k is square side
     * @return perimeter
     */
    public int inputOutputTask(int k) {
        return 0;
    }

    /**
     *
     * @param k is the weight of some obj in kg
     * @return the weight of the obj in t
     */

    public int integerNumbersTask(int k) {
        assert k > 0: "The weight should be more than zero";
        return k / 1000;
    }

    /**
     *
     * @param number1 is integer number
     * @return true, if number is odd
     */
    public boolean booleanTask(int number1) {
        return (number1 % 2) == 1;
    }


    /**
     *
     * @param parameter is integer number
     * @return transformed number
     */
    public int ifTask(int parameter) {
        return (parameter > 0) ? parameter + 1 : parameter - 2;
    }


    /**
     *
     * @param number1 is integer number
     * @return day of week day represented number1
     */
    public NOTES_ENUM switchTask(int number1) {
        assert (number1 > 5 || number1 < 1): "Error";

        switch (number1) {
            case 1:
                return NOTES_ENUM.BAD;
            case 2:
                return NOTES_ENUM.UNSATISFACTORY;
            case 3:
                return NOTES_ENUM.SATISFACTORY;
            case 4:
                return NOTES_ENUM.GOOD;
            case 5:
                return NOTES_ENUM.EXCELLENT;
            default:
                return NOTES_ENUM.SATISFACTORY;
        }

        // return NOTES_ENUM.values()[number1-1];
    }


    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @return count numbers in line from a to b
     */
    public double forTask(int a, int b) {
        assert a > b: "Number a should be more than number b";

        int counter = 0;
        for (int i = a; i <= b; i++) {
            System.out.println(i);

            counter++;
        }


        return counter;
    }

    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @return count b in a
     */
    public int whileTask(int a, int b) {
        assert (a < b): "Argument a should be more than b";

        int counter = 0;
        while (a > b) {
            counter++;

            a -= b;
        }

        return counter;
    }

    /**
     *
     * @param n is integer number
     * @return array of powers of two
     */
    public int[] arrayTask(int n) {
        assert (n < 0): "Argument should be more than 0";

        int[] array = new int[n];

        array[0] = 2;
        for (int i = 2; i <= n; i++) {
            array[i-1] = array[i-2] * 2;
        }

        return array;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}