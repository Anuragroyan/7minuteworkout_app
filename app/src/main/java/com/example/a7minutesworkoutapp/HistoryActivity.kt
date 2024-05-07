package com.example.a7minutesworkoutapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.a7minutesworkoutapp.databinding.ActivityHistoryExerciseBinding
import kotlinx.coroutines.launch


class HistoryActivity : AppCompatActivity(){
    private var binding: ActivityHistoryExerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarHistoryActivity)
        val actionbar = supportActionBar
        if(actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "History of Exercises"
        }
        binding?.toolbarHistoryActivity?.setNavigationOnClickListener{
            onBackPressed()
        }
//        val dao = (application as WorkoutApp).db.historyDao()
//        getAllCompletedDates(dao)

    }
//    private fun getAllCompletedDates(historyDao: HistoryDao) {
//
//
//        lifecycleScope.launch {
//            historyDao.fetchAllDates().collect { allCompletedDatesList->
//                // List items are printed in log.
//                for (i in allCompletedDatesList) {
//                    Log.e("Date : ", "" + i)
//                }
//            }
//        }
//
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null
//    }
}
