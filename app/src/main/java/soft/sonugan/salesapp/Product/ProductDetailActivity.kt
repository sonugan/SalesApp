package soft.sonugan.salesapp.Product

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_product_detail.*
import soft.sonugan.salesapp.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val intent = getIntent()
        val id = intent.extras["id"] as Long

        detail.text = id.toString()

        editButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {
                /*Toast.makeText(this@ProductDetailActivity, "Button 1",
                        Toast.LENGTH_LONG).show()*/
                val intent = Intent(applicationContext, ProductEditActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
