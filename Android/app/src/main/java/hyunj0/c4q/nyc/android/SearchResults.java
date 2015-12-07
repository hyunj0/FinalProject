package hyunj0.c4q.nyc.android;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResults {

    @SerializedName("results")
    @Expose
    List<Result> results;

    public SearchResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }
}

class Result {

    @SerializedName("artistName")
    @Expose
    private String artistName;

    @SerializedName("trackName")
    @Expose
    private String trackName;

    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;

    public Result(String artistName, String trackName, String artworkUrl100) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.artworkUrl100 = artworkUrl100;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }
}