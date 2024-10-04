package com.prianka.nectar.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.navigation.NavigationBarView
import com.prianka.nectar.AccountFragment
import com.prianka.nectar.CartFragment
import com.prianka.nectar.ExploreFragment
import com.prianka.nectar.FavouriteFragment
import com.prianka.nectar.R
import com.prianka.nectar.ShopFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.setOnApplyWindowInsetsListener(null)
        bottomNav.setPadding(20, 25, 20, 25)

        bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        bottomNav.isItemHorizontalTranslationEnabled = false


        val shopFragment: Fragment = ShopFragment()
        val exploreFragment: Fragment = ExploreFragment()
        val favouriteFragment: Fragment = FavouriteFragment()
        val cartFragment: Fragment = CartFragment()
        val accountFragment: Fragment = AccountFragment()

        var activeFragment: Fragment = shopFragment

        supportFragmentManager.beginTransaction().apply {
            add(R.id.content, shopFragment)
            add(R.id.content, exploreFragment)
            add(R.id.content, cartFragment)
            add(R.id.content, favouriteFragment)
            add(R.id.content, accountFragment)
            hide(exploreFragment)
            hide(cartFragment)
            hide(favouriteFragment)
            hide(accountFragment)
            commit()
        }

        bottomNav.setOnItemSelectedListener { item ->
            val newFragment =
                when (item.itemId) {
                    R.id.shop -> shopFragment
                    R.id.explore -> exploreFragment
                    R.id.cart -> cartFragment
                    R.id.favourite -> favouriteFragment
                    R.id.account -> accountFragment
                    else -> return@setOnItemSelectedListener false
                }
            if (activeFragment != newFragment) {
                supportFragmentManager.beginTransaction().apply {
                    hide(activeFragment)
                    show(newFragment)
                    commit()
                }
                activeFragment = newFragment
            }
            else{
                Toast.makeText(this,"Duplicate",Toast.LENGTH_SHORT).show()
            }
            true
        }

        // A function to hide NavigationBar
//        hideSystemUI()
    }


    // Function to hide NavigationBar
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}