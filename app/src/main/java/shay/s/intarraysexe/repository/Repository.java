package shay.s.intarraysexe.repository;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shay.s.intarraysexe.model.NumbersResponse;

public class Repository {
    public static Repository repo;
    private final NumberService service;

    private Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pastebin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         service = retrofit.create(NumberService.class);
    }

    public static Repository getRepo() {
        if (repo == null)
            repo = new Repository();
        return repo;
    }

    public Call<NumbersResponse> getNumbers(){
        return service.getNumbersArr();
    }
}
