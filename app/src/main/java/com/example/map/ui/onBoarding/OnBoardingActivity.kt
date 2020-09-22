package com.example.map.ui.onBoarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.map.R
import com.example.map.ui.MainActivity
import kotlinx.android.synthetic.main.page_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    private val list = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_on_boarding)
        setupViewpager()
        setupListener()
    }

    private fun setupListener() {
        OnviewPage.setOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                if (checktoPage(position)){
                    Btngo.text = "Go to Map"
                } else {
                    Btngo.text = "Next"
                }
            }
        })
        Btngo.setOnClickListener {
            if (checktoPage(OnviewPage.currentItem)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                OnviewPage.currentItem += 1
            }
        }
    }

    private fun checktoPage(position : Int) = position == list.size - 1

    private fun setupViewpager() {
        val adapter = OnBoardingAdapter(supportFragmentManager)
        OnviewPage.adapter = adapter
        list.add(OnBoardingFragment.getInstance(DataOnBoarding(R.drawable.sport2,getString(R.string.next),"")))
        list.add(OnBoardingFragment.getInstance(DataOnBoarding(R.drawable.ic_2329916, getString(R.string.next), "")))
        list.add(OnBoardingFragment.getInstance(DataOnBoarding(R.drawable.ic_2329916, getString(R.string.next), "")))
        adapter.update(list)
        OnTabLT.setupWithViewPager(OnviewPage)
    }
}