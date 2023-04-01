package namvt.dev.php_project.models.users

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String?,
    val password: String?,
    val last_name: String?,
    val imageUrl: String?,
    val userId: Int?
):Parcelable