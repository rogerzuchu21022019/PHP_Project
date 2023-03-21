package namvt.dev.php_project.models

import com.google.gson.annotations.Expose

data class Result(
    val status: Boolean,
    val a: Double,
    val b: Double,
    val c: Double,
    val x1: Double,
    val x2: Double,
    val result: Double,

)
