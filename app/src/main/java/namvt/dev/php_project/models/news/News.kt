package namvt.dev.php_project.models.news

data class News(
    val categoryId: Int,
    val imageUrl: String,
    val newsDescription: String,
    val newsId: Int,
    val title: String,
    val userId: Int
)