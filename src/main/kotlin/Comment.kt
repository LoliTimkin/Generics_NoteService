data class Comment(
    var count: Int,
    var canClose: Boolean,
    var canPost: Boolean,
    var groupsCanPost: Boolean,
    var canOpen: Boolean,
    val noteId: Int,
    val text: String,
    var deleted: Boolean = false,
)
