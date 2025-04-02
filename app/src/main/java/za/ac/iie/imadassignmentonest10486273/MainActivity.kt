package za.ac.iie.imadassignmentonest10486273

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextFood = findViewById<EditText>(R.id.editTextFood)
        val txtFood = findViewById<TextView>(R.id.TxtFood)
        val btnShowFood = findViewById<Button>(R.id.BtnShowFood)
        val btnReset = findViewById<Button>(R.id.BtnReset)

        btnShowFood.setOnClickListener {
            val inputText = editTextFood.text.toString().trim()         //Declare temp variable

            var foodOption = ""

            if (inputText.equals("Morning", ignoreCase = true)) {       //Ignore case
                foodOption = "Breakfast (e.g., Eggs and Bacon)"

            } else if (inputText.equals("Mid-Morning", ignoreCase = true)) {
                foodOption = "Light Snack (e.g, Fruit)"

            } else if (inputText.equals("Afternoon", ignoreCase = true)) {
                foodOption = "Lunch (e.g, Hot dog)"

            } else if (inputText.equals("Mid-afternoon", ignoreCase = true)) {
                foodOption = "Later Snack (e.g, Protein Bar)"

            } else if (inputText.equals("Dinner", ignoreCase = true)) {
                foodOption = "Dinner (e.g, Chicken and fried rice)"
            }
            else if (inputText.equals("After-Dinner", ignoreCase = true)) {
                foodOption = "After Dinner Snack (e.g, Chocolate Cookies)"
            }else {
                foodOption = "Spelling error! Please enter as seen above" //Spelling error
            }


            txtFood.text = foodOption
        }

        btnReset.setOnClickListener{    //resets text and clears
            editTextFood.text.clear()
            txtFood.text =""
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}