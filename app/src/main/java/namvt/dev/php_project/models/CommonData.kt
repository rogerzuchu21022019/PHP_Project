package namvt.dev.php_project.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import namvt.dev.php_project.models.categories.Category
import namvt.dev.php_project.models.news.News
import namvt.dev.php_project.models.users.User

@Parcelize
data class CommonData(
    var user: User,
    var category: Category,
    var news: News
):Parcelable