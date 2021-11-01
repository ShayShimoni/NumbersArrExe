package shay.s.intarraysexe.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import shay.s.intarraysexe.model.NumbersResponse;

public interface NumberService {

    @GET("raw/8wJzytQX")
    Call<NumbersResponse> getNumbersArr();

}
