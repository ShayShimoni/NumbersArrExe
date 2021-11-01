package shay.s.intarraysexe.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shay.s.intarraysexe.adapters.NumbersAdapter;
import shay.s.intarraysexe.databinding.NumbersFragmentBinding;

public class NumbersFragment extends Fragment {

    private NumbersFragmentBinding binding;
    private NumbersViewModel mNumbersViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = NumbersFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNumbersViewModel = new ViewModelProvider(this).get(NumbersViewModel.class);

        mNumbersViewModel.getNumbersLiveData().observe(getViewLifecycleOwner(), numbersResponse -> {
            binding.rvNumbers.setAdapter(new NumbersAdapter(numbersResponse.getNumbers()));
            binding.rvNumbers.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        });
    }
}