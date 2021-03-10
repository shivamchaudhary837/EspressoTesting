package com.example.espressotesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG="MAINACTIVITY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_amount.setOnClickListener {
            product_error_msg.visibility= View.INVISIBLE

            val productQtyText=product_quantitiy.text.toString()
            if(productQtyText.isEmpty()){
                product_error_msg.visibility=View.VISIBLE
            }else{
                val qty:Int=productQtyText.toInt()
                if(qty==0){
                    product_error_msg.visibility=View.VISIBLE
                }else{
                    val price=product_price.text.toString().toFloat()
                    val amount=ShoppingCart().calculateAmount(price,qty)
                    product_amount.text=amount.toString()
                }
            }
        }
    }
}