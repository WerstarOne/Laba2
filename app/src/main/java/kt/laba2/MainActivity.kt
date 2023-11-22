package kt.laba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var n: EditText
    private lateinit var button: Button
    private lateinit var f: TextView
    private lateinit var p: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n = findViewById(R.id.n)
        button = findViewById(R.id.button)
        f = findViewById(R.id.f)
        p = findViewById(R.id.p)

        button.setOnClickListener {
            val n = n.text.toString().toInt()

            val factorial = calculateFactorial(n)
            val result = isFactorialThreeConsecutive(n, factorial)

            f.text = "$factorial"
            p.text = result
        }
    }

    private fun calculateFactorial(n: Int): Long {
        var factorial: Long = 1
        for (i in 1..n) {
            factorial *= i
        }
        return factorial
    }

    private fun isFactorialThreeConsecutive(n: Int,factorial: Long): String {
        for (i in 1..n) {
            if (((i - 2) * (i - 1) * i) == factorial.toInt()) {
                return ("${i - 2} * ${i - 1} * $i = $factorial")
            }
        }
        return ("Таких чисел не существует.")
    }
}