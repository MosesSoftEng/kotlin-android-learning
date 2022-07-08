package com.courses.notes.taking.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.courses.notes.taking.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    // Instance State
    var notePosition = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
         * Binding views
         */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        /*
         * Get passed data via intent or from instance state
         */
        notePosition =
            savedInstanceState?.getInt(NOTE_POSITION) ?: intent.getIntExtra(NOTE_POSITION, -1)

        if (notePosition != -1)
            displayNote(notePosition)
        else {
            // Create a new note
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }

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

    /*
     * Menu
     */
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
            R.id.action_next -> {
                moveNext()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
     * Modify menu
     */
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (notePosition >= DataManager.notes.lastIndex) {

            /* Null safety */
            val menuItem = menu?.findItem(R.id.action_next)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_baseline_block_24)
                menuItem.isEnabled = false
            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    private fun moveNext() {
        ++notePosition
        displayNote(notePosition)

        invalidateOptionsMenu()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

    // Save instance state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save note position in state
        outState.putInt(NOTE_POSITION, notePosition)
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        if (notePosition == -1)
            return

        val note = DataManager.notes[notePosition]
        note.title = binding.includeContentMain.noteTitleEditText.text.toString()
        note.note = binding.includeContentMain.noteTextEditText.text.toString()
        note.courseInfo =
            binding.includeContentMain.spinnerCourses.selectedItem as CourseInfo // Cast
    }
}