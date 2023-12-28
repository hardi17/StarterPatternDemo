package com.hardi.starterpatterndemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hardi.starterpatterndemo.databinding.ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {

    private lateinit var bindng: ActivityReceiverBinding

    companion object{

        const val EXTRAS_MONEY = "EXTRAS_MONEY"
        const val SENDER_NAME = "SENDER_NAME"
        const val RECEIVER_NAME = "RECEIVER_NAME"

        fun getStartIntent(context: Context, money: String, senderName: String, receiverName: String) : Intent {
            return Intent(context, ReceiverActivity::class.java)
                .apply {
                    putExtra(EXTRAS_MONEY,money)
                    putExtra(SENDER_NAME,senderName)
                    putExtra(RECEIVER_NAME,receiverName)
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindng= ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(bindng.root)
        getIntentData()
    }

    @SuppressLint("SetTextI18n")
    private fun getIntentData() {
        val money= intent.getStringExtra(EXTRAS_MONEY)
        val senderName= intent.getStringExtra(SENDER_NAME)
        val receiverName= intent.getStringExtra(RECEIVER_NAME)
        money.let {
            bindng.tvReceiver.text = "Hey $senderName, \n Thank you for sending \n $$money."
        }

        bindng.btnInfo.setOnClickListener{
            startActivity(MoneyTransferInfoActivity.getStartIntent(this@ReceiverActivity, money, senderName, receiverName, "1"))
        }
    }
}