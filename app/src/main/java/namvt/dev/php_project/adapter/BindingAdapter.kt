package namvt.dev.php_project.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import namvt.dev.php_project.R


@BindingAdapter("app:loadImage")
fun loadImage(iv: ImageView, imgUrl: String?) {
    Glide.with(iv).load(imgUrl).placeholder(R.drawable.google).error(R.drawable.google).into(iv)
}