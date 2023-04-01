package namvt.dev.php_project.models.news

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import namvt.dev.php_project.models.categories.Category
import namvt.dev.php_project.models.users.User
@Parcelize
data class News(
    val categoryId: Int?,
    val imageUrl: String?,
    val newsDescription: String?,
    val newsId: Int?,
    val title: String?,
    val userId: Int?,
) :Parcelable