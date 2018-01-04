package soft.sonugan.salesapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product_detail.*

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
