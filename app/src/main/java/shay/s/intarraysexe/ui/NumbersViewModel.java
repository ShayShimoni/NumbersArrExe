package shay.s.intarraysexe.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shay.s.intarraysexe.model.NumbersResponse;
import shay.s.intarraysexe.repository.Repository;

public class NumbersViewModel extends ViewModel {
    private MutableLiveData<NumbersResponse> numbersLiveData;

    public NumbersViewModel() {
        this.numbersLiveData = new MutableLiveData<>();
        getData();
    }

    public LiveData<NumbersResponse> getNumbersLiveData() {
        return numbersLiveData;
    }

    public void getData(){
        Repository.getRepo().getNumbers().enqueue(new Callback<NumbersResponse>() {
            @Override
            public void onResponse(@NonNull Call<NumbersResponse> call, @NonNull Response<NumbersResponse> response) {
                if (response.body() == null)
                    return;
                NumbersResponse numbersResponse = response.body();
                numbersLiveData.postValue(numbersResponse);
            }

            @Override
            public void onFailure(@NonNull Call<NumbersResponse> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}