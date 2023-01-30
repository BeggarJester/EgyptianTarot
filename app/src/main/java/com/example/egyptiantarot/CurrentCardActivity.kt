package com.example.egyptiantarot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.egyptiantarot.databinding.ActivityCurrentCardBinding
import com.google.gson.Gson

class CurrentCardActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityCurrentCardBinding

    private val objectList: Array<Card>? = Gson().fromJson(cards, Array<Card>::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityCurrentCardBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val massage = intent.getIntExtra("card", 0)

        bindingClass.CardTextView.text = objectList?.get(massage)?.Name
        bindingClass.MeaningTextView.movementMethod = ScrollingMovementMethod()
        bindingClass.MeaningTextView.setPadding(25,0,25,75)
        bindingClass.MeaningTextView.text = objectList?.get(massage)?.Description
        bindingClass.root.setBackgroundResource(cardBacks[massage])
        bindingClass.root.background.alpha = 50
    }
}