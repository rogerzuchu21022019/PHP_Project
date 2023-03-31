package namvt.dev.php_project.models.users

data class User(
    val email: String,
    val last_name: String,
    val password: String,
    val userId: Int
)