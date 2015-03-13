package bizmodel;

public class Calculation {

    private double number1;
    private double number2;
    private double result;
    private String operation;

    public static enum Operation {

        ADD,
        MULTIPLY
    }

    public void doCalculation(Calculation.Operation op) {

        if (Operation.ADD == op ) {
            result = number1 + number2;

        } else {
            if (Operation.MULTIPLY == op) {
                result = number1 * number2;
            }
        }

    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}

