package soft.sonugan.salesapp.Product

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.objectbox.Box
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.activity_product_edit.*
import soft.sonugan.salesapp.R
import soft.sonugan.salesapp.SalesApp
import soft.sonugan.salesapp.model.Product
import android.R.attr.duration
import android.content.Intent
import android.widget.Toast



class ProductEditActivity : AppCompatActivity(), TextWatcher {
    private lateinit var productBox: Box<Product>
    private var creating: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_edit)

        productBox = (application as SalesApp).boxStore.boxFor(Product::class.java)

        val intent = getIntent()
        if(intent.extras != null){
            val id = intent.extras["id"] as Long
            creating = false
            //TODO busco el producto en la base de datos
        }

        addValidations()
    }

    fun addValidations(){
        code.addTextChangedListener(this)
        name.addTextChangedListener(this)
    }

    fun save(view: View){
        val product = Product(code= code.getText().toString(), name = name.getText().toString())
        product.description = product.description

        productBox.put(product)

        var toastString = ""
        if(creating){
            toastString = resources.getString(R.string.product_created)
        }else{
            toastString = resources.getString(R.string.product_updated)
        }

        val toast = Toast.makeText(applicationContext, toastString, Toast.LENGTH_SHORT)
        toast.show()

        val intent = Intent(applicationContext, ProductListActivity::class.java)
        startActivity(intent)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }
}
