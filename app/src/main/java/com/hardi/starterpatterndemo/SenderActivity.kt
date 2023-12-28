package com.hardi.starterpatterndemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hardi.starterpatterndemo.databinding.ActivitySenderBinding

class SenderActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySenderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            sendOrInfoMoney(true)
        }

        binding.btnInfo.setOnClickListener {
            sendOrInfoMoney(false)
        }
    }

    private fun sendOrInfoMoney(isSend: Boolean) {
        val money = binding.edAmount.text.toString().trim()
        val senderName = binding.edSenderName.text.toString().trim()
        val receiverName = binding.edReceiverName.text.toString().trim()
        if (money.isNotEmpty() && senderName.isNotEmpty() && receiverName.isNotEmpty()) {
            if (isSend) {
                startActivity(
                    ReceiverActivity.getStartIntent(
                        this@SenderActivity,
                        money,
                        senderName,
                        receiverName
                    )
                )
            } else {
                startActivity(
                    MoneyTransferInfoActivity.getStartIntent(
                        this@SenderActivity,
                        money,
                        senderName,
                        receiverName,
                        "1"
                    )
                )
            }
        } else {
            Toast.makeText(
                this,
                "Please add some amount and details if you forgot, Thank You!!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}