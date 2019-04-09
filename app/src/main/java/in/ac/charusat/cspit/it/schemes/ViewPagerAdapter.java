package in.ac.charusat.cspit.it.schemes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragement = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragement.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    public CharSequence getPageTitle(int position){
        return lstTitles.get(position);
    }
    public void AddFragment (Fragment fragment,String title){
        lstFragement.add(fragment);
        lstTitles.add(title);
    }

}
