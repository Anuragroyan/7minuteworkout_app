package com.example.a7minutesworkoutapp

import kotlin.math.E

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "JumpingJacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingJacks)
        val abdominalCrunch = ExerciseModel(
            2,
            "AbdominalCrunch",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        )
        exerciseList.add(abdominalCrunch)
        val highKneesRunningInPlace = ExerciseModel(
            3,
            "HighKneesRunningInPlace",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false
        )
        exerciseList.add(highKneesRunningInPlace)
        val lunge = ExerciseModel(
            4,
            "Lunge",
            R.drawable.ic_lunge,
            false,
            false
        )
        exerciseList.add(lunge)
        val plank = ExerciseModel(
            5,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        )
        exerciseList.add(plank)
        val pushUp = ExerciseModel(
            6,
            "PushUp",
            R.drawable.ic_push_up,
            false,
            false
        )
        exerciseList.add(pushUp)
        val pushUpAndRotation = ExerciseModel(
            7,
            "PushUpAndRotation",
            R.drawable.ic_push_up_and_rotation,
            false,
            false
        )
        exerciseList.add(pushUpAndRotation)
        val sidePlank = ExerciseModel(
            8,
            "SidePlank",
            R.drawable.ic_side_plank,
            false,
            false
        )
        exerciseList.add(sidePlank)
        val squat = ExerciseModel(
            9,
            "Squat",
            R.drawable.ic_squat,
            false,
            false
        )
        exerciseList.add(squat)
        val stepUpOntoChair = ExerciseModel(
            10,
            "StepUpOntoChair",
            R.drawable.ic_step_up_onto_chair,
            false,
            false
        )
        exerciseList.add(stepUpOntoChair)
        val tricepsDipOnChair = ExerciseModel(
            11,
            "TricepsDipOnChair",
            R.drawable.ic_triceps_dip_on_chair,
            false,
            false
        )
        exerciseList.add(tricepsDipOnChair)
        val wallSit = ExerciseModel(
            12,
            "WallSit",
            R.drawable.ic_wall_sit,
            false,
            false
        )
        exerciseList.add(wallSit)
        return exerciseList
    }
}