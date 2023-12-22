package com.hardi.starterpatterndemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hardi.starterpatterndemo.databinding.ActivitySenderBinding

class SenderActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendMoney()
    }

    override fun onResume() {
        super.onResume()
        binding.edAmount.text = null
    }

    private fun sendMoney() {
        binding.btnSend.setOnClickListener{
            val money = binding.edAmount.text.toString().trim()
            if(money.isNotEmpty()){
                startActivity(ReceiverActivity.getStartIntent(this@SenderActivity,money))
            }else{
                Toast.makeText(this,"Please add some amount, Thank You!!!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}