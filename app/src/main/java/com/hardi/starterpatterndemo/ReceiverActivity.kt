package com.hardi.starterpatterndemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hardi.starterpatterndemo.databinding.ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {

    private lateinit var bindng: ActivityReceiverBinding

    companion object{

        const val EXTRAS_MONEY = "EXTRAS_MONEY"

        fun getStartIntent(context: Context, money: String) : Intent {
            return Intent(context, ReceiverActivity::class.java)
                .apply {
                    putExtra(EXTRAS_MONEY,money)
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindng= ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(bindng.root)
        getIntentData()
    }

    private fun getIntentData() {
        val money= intent.getStringExtra(EXTRAS_MONEY)
        money.let {
            bindng.tvReceiver.text = "Hey hardy, \n Thank you for sending \n $$money."
        }
    }
}