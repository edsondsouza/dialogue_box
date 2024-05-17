package com.example.dialogue_boxex

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogue_boxex.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

//    view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(
                this,
            )
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.exit_app)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener{ dialogInterface, i ->
                // what action should perform when yes is clicked
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener{
                dialogInterface, i ->
                // what action should perform when no is clicked
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmalai", "Mysore Pak")

            val builder2 = AlertDialog.Builder(
                this,
            )

            builder2.setTitle("Your favourite sweet?")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener {
                dialog, sweet ->
                // what action to perform
                Toast.makeText(this, "You clicked on ${options[sweet]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setIcon(R.drawable.exit_app)
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener{ dialogInterface, i ->
                // what action should perform when yes is clicked
//                finish()
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                // what action should perform when no is clicked
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val languages = arrayOf("Kotlin", "Python", "JavaScript", "Java")

            val builder3 = AlertDialog.Builder(
                this,
            )
            builder3.setTitle("Select your favourite language")
            builder3.setMultiChoiceItems(languages, null, DialogInterface.OnMultiChoiceClickListener{
                dialog, lang, isChecked ->
                // what action to perform
                Toast.makeText(this, "You clicked on ${languages[lang]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setIcon(R.drawable.fav)
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener{ dialogInterface, i ->
                // what action should perform when yes is clicked
//                finish()
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                // what action should perform when no is clicked
            })
            builder3.show()
            builder3.setNeutralButton("Skip for now", DialogInterface.OnClickListener{
                dialog, which ->
            })
        }
    }
}