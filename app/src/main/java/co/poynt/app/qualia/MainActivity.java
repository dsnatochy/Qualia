package co.poynt.app.qualia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
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
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams) _dot.getLayoutParams()).leftMargin;
                                break;
                            case 1:
                                _dot = (ImageView) findViewById(R.id.dotTwo);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams) _dot.getLayoutParams()).leftMargin;
                                break;
                            case 2:
                                _dot = (ImageView) findViewById(R.id.dotThree);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams) _dot.getLayoutParams()).leftMargin;
                                break;
                            case 3:
                                _dot = (ImageView) findViewById(R.id.dotFour);
                                layoutParams.leftMargin = ((RelativeLayout.LayoutParams) _dot.getLayoutParams()).leftMargin;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.poynt_home) {
            startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
