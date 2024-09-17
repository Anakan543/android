package com.example.laborotorna3

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.log

class Test{

    fun double(x: Int):String{
        return "function double" + (x*x)
    }
    fun sum(x: Int, y:Int):Int{
        return x + y
    }
    fun checkInt(x: Any): Boolean {
        return x is Int
    }
    override fun toString(): String {
        return "Я перевизначений метод"
    }
}
class Person(var name: String, var age: Int) {
    constructor(name: String) : this(name, 18) {
    }

    constructor() : this("Name", 0) {
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}
data class User(val name: String, val lastname: String,
                val age: Int, val group: Int)

data class Login(val login: String, val password: Int,
                val email: String, val bot: Boolean)
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val text: TextView = findViewById(R.id.textView)
    val text1: TextView = findViewById(R.id.textView1)
    val text2: TextView = findViewById(R.id.textView2)
    val text3: TextView = findViewById(R.id.textView3)

    val testObject = Test()
    text.setText(testObject.double(10))
    val result = "function sum " + testObject.sum(10, 80).toString()
    text1.setText(result)
    text2.setText(testObject.checkInt(25).toString())
    text3.setText(testObject.toString())

    var nameArray = resources.getStringArray(R.array.name_array)
    val text4: TextView = findViewById(R.id.textView4)
    val names = nameArray.joinToString(", ")
    text4.text = names

    val user = User("Ivan", "Kohut", 19, 309)
    val text5: TextView = findViewById(R.id.textView5)
    text5.text = user.toString()

    val login = Login("login", 12345678, "email@email.com", bot = true)
    val text6: TextView = findViewById(R.id.textView6)
    text6.text = login.toString()

    val text7: TextView = findViewById(R.id.textView7)
    text7.text = user.equals(login).toString()

    val person1 = Person("Ivan", 19)
    val person2 = Person("Svetlana")
    val person3 = Person()

    val text9: TextView = findViewById(R.id.textView9)
    text9.text = "${person1.toString()}, ${person2.toString()}, ${person3.toString()}";

    val color = 4;

    val resultColor = when(color){
        1 -> "Red"
        2 -> "Orange"
        3 -> "Green"
        4 -> "Yellow"
        5 -> "Black"
        6 -> "White"
        else -> "Invalid  color"
    }

    val text8: TextView = findViewById(R.id.textView8)
    text8.text = resultColor

    }


}