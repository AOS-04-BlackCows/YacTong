package com.example.yactong.ui.take

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.yactong.ui.take.fragment.CycleFragment
import com.example.yactong.ui.take.fragment.FormFragment
import com.example.yactong.ui.take.fragment.NameFragment
import com.example.yactong.ui.take.fragment.TimeFragment

class TakeViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment){
    private lateinit var takeViewPagerAdapter: TakeViewPagerAdapter
    val fragments = listOf<Fragment>(NameFragment(), FormFragment(), CycleFragment(), TimeFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}