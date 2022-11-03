package com.example.glideandcoilcamparision

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.coroutines.delay
import java.util.Stack
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource

class GlideActivity : AppCompatActivity() {

//    private lateinit var imageView: ImageView
    private lateinit var rootLayout: LinearLayout

    private val urls = Stack<String>().apply {
//        Small Image
//        add("https://static.remove.bg/remove-bg-web/ea3c274e1b7f6fbbfe93fad8b2b13d7ef352f09c/assets/start-1abfb4fe2980eabfbbaaa4365a0692539f7cd2725f324f904565a9a744f8e214.jpg")
//        add("https://www.w3schools.com/howto/img_forest.jpg")
//        add("https://imagekit.io/blog/content/images/2019/12/image-optimization.jpg")
//        add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzQmuasfK1qjFkjJL-4h21Yps4e3i0fpHBBQ&usqp=CAU")
//        add("https://images.ctfassets.net/23aumh6u8s0i/4JKsesGb6RuQLsjVnUmB0j/0bcbb36344547e9ab698b9077f80170a/16_brightness")
//        add("https://lokeshdhakar.com/projects/lightbox2/images/image-3.jpg")
//        add("https://st.depositphotos.com/1002489/3561/i/600/depositphotos_35619861-stock-photo-paris-la-defense-at-sunset.jpg")
//        add("https://i.cbc.ca/1.6580033.1663100193!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/orion-nebula-jwst.jpg")
//        add("https://imgv3.fotor.com/images/side/Fotor-one-tap-photo-enhancer-effect.jpg")
//        add("https://imgv3.fotor.com/images/blog-cover-image/Image-Upscaler-2.jpg")

//        Large Images
//        add("https://effigis.com/wp-content/uploads/2015/02/Airbus_Pleiades_50cm_8bit_RGB_Yogyakarta.jpg")
//        add("https://effigis.com/wp-content/uploads/2015/02/DigitalGlobe_WorldView2_50cm_8bit_Pansharpened_RGB_DRA_Rome_Italy_2009DEC10_8bits_sub_r_1.jpg")
//        add("https://effigis.com/wp-content/uploads/2015/02/DigitalGlobe_WorldView1_50cm_8bit_BW_DRA_Bangkok_Thailand_2009JAN06_8bits_sub_r_1.jpg")
//        add("https://effigis.com/wp-content/themes/effigis_2014/img/GeoEye_GeoEye1_50cm_8bit_RGB_DRA_Mining_2009FEB14_8bits_sub_r_15.jpg")
//        add("https://effigis.com/wp-content/uploads/2015/02/DigitalGlobe_QuickBird_60cm_8bit_RGB_DRA_Boulder_2005JUL04_8bits_sub_r_1.jpg")
//        add("https://effigis.com/wp-content/uploads/2015/02/Infoterra_Terrasar-X_1_75_m_Radar_2007DEC15_Toronto_EEC-RE_8bits_sub_r_12.jpg")
//        add("https://raw.githubusercontent.com/samdutton/simpl/gh-pages/bigimage/bigImage-20MB.jpg")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

//        imageView = findViewById(R.id.imageView)
        rootLayout = findViewById(R.id.rootLayout)

        lifecycleScope.launchWhenResumed {
            delay(2000)
            loadImages()
        }
    }

    @OptIn(ExperimentalTime::class)
    private fun loadImages() {
        val tag = "ImageLoading"
        val mark = TimeSource.Monotonic.markNow()

        while (!urls.isEmpty()) {
            val url = urls.pop()
            val imageView = ImageView(this@GlideActivity)
            Glide.with(this)
                .load(url)
                .listener(object : RequestListener<Drawable> {
                    //
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
//                        cont.resumeWithException(e ?: Exception("exception"))
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
//                        resource?.let(imageView::setImageDrawable)
                        Log.d(tag, "${mark.elapsedNow().inSeconds}")
//                        if (urls.isNotEmpty()) {
//                            loadImages()
//                        }
                        return false
                    }
                })
                .into(imageView)
            rootLayout.addView(imageView)
        }

//        suspendCoroutine { cont ->

//        }

//        if (urls.isNotEmpty()) {
//            loadImages()
//        }
    }
}