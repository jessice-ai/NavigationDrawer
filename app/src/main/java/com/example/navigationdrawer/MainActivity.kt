package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 这几行代码的功能就是设置 抽屉中的按钮点击之后，可切换Fragment
         */
        //fragment2 是 NavHostFragment 获取导航图标，设置的ID，navController 是 NavController 实例化之后的对象
        navController = findNavController(R.id.fragment2)
        //navController.graph 获取导航图标，sunDrawerLayoutid 是抽屉的ID
        /**
         * 效果一
         * 点击item选项，进入Fragment后，左上角变化为想左的箭头，点击箭头，会退回之前一个Fragment
         */
        //appBarConfiguration = AppBarConfiguration(navController.graph,sunDrawerLayoutid)
        /**
         * 效果二
         * 点击item选项，进入Fragment后，左上角不变化为箭头，还是之前的三个杠杠，点击箭头，会退回之前一个Fragment
         */
        val sun_set:Set<Int> = setOf(R.id.oneFragment,R.id.twoFragment,R.id.threeFragment)
        appBarConfiguration = AppBarConfiguration(sun_set,sunDrawerLayoutid)


        setupActionBarWithNavController(navController,appBarConfiguration)
        sunNavigationViewid.setupWithNavController(navController)

    }

    /**
     * 这个函数是设置，左侧左上角那三个刚，点击可以进入抽屉
     */
    override fun onSupportNavigateUp(): Boolean {
        //return super.onSupportNavigateUp()
        return navController.navigateUp(appBarConfiguration) || onSupportNavigateUp()
    }

}