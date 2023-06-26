package com.jerboa.api.compat.v0_17_2.types
data class ModRemoveCommentView(
    val mod_remove_comment: ModRemoveComment,
    val moderator: Person?,
    val comment: Comment,
    val commenter: Person,
    val post: Post,
    val community: Community,
)
