data class Notes (
    val nid: Int,
    val owner_id: Int,
    val title: String,
    val text: String,
    val date: Int,
    val read_comments: Int,
    val view_url: String,
    val privacy_view: String,
    val can_comment: Int,
    val privacy: Int,
    val comment_privacy: Int,
    val text_wiki: String,
    val comments: MutableList<Comment>
)