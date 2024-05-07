package com.example.a7minutesworkoutapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a7minutesworkoutapp.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity: AppCompatActivity() {

    companion object {
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }
    private var currentVisibleView: String = METRIC_UNITS_VIEW
    private var binding: ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Calculate BMI"
        binding?.toolbarBmiActivity?.setNavigationOnClickListener{
            onBackPressed()
        }

        makeVisibleMetricUnitsView()
        binding?.rgUnits?.setOnCheckedChangeListener{
            _, checkedId: Int ->
            if(checkedId==R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleUsUnitsView()
            }
        }
        binding?.btnCalculateUnits?.setOnClickListener{
           calculateUnits()
        }
    }

    private fun calculateUnits(){
        if(currentVisibleView == METRIC_UNITS_VIEW){
            if(validateMetricUnits()){
                val heightVal : Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightVal : Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weightVal / (heightVal*heightVal)
                displayBMIResult(bmi)
            }
            else{
                Toast.makeText(
                    this@BMIActivity,
                    "Please enter valid values",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        else{
           if(validateUsUnits()){
               val usUnitHeightValueFeet: String = binding?.etUsMetricUnitHeightFeet?.text.toString()
               val usUnitHeightValueInch: String = binding?.etUsMetricUnitHeightInch?.text.toString()
               val usUnitWeightValue: Float = binding?.etUsMetricUnitWeight?.text.toString().toFloat()
               val heightValue = usUnitHeightValueInch.toFloat()+usUnitHeightValueFeet.toFloat()*12
               val bmi = 703*(usUnitWeightValue / (heightValue*heightValue))
               displayBMIResult(bmi)
           }
           else{
               Toast.makeText(
                   this@BMIActivity,
                   "Please enter valid values",
                   Toast.LENGTH_SHORT
               ).show()
           }
        }
    }

    private fun makeVisibleMetricUnitsView(){
      currentVisibleView = METRIC_UNITS_VIEW
      binding?.tvMetricUnitWeight?.visibility = View.VISIBLE
      binding?.tvMetricUnitHeight?.visibility = View.VISIBLE
      binding?.tvUsMetricUnitWeight?.visibility = View.GONE
      binding?.tvMetricUsUnitHeightFeet?.visibility = View.GONE
      binding?.tvMetricUsUnitHeightInch?.visibility = View.GONE
      binding?.etMetricUnitWeight?.text!!.clear()
      binding?.etMetricUnitHeight?.text!!.clear()
      binding?.tvDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleUsUnitsView(){
        currentVisibleView = US_UNITS_VIEW
        binding?.tvMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tvMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tvUsMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tvMetricUsUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tvMetricUsUnitHeightInch?.visibility = View.VISIBLE
        binding?.etUsMetricUnitWeight?.text!!.clear()
        binding?.etUsMetricUnitHeightFeet?.text!!.clear()
        binding?.etUsMetricUnitHeightInch?.text!!.clear()
        binding?.tvDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun displayBMIResult(bmi : Float){
        val bmiLabel : String
        val bmiDescription : String
        if(bmi.compareTo(15f)<=0){
            bmiLabel = "Very severely underweight"
            bmiDescription = "OOps! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f)<=0){
            bmiLabel = "Severely underweight"
            bmiDescription = "OOps! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f)<=0){
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in a good shape!"
        }
        else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f)<=0){
            bmiLabel = "Overweight"
            bmiDescription = "OOps! You really need to take care of yourself! workout maybe!"
        }
        else if(bmi.compareTo(30f) > 0 && bmi.compareTo(35f)<=0){
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "OOps! You really need to take care of yourself! workout maybe!"
        }
        else if(bmi.compareTo(35f) > 0 && bmi.compareTo(40f)<=0){
            bmiLabel = "Obese Class | (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }
        else{
            bmiLabel = "Obese Class | (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }
        val bmiValue = BigDecimal(bmi.toDouble())
            .setScale(2, RoundingMode.HALF_EVEN).toString()
        binding?.tvDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription
    }

    private fun validateMetricUnits(): Boolean{
        var isValid = true
        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }
        else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun validateUsUnits(): Boolean{
        var isValid = true
        when{
            binding?.etUsMetricUnitWeight?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etUsMetricUnitHeightFeet?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etUsMetricUnitHeightInch?.text.toString().isEmpty() -> {
                isValid = false
            }
        }
        return isValid
    }

}