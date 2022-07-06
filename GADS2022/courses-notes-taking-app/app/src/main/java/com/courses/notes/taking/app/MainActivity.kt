package com.courses.notes.taking.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.courses.notes.taking.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
         * Get passed data via intent
         */
        var notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, -1)

        if(notePosition != -1)
            displayNote(notePosition)

        /*
         * Binding views
         */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        /*
         * Populate views
         */
        /* When using a class type */
//        val dataManager = DataManager()
//        val adapterCourses = ArrayAdapter<CourseInfo>(
//            this,
//            android.R.layout.simple_spinner_item,
//            dataManager.courses.values.toList()
//        )

        /* Using an object */
        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList()
        )

        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.includeContentMain.spinnerCourses.adapter = adapterCourses

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

//        binding.fab.setOnClickListener { view ->
//            val originalValue = binding.includeContentMain.textView.text.toString().toInt()
//            val newValue = originalValue * 2
//
////            binding.includeContentMain.editTextValue.setText(newValue.toString())
//            binding.includeContentMain.textView.text = newValue.toString()
//
//            Snackbar.make(view, "Value $originalValue changed to $newValue", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

    private fun displayNote(notePosition: Int) {
        val note = DataManager.notes.get(notePosition)
        binding.includeContentMain.noteTitleEditText.setText(note.title)
        binding.includeContentMain.noteTextEditText.setText(note.note)

        /* Set spinner active item */
        // Get Course position
        val coursePosition = DataManager.courses.values.indexOf(note.courseInfo)
        binding.includeContentMain.spinnerCourses.setSelection(coursePosition)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}