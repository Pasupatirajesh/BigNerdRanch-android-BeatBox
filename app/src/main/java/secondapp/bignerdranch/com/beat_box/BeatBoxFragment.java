package secondapp.bignerdranch.com.beat_box;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by SSubra27 on 1/31/16.
 */
public class BeatBoxFragment extends Fragment {
    private BeatBox mBeatBox;


    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mBeatBox = new BeatBox(getActivity());
//        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.content_beat_box, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.fragment_beat_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));

        return v;

    }



    private class SoundHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Button mButton;
        private Sound mSound;

        public SoundHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound, container, false));
            mButton = (Button) itemView.findViewById(R.id.list_item_sound_button);
            mButton.setOnClickListener(this);

        }
        public void bindSound(Sound sound)
        {
            mSound = sound;
            mButton.setText(sound.getName());
            mButton.setOnClickListener(this);
        }
        @Override
        public void onClick(View v)
        {
            mBeatBox.play(mSound);
        }

    }
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>
    {
        private List<Sound> mSounds;
        public SoundAdapter(List<Sound> sounds)
        {
            mSounds=sounds;
        }
        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new SoundHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
                Sound sound = mSounds.get(position);
                holder.bindSound(sound);

        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }

    @Override

    public void onDestroy()
    {
        super.onDestroy();
        mBeatBox.release();
    }
}


































//    private BeatBox mBeatBox;
//    public static BeatBoxFragment newInstance()
//    {
//        return new BeatBoxFragment();
//    }
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        mBeatBox = new BeatBox(getActivity());
//    }
//    @Override
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        View v = inflater.inflate(R.layout.content_beat_box, container, false);
//        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.fragment_beat_box_recycler_view);
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
//       recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));
//        return v;
//    }
//    private class SoundHolder extends RecyclerView.ViewHolder
//    {
//        private Button mButton;
//        private Sound mSound;
//        public SoundHolder(LayoutInflater layoutInflater, ViewGroup container)
//        {
//            super(layoutInflater.inflate(R.layout.list_item_sound,container,false));
//            mButton = (Button)itemView.findViewById(R.id.list_item_sound_button);
//        }
//        public void bindSound(Sound sound)
//        {
//            mSound = sound;
//            mButton.setText(mSound.getName());
//        }
//    }
//
//    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
//        private List<Sound> mSounds;
//
//        public SoundAdapter(List<Sound> sounds)
//        {
//            mSounds = sounds;
//        }
//
//        @Override
//        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
//            return new SoundHolder(layoutInflater,parent);
//        }
//
//        @Override
//        public void onBindViewHolder(SoundHolder holder, int position) {
//
//            Sound sound = mSounds.get(position);
//            holder.bindSound(sound);
//        }
//
//        @Override
//        public int getItemCount() {
//            return mSounds.size();
//        }
//    }

