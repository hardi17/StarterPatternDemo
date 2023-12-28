package com.hardi.starterpatterndemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hardi.starterpatterndemo.databinding.ActivityMoneyTransferInfoBinding

class MoneyTransferInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMoneyTransferInfoBinding

    companion object{
        private const val EXTRAS_MONEY = "EXTRAS_MONEY"
        private const val SENDER_NAME = "SENDER_NAME"
        private const val RECEIVER_NAME = "RECEIVER_NAME"
        private const val TRANSACTION_ID = "TRANSACTION_ID"

        fun getStartIntent(context: Context, money: String?,
                           senderName: String?,
                           receiverName: String?,
                           transId : String?) : Intent {
            return Intent(context, MoneyTransferInfoActivity::class.java)
                .apply {
                    putExtra(EXTRAS_MONEY,money)
                    putExtra(SENDER_NAME,senderName)
                    putExtra(RECEIVER_NAME,receiverName)
                    putExtra(TRANSACTION_ID,transId)
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoneyTransferInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
    }

    @SuppressLint("SetTextI18n")
    private fun getIntentData(){
        val money= intent.getStringExtra(EXTRAS_MONEY)
        val senderName= intent.getStringExtra(SENDER_NAME)
        val receiverName= intent.getStringExtra(RECEIVER_NAME)
        val transactionId= intent.getStringExtra(TRANSACTION_ID)
        binding.tvInfo.text = "Detail of the transaction id $transactionId, \n" +
                " Name : $senderName \n " +
                "Receiver Name : $receiverName \n " +
                "Sending Amount : $money ."
    }
}