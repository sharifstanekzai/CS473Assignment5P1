package com.example.cs473assignmentp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var rbtnCanada:RadioButton;
    private lateinit var rbtnChina:RadioButton;
    private lateinit var rbtnIndia:RadioButton;
    private lateinit var rbtnRussia:RadioButton;
    private lateinit var rbtnUSA:RadioButton;
    private lateinit var cbChina:CheckBox
    private lateinit var cbIndia:CheckBox
    private lateinit var cbRussia:CheckBox
    private lateinit var cbUAE:CheckBox
    private lateinit var cbUSA:CheckBox
    private lateinit var btnSubmit:Button
    private lateinit var btnReset:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindControls();
        btnSubmit.setOnClickListener{
            submit();
        };

        btnReset.setOnClickListener{
            reset()
        }
    }
    private fun bindControls(){
        rbtnCanada=findViewById(R.id.rbtnCanada);
        rbtnChina=findViewById(R.id.rbtnChina);
        rbtnIndia=findViewById(R.id.rbtnIndia);
        rbtnRussia=findViewById(R.id.rbtnRussia);
        rbtnUSA=findViewById(R.id.rbtnUSA);

        cbChina=findViewById(R.id.cbChina);
        cbIndia=findViewById(R.id.cbIndia);
        cbRussia=findViewById(R.id.cbRussia);
        cbUAE=findViewById(R.id.cbUAE);
        cbUSA=findViewById(R.id.cbUSA);

        btnSubmit=findViewById(R.id.btnSubmit);
        btnReset=findViewById(R.id.btnReset)
    }
    private fun submit(){
        val calender = Calendar.getInstance()

        var score = 0
        if(rbtnChina.isChecked){
            score += 50
        }
        if(cbIndia.isChecked) {
            score += 25
        }
        if(cbUAE.isChecked){
            score += 25
        }

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Quiz Submitted")
        if(score>=50){
            alert.setMessage("Congrats! You passed...\nScore:${score} \nSubmission date:${calender.get(Calendar.DATE)}")
        }
        else{
            alert.setMessage("Sorry!!! You couldn't make it")
        }

        alert.setPositiveButton("Done"){dialogInterface, which ->
            dialogInterface.dismiss()
            finish()
        }

        alert.setNegativeButton("Retake"){dialogInterface, which->
            dialogInterface.dismiss()
            reset()
        }

        val dialog:AlertDialog = alert.create()
        dialog.show()
    }
    private fun reset(){
        rbtnCanada.isChecked=false;
        rbtnChina.isChecked=false;
        rbtnIndia.isChecked=false;
        rbtnUSA.isChecked=false;
        rbtnRussia.isChecked=false;

        cbChina.isChecked=false;
        cbIndia.isChecked=false;
        cbRussia.isChecked=false;
        cbUAE.isChecked=false;
        cbUSA.isChecked=false;
    }
}