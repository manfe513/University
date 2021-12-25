package com.example.androidlauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val pkgName = "com.android.chrome"

//        val intent = packageManager.getLaunchIntentForPackage(pkgName)!!
//
//        findViewById<ImageButton>(R.id.btn).apply {
//
//            setImageDrawable(getIcon(intent))
//            setBackgroundColor(ContextCompat.getColor(this@MainActivity, android.R.color.transparent))
//
//            setOnClickListener {
//                startActivity(intent)
//            }
//        }

        packageManager.getInstalledApplications(PackageManager.GET_META_DATA).forEach {

            Log.d("CRACK_item", "is: ${it.processName}")
        }
    }

    fun getIcon(intent: Intent): Drawable? = packageManager.resolveActivity(intent, 0) ?.loadIcon(packageManager)
}