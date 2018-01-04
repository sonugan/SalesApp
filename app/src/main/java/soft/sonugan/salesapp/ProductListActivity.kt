package soft.sonugan.salesapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_product_list.*
import soft.sonugan.salesapp.model.Product

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val lv : ListView = productList
        lv.adapter = ProductListAdapter(this)
    }

    private class ProductListAdapter(context : Context) : BaseAdapter(){
        internal var products = arrayOf(Product(id = 1, code = "1234", name = "Carne picada"),
                Product(id = 2, code = "1235", name = "Salsa de carne"))

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
