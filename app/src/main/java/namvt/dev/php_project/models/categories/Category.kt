package namvt.dev.php_project.models.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val cDescription: String,
    val cId: Int,
    val cName: String
):Parcelable