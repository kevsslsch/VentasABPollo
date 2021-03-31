package com.mds.ventasabpollo.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.mds.ventasabpollo.fragments.TabFragmentDomicilies;
import com.mds.ventasabpollo.fragments.TabFragmentFiscalData;

public class AdapterTabsAddClient extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public AdapterTabsAddClient(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                TabFragmentFiscalData fiscal_data = new TabFragmentFiscalData();
                return fiscal_data;
            case 1:
                TabFragmentDomicilies domicilies = new TabFragmentDomicilies();
                return domicilies;
            default:
                return null;
        }
    }
}