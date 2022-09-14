/*open class GenericPair<A,B>(var id: A, element: B)
data class GenericPair2<T>: MutableList<T>*/
open class GenericPair<A>(var elem: MutableList<A>)
//var notes = mutableListOf<Notes>()

fun main() {

    val note = Notes(
        nid = 1,
        owner_id = 1,
        title = "",
        text = "",
        date = 235689,
        comments = mutableListOf<Comment>(),
        read_comments = 1,
        view_url = "",
        privacy_view = "",
        can_comment = 1,
        text_wiki = "",
        privacy = 1,
        comment_privacy = 1)
    val comment = Comment(
        count = 1,
        canClose = true,
        canPost = true,
        groupsCanPost = true,
        canOpen = true,
        noteId = 1,
        text = "My first comment in first note")
    /*var list = mutableListOf(note)
    var list2 = mutableListOf(comment)
    var generic: GenericPair<MutableList<Notes>,MutableList<Comment>> = GenericPair(list,list2)*/
    println(NoteService.add(note))
    //println(NoteService.notes.listIterator(0))
    println(NoteService.getById(1))
    println(NoteService.createComment(1, comment))
    println(note.comments[0].text)
    println(NoteService.get(user_id = 1))
}
