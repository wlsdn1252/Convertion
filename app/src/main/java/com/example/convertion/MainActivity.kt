 package com.example.convertion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.convertion.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

     var inputNumber : Int = 0
     var cmToM = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val inputEditText = binding.inputEditText
        val outputTextView = binding.outputtextView
        val inputUnitTextView = binding.inputUnitTextView
        val outputUnitTextView = binding.outputUnitTextView
        val swapImageButton = binding.swapImageButton



        inputEditText.addTextChangedListener{ text ->
            inputNumber = if(text.isNullOrEmpty()){
                0
            }else{
                text.toString().toInt()
            }

            if(cmToM){
                outputTextView.text = inputNumber.times(0.01).toString()
            }else{
                outputTextView.text = inputNumber.times(100).toString()
            }
        }

        swapImageButton.setOnClickListener{
            cmToM = cmToM.not()
            if(cmToM){
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            }else{
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }

     // 화면 회전 시 데이터 유지를 위한 오버라이딩
     override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
         // bundle에 원하는 데이터 저장
         outState.putBoolean("cmToM",cmToM)

         super.onSaveInstanceState(outState, outPersistentState)
     }

     override fun onRestoreInstanceState(savedInstanceState: Bundle) {
         // 위에서 저장된 데이터를 불러온다.
         cmToM = savedInstanceState.getBoolean("cmToM")
         
         // 단순 텍스트 입력
         binding.inputUnitTextView.text = if(cmToM) "cm" else "m"
         binding.outputUnitTextView.text = if(cmToM) "m" else "cm"

         super.onRestoreInstanceState(savedInstanceState)
     }
}