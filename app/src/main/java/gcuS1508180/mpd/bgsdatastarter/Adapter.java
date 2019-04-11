package gcuS1508180.mpd.bgsdatastarter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



public class Adapter
        extends RecyclerView.Adapter<Adapter.FeedModelViewHolder> {

    private List<Earthquake> mRssFeedModels;

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        private View rssFeedView;

        public FeedModelViewHolder(View v) {
            super(v);
            rssFeedView = v;
        }
    }

    public Adapter(List<Earthquake> rssFeedModels) {
        mRssFeedModels = rssFeedModels;
    }

    @Override
    public FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.earthquake_feed, parent, false);
        FeedModelViewHolder holder = new FeedModelViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FeedModelViewHolder holder, int position) {

        final Earthquake earthquake = mRssFeedModels.get(position);
        String[] seperated = earthquake.getDescription().split(";");
        String magnitude = seperated[4].substring(13);
        String location = seperated[1].substring(11);
        String date = seperated[0].substring(18);
        String latlong = seperated[2].substring(12);
        String depth = seperated[3].substring(7);

        ((TextView)holder.rssFeedView.findViewById(R.id.titleText)).setText(location + "," + magnitude);
        ((TextView)holder.rssFeedView.findViewById(R.id.descriptionText)).setText(date + "," + depth + "," + latlong);
    }

    @Override
    public int getItemCount() {
        return mRssFeedModels.size();
    }
}