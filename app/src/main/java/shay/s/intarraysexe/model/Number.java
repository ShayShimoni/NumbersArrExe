package shay.s.intarraysexe.model;

import androidx.annotation.NonNull;

public class Number {
    private int number;

    public int getNumber() {
        return number;
    }

    @NonNull
    @Override
    public String toString() {
        return "\nNumber{" +
                "number=" + number +
                '}';
    }
}
