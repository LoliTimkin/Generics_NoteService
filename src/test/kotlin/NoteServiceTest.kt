
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class NoteServiceTest {

    @Test
    fun add() {
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
            text = "My first comment in first note"
        )

        val result = NoteService.add(note)

        assertEquals(1,result)
    }

    @Test
    fun createComment() {
        val note_id = 1
        val comment = Comment(
            count = 2,
            canClose = true,
            canPost = true,
            groupsCanPost = true,
            canOpen = true,
            noteId = 1,
            text = "My second comment in first note"
        )

        val result = NoteService.createComment(note_id, comment)

        assertEquals(2, result)
    }

    @Test
    fun delete() {
        val note2 = Notes(
            nid = 2,
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
            text = "My first comment in first note"
        )
        NoteService.add(note2)
        val result =  NoteService.delete(2)
        assertEquals(1, result)
    }

    @Test
    fun deleteCommentIfNotFoundComment() {
       val note2 = Notes(
            nid = 2,
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
            text = "My first comment in first note"
        )

        NoteService.add(note2)
        val result = NoteService.deleteComment(1, 1)

        assertEquals(111, result)
    }

    @Test
    fun deleteCommentIfSuccess() {
        val note3 = Notes(
            nid = 3,
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
            count = 3,
            canClose = true,
            canPost = true,
            groupsCanPost = true,
            canOpen = true,
            noteId = 1,
            text = "My first comment in first note"
        )

        NoteService.add(note3)
        NoteService.createComment(3, comment)
        val result = NoteService.deleteComment(3, 1)

        assertEquals(1, result)
    }

    @Test
    fun getById() {
        val note4 = Notes(
            nid = 4,
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
            text = "My first comment in first note"
        )

        NoteService.add(note4)
        val result = NoteService.getById(4)

        assertEquals(arrayListOf(4,1,1), result)
    }

    @Test
    fun get() {
        val note = Notes(
            nid = 5,
            owner_id = 2,
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
            text = "My first comment in first note"
        )
        val note2 = Notes(
            nid = 6,
            owner_id = 2,
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
        val comment2 = Comment(
            count = 1,
            canClose = true,
            canPost = true,
            groupsCanPost = true,
            canOpen = true,
            noteId = 1,
            text = "My first comment in second note"
        )
        NoteService.add(note)
        NoteService.add(note2)
        val result = NoteService.get(2)
        assertEquals(arrayListOf(note, note2), result)
    }

    @Test
    fun getComments() {
        val note = Notes(
            nid = 7,
            owner_id = 3,
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
            text = "My first comment in first note"
        )
        val comment2 = Comment(
            count = 1,
            canClose = true,
            canPost = true,
            groupsCanPost = true,
            canOpen = true,
            noteId = 1,
            text = "My first comment in first note"
        )

        NoteService.add(note)
        NoteService.createComment(7, comment)
        NoteService.createComment(7, comment)
        val result = NoteService.getComments(3)

        assertEquals(arrayListOf(comment, comment2), result)
    }
}