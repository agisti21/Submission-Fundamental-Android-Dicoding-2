package com.agisti.submissionfundamental2.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.agisti.submissionfundamental2.R
import com.agisti.submissionfundamental2.activity_fragment.FollowersFragment
import com.agisti.submissionfundamental2.activity_fragment.FollowingFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    var username: String? = null

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(R.string.followers, R.string.following)
    }

    override fun getItem(position: Int): Fragment {

        var fragment: Fragment? = null
        when(position){
            0 -> fragment = FollowersFragment()
            1 -> fragment = FollowingFragment()
        }
        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLE[position])
    }

    override fun getCount(): Int {
        return 2
    }
}