package com.example.moskovchuk_final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.moskovchuk_final_project.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), Navigator {

    lateinit var binding: ActivityHomeBinding
    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.place_holder)!!

    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            if(savedInstanceState == null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, PersonageFragment())
                    .commit()
            }

            bottomNavigation?.setOnItemSelectedListener { it ->
                when (it.itemId) {
                    R.id.nav_personage -> showPersonageFragment()
                    R.id.nav_locations -> showLocationFragment()
                    R.id.nav_episodes -> showEpisodesFragment()
                }
                true
            }
        }
        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, fragment)
            .commit()
    }

    private fun launchFragmentBack(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.place_holder, fragment)
            .commit()
    }

    override fun showEpisodesFragment() {
        launchFragment(EpisodesFragment.newInstance())
    }

    override fun showLocationFragment() {
        launchFragment(LocationsFragment.newInstance())
    }

    override fun showPersonageFragment() {
        launchFragment(PersonageFragment.newInstance())
    }
}