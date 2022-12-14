object NoteService {

    private var notes = mutableListOf<Notes>()

    class NoNoteException : RuntimeException()

    fun add(note: Notes): Int {
        /*
        title: String,
        text: String,
        privacy: Int,
        comment_privacy: Int,
        privacy_view: String,
        privacy_comment: String,
        nid: Int)
        */
        //var newIndex = (notes.lastIndex) + 1
        notes.add(note)
        return note.nid
    }

    fun createComment(note_id: Int, comment: Comment): Int {
        /* note_id: Int,
        owner_id: Int,
        reply_to: Int,
        message: String,
        сid: Int */
        for (note in notes) {
            if (note.nid == note_id) {
                //comments.add(comment)
                note.comments.add(comment)

            }
        }
        return comment.count
    }

    fun delete(note_id: Int): Int {
        for (note in notes) {
            if (note_id == note.nid) {
                notes.remove(note)
                return 1
            }
        }
        throw NoNoteException()
    }
/*
    fun deleteComment(
        comment_id: Int,
        owner_id: Int,
    ): Int {

        val list = get(owner_id)
        for (note in notes) {
            if (owner_id == note.owner_id) {
                for (comment in note.comments) {
                    if (comment_id == comment.count) {
                        note.comments.remove(comment)
                        return 1
                    }
                }
            }
        }
        return 111
    }
*/
    fun deleteComment(
        comment_id: Int,
        owner_id: Int,
    ): Int {
        val list = get(owner_id)
        if (list.size == 0) return 110
        for(note in list) {
            for (comment in note.comments) {
                if (comment_id == comment.count) {
                    note.comments.remove(comment)
                    return 1
                }
            }
        }
        return 111
    }

    fun getById(nid: Int): ArrayList<Int> {
        /*
    note_id: Int,
    owner_id: Int,
    need_wiki: Boolean */
        for ((index, note) in notes.withIndex()) {
            if (nid == note.nid) {
                //var note = notes[index]
                return arrayListOf(note.nid, note.comment_privacy, note.privacy)
            }
        }
        throw NoNoteException()
    }

    fun get(
        //note_ids: String,
        user_id: Int,
        //offset: Int,
        //count: Int,
        //sort: Int = 0,
    ): ArrayList<Notes> {
        val list = arrayListOf<Notes>()
        for (note in notes) {
            if (user_id == note.owner_id)
                list += note
        }
        return list
    }

    fun getComments(
        //note_id: String,
        owner_id: Int,
        //offset: Int,
        //count: Int,
        //sort: Int = 0,
    ): ArrayList<Comment> {
        val list = arrayListOf<Comment>()
        for (note in notes) {
            if (owner_id == note.owner_id) {
                for (comment in note.comments) {
                    list += comment
                }

            }

        }
        return list
    }

    fun restoreComment(
        comment_id: Int,
        owner_id: Int,
    ): Int {

        for (comment in getComments(owner_id)) {
            if (comment_id == comment.count && comment.deleted == true) {
                comment.deleted = false
            }
            return 1
        }
        return 183
    }

}