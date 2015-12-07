package hyunj0.c4q.nyc.android;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ITunesApi {

    @GET("/search?")
    public Call<SearchResults> getResults (@Query("media") String media, @Query("term") String term);
}