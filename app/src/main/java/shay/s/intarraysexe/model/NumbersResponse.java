package shay.s.intarraysexe.model;

import androidx.annotation.NonNull;

import java.util.List;

public class NumbersResponse {
    private List<Number> numbers;

    public List<Number> getNumbers() {
        return numbers;
    }

    @NonNull
    @Override
    public String toString() {
        return "\nNumbersResponse{" +
                "numbers=" + numbers +
                '}';
    }
}
