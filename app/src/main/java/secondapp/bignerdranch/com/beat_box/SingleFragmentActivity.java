package secondapp.bignerdranch.com.beat_box;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by SSubra27 on 1/31/16.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId()
    {
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//        if(fragment.isAdded())
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
//        } else if(fragment.isAdded()) {
//            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
//        }

    }
}
