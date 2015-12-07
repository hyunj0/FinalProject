package hyunj0.c4q.nyc.android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchFragment extends Fragment {

    public static final String API_URL = "https://itunes.apple.com";

    private EditText search_term;
    private Button search_button;
    private ListView result_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        final String media = getArguments().getString("media");

        search_term = (EditText) v.findViewById(R.id.search_term);
        search_button = (Button) v.findViewById(R.id.search_button);
        result_list = (ListView) v.findViewById(R.id.result_list);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term = search_term.getText().toString();
                term.replace(' ', '+');

                Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
                ITunesApi api = retrofit.create(ITunesApi.class);
                Call call = api.getResults(media, term);
                call.enqueue(new Callback<SearchResults>() {
                    @Override
                    public void onResponse(Response<SearchResults> response, Retrofit retrofit) {
                        SearchResults searchResults = response.body();
                        Log.d("searchResults", searchResults.toString());

                        for (Result r : searchResults.getResults()) {
                            Log.d("SARAH", r.getArtistName());
                        }

                        List<Result> results = searchResults.getResults();
                        ResultAdapter adapter = new ResultAdapter(getActivity().getApplicationContext(), R.layout.result_item, results);
                        result_list.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("failing", "why");
                    }
                });
            }
        });

        return v;
    }
}