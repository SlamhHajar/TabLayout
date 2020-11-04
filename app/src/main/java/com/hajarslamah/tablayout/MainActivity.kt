package com.hajarslamah.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

lateinit var tabLayout: TabLayout
lateinit var tabViewPager: ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        tabViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
  tabLayout=findViewById(R.id.tabs)
        tabViewPager=findViewById(R.id.pager)
      tabViewPager.adapter = object: FragmentStateAdapter(this){
            override fun createFragment(position: Int): Fragment {
                return when(position){
                    // deleted the sconde and third and  add new instance from the oneFragment
                    0 ->FristFragment.newInstance("first",position)
                    1->FristFragment.newInstance("second",position)
                    2->FristFragment.newInstance("third",position)
                    else ->FristFragment.newInstance("first",position)
                }
            }
            override fun getItemCount(): Int {
                return 3
 }

        }
        TabLayoutMediator(tabLayout,tabViewPager){ tab ,postion ->
             when (postion){
                0 ->{
                    tab.setText("Video")
                    tab.setIcon(R.drawable.ic_baseline_video_call_24)}
                1->{tab.setText("Call")
                    tab.setIcon(R.drawable.ic_baseline_call_24)}
                2->{tab.setText("Message")
                 tab.setIcon(R.drawable.ic_baseline_message_24)}
                else -> null
            }
//            if (postion==0)
//                tab.setIcon(R.drawable.ic_baseline_video_call_24)
//            if (postion==1)
//                tab.setIcon(R.drawable.ic_baseline_call_24)
//            if (postion==2)
//                tab.setIcon(R.drawable.ic_baseline_chat_24)
        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//that way1 of answerd
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, " This is page ${tabViewPager.currentItem+1}", Toast.LENGTH_SHORT) .show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }

        })
        //that way2 of answerd
        tabViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
               // Toast.makeText(this@MainActivity,"This is page ${position+1}",Toast.LENGTH_LONG).show()
            }
        })


        }


}