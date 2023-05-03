package org.d3ifcool.yummytime

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.d3ifcool.yummytime.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        object : Thread() {
            override fun run() {
                try {
                    sleep(2500)
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } catch (e: Exception) {
                    Log.i(
                        "SplashScreen",
                        "Failed! ${e.message} --- ${e.printStackTrace()}"
                    )
                }
            }
        }.start()
    }
}