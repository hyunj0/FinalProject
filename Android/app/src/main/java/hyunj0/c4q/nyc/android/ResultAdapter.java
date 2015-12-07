package hyunj0.c4q.nyc.android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ResultAdapter extends ArrayAdapter<Result> {

    private Context context;
    private int resource;
    private List<Result> results;
    private LayoutInflater layoutInflater;

    public ResultAdapter(Context context, int resource, List<Result> results) {
        super(context, resource, results);
        this.context = context;
        this.resource = resource;
        this.results = results;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ResultHolder resultHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.result_item, viewGroup, false);

            resultHolder = new ResultHolder();

            resultHolder.image = (ImageView) view.findViewById(R.id.image);
            resultHolder.title = (TextView) view.findViewById(R.id.title);
            resultHolder.name = (TextView) view.findViewById(R.id.name);

            view.setTag(resultHolder);
        } else {
            resultHolder = (ResultHolder) view.getTag();
        }

        Result result = results.get(i);

        String imageURL = result.getArtworkUrl100();
        Log.d("imageURL", imageURL);

        Picasso.with(view.getContext()).load(imageURL).into(resultHolder.image);
        resultHolder.title.setText(result.getTrackName());
        resultHolder.name.setText(result.getArtistName());

        return view;
    }

    static class ResultHolder {
        ImageView image;
        TextView title;
        TextView name;
    }
}