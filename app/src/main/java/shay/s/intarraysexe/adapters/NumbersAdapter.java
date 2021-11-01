package shay.s.intarraysexe.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import shay.s.intarraysexe.databinding.ListItemNumberBinding;
import shay.s.intarraysexe.model.Number;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder> {
    private List<Number> numbers;

    public NumbersAdapter(List<Number> numbers) {
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public NumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemNumberBinding listItemNumberBinding = ListItemNumberBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new NumbersViewHolder(listItemNumberBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersViewHolder holder, int position) {
        int number = numbers.get(position).getNumber();
        for (Number numberItem : numbers) {
            if (number + numberItem.getNumber() == 0 && number != 0){
                holder.binding.tvNumer.setBackgroundColor(Color.parseColor("#882B00"));
                int dp = (int)(150 * 2.54); //converting from px to dp
                holder.binding.tvNumer.setHeight(dp);
            }
        }
        holder.binding.tvNumer.setText(String.valueOf(number));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    static class NumbersViewHolder extends RecyclerView.ViewHolder{
        ListItemNumberBinding binding;

        public NumbersViewHolder(@NonNull ListItemNumberBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
