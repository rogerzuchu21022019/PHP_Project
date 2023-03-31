package namvt.dev.php_project.models.news

data class ResponseNews(
    val data: List<News>,
    val status: String
)