package de.ct.nutria

import android.net.NetworkInfo
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

import foodSelector.FoodItem
import de.ct.nutria.foodSelector.FoodItemFragment
import de.ct.nutria.foodSelector.NutriaRequestCallback
import kotlinx.android.synthetic.main.activity_main.navigation
import kotlinx.android.synthetic.main.activity_main.message

class MainActivity : AppCompatActivity(), FoodItemFragment.OnListSelect, NutriaRequestCallback<String> {

    private var mTextMessage: TextView? = null
    private val foodListFragment: FoodItemFragment? = null

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //foodListFragment = (FoodItemFragment) getFragmentManager().findFragmentById(R.id.FoodList);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onListSelect(item: FoodItem) {
        Log.d("Food item in activity", item.name)
    }


    override fun updateFromRequest(result: String) {

    }

    override fun getActiveNetworkInfo(): NetworkInfo? {
        return null
    }

    override fun onProgressUpdate(progressCode: Int) {

    }

    override fun finishRequest() {

    }
}