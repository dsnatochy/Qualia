package co.poynt.app.qualia;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends FragmentActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    /**
     * Identifiers for fragments.
     */
    public static final int FRAGMENT_ONE = 0;
    public static final int FRAGMENT_TWO = 1;
    public static final int FRAGMENT_THREE = 2;
    public static final int FRAGMENT_FOUR = 3;
    /**
     * Number of total fragments.
     */
    public static final int FRAGMENTS = 4;


    /**
     * The adapter definition of the fragments.
     */
    private FragmentPagerAdapter mFragmentPagerAdapter;

    private ImageView dot;

    /**
     * The ViewPager that hosts the section contents.
     */
    private ViewPager mViewPager;

    /**
     * List of fragments.
     */
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        dot = (ImageView) findViewById(R.id.imgDot);


        // Create fragments.
        mFragments.add(FRAGMENT_ONE, new FirstFragment());
        mFragments.add(FRAGMENT_TWO, new SecondFragment());
        mFragments.add(FRAGMENT_THREE, new ThirdFragment());
        mFragments.add(FRAGMENT_FOUR, new FourthFragment());

        // Setup the fragments, defining the number of fragments, the screens and titles.
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){
            @Override
            public int getCount() {
                return FRAGMENTS;
            }
            @Override
            public Fragment getItem(final int position) {
                return mFragments.get(position);
            }
            @Override
            public CharSequence getPageTitle(final int position) {
                switch (position) {
//                    case FRAGMENT_ONE:
//                        return "Title One";
//                    case FRAGMENT_TWO:
//                        return "Title Two";
                    default:
                        return null;
                }
            }
        };
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mFragmentPagerAdapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
/*

                        RelativeLayout.LayoutParams currentParams = (RelativeLayout.LayoutParams) dot.getLayoutParams();
                        float FACTOR = 1.5f;
                        int offset = (int) (250*FACTOR);
                        int leftMargin = (int) (250*1.5);
                        currentParams.leftMargin = (int) (leftMargin + 30*FACTOR * position + 30*FACTOR * positionOffset);


                        dot.setLayoutParams(currentParams);

*/

                        switch (position) {
                            case 0:
                                Log.d(TAG, String.format("position: %d, positionOffset: %f, positionOffsetPixels: %d", position, positionOffset, positionOffsetPixels));
                                break;
                            case 1:
                                Log.d(TAG, String.format("position: %d, positionOffset: %f, positionOffsetPixels: %d", position, positionOffset, positionOffsetPixels));
                                break;
                            case 2:
                                Log.d(TAG, String.format("position: %d, positionOffset: %f, positionOffsetPixels: %d", position, positionOffset, positionOffsetPixels));
                                break;
                            case 3:
                                Log.d(TAG, String.format("position: %d, positionOffset: %f, positionOffsetPixels: %d", position, positionOffset, positionOffsetPixels));
                                break;
                            default:
                                break;

                        }
                    }

                    @Override
                    public void onPageSelected(int position) {
                        ImageView _dot;
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dot.getLayoutParams();
                        switch (position) {
                            case 0:
                                _dot = (ImageView) findViewById(R.id.dotOne);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams)_dot.getLayoutParams()).leftMargin;
                                break;
                            case 1:
                                _dot = (ImageView) findViewById(R.id.dotTwo);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams)_dot.getLayoutParams()).leftMargin;
                                break;
                            case 2:
                                _dot = (ImageView) findViewById(R.id.dotThree);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams)_dot.getLayoutParams()).leftMargin;
                                break;
                            case 3:
                                _dot = (ImageView) findViewById(R.id.dotFour);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams)_dot.getLayoutParams()).leftMargin;
                                break;
                            default:
                                break;
                        }

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        }, 1000);


        
    }

    private void displayToast(final String message){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
