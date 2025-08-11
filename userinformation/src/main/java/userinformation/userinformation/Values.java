package userinformation.userinformation;

public class Values {
    int firstValue;
    int secondValue;

    public int getFirstValue() {
        return firstValue;
    }

    public Values(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public Values(){}

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

}
