package soft.sonugan.salesapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import io.objectbox.Box
import kotlinx.android.synthetic.main.activity_product_list.*
import soft.sonugan.salesapp.model.Product
import soft.sonugan.salesapp.model.Provider
import java.time.LocalDate
import java.util.*

class ProductListActivity : AppCompatActivity() {
    private lateinit var productBox: Box<Product>

    var product1 = Product("1234", "Carne picada")
    //product1.provider.setTarget(provider)

    var product2 = Product("1235", "Salsa de carne")
    internal var products = arrayOf(product1, product2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

     //   productBox = (application as SalesApp).boxStore.boxFor(Product::class.java)

        val listView : ListView = productList
        listView.adapter = ProductListAdapter(this, products)

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val intent = Intent(applicationContext, ProductDetailActivity::class.java)
            val selected = adapterView.getItemAtPosition(position) as Product
            intent.putExtra("id", selected.id)
            startActivity(intent)
        }

        fun addProduct(){

        }
    }

    private class ProductListAdapter(context : Context, private val products: Array<Product>) : BaseAdapter(){
        private val mInflator: LayoutInflater

        init {
            this.mInflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            val vh: ListRowHolder
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.product_list_row, parent, false)
                vh = ListRowHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolder
            }

            val product = products[position]
            vh.code.text = product.code
            vh.name.text = product.name
            return view
        }
    }

    private class ListRowHolder(row: View?) {
        public val code: TextView
        public val name: TextView

        init {
            this.code = row?.findViewById<TextView>(R.id.code) as TextView
            this.name = row?.findViewById<TextView>(R.id.name) as TextView
        }
    }
}
