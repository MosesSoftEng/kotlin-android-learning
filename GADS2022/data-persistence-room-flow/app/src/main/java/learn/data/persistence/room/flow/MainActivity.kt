package learn.data.persistence.room.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import learn.data.persistence.room.flow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}