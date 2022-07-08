package com.courses.notes.taking.app

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.courses.notes.taking.app.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val activityIntent =
                Intent(this, MainActivity::class.java) // Add .java for compatibility
            startActivity(activityIntent)

//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }

        /*
         * Populate views.
         */

        /* Set up listview. */
        // Attach adapter to listview
        binding.includeContentNodeList.listNotesListView.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DataManager.notes
        )

        // Attach item click listener event for each listview item
        binding.includeContentNodeList.listNotesListView.setOnItemClickListener {
            /* Using a lambda function */
            parent, view, position, id /* parameters */->

            /* Intent Extra */
            val activityIntent =
                Intent(this, MainActivity::class.java) // Add .java for compatibility
            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activityIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        // Update adapter
        (binding.includeContentNodeList.listNotesListView.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}