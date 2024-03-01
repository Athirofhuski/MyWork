package com.example.project

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.model.Product
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_shop.*
import java.net.URL

class Shop : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var productList = ArrayList<Product>()
    var adapter: ProductsAdapter? = null

    var sss_p    : ImageButton? = null
    var hss_p    : ImageButton? = null
    var gss_p    : ImageButton? = null
    var sess_p    : ImageButton? = null

    private var database: FirebaseDatabase? = null
    private var reference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.activity_shop)

        database = FirebaseDatabase.getInstance()
        reference = database?.getReference("products")

        val firebaseListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                productList.clear()

                val child = snapshot.children
                child.forEach{

                    var products = Product(it.child("name").value.toString(),
                    it.child("photoUrl").value.toString(),
                    it.child("price").value.toString(),
                    it.child("website").value.toString())

                    productList.add(products)

                }
                    adapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("test", error.message)
            }
        }
        reference?.addValueEventListener(firebaseListener)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(this@Shop, 2,GridLayoutManager.VERTICAL, false)

        adapter = ProductsAdapter(productList)
        recyclerView?.adapter = adapter


        sss_p = findViewById(R.id.sss_p)
        hss_p = findViewById(R.id.hss_p)
        gss_p = findViewById(R.id.gss_p)
        sess_p = findViewById(R.id.sess_p)
        sss_p!!.setOnClickListener {
            var intent = Intent(this, Shop::class.java)
            startActivity(intent)
        }

        hss_p!!.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        gss_p!!.setOnClickListener {
            var intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        sess_p!!.setOnClickListener {
            var intent = Intent(this, Result::class.java)
            startActivity(intent)
        }
/*
        val products = arrayListOf<Product>()

        products.add(Product("NewJeans T-Shirt Oversize", "https://cdn.shopify.com/s/files/1/0561/2381/8044/products/75d67befa1e67f2b1d7b7e12074f7594.png?v=1665578686", "฿56.99"))
        products.add(Product("Copter T-Shirt Oversize", "https://www.muzikmovestore.com/content/images/2022071/bf2q4_20220721_555.jpg", "฿15.95"))
        products.add(Product("BLACKPINK LIGHT STICK KEYRING", "https://cdn.shopify.com/s/files/1/0022/5011/3123/products/BLACKPINK_KEYCHIN_LIT.png?v=1675983946", "฿24.99"))
        products.add(Product("BORN PINK VINYL", "https://cdn.shopify.com/s/files/1/0022/5011/3123/products/LP.png?v=1668802747", "฿38.00"))
        products.add(Product("BLACKPINK TOTE", "https://cdn.shopify.com/s/files/1/0022/5011/3123/products/TOTE_grande_0533304b-8bf8-48e5-8ce1-464a3cc716e4.png?v=1555519733", "฿26.50"))
        products.add(Product("BORN PINK TOUR DAD HAT", "https://cdn.shopify.com/s/files/1/0022/5011/3123/products/DadHatFront.png?v=1668710403", "฿40.00"))


        recycler_view.apply {
            layoutManager = GridLayoutManager(this@Shop, 2)
            adapter = ProductsAdapter(products)
        }

 */

    }
}