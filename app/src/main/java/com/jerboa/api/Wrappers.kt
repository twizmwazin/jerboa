package com.jerboa.api

import android.content.Context
import android.util.Log
import arrow.core.Either
import com.jerboa.VoteType
import com.jerboa.api.types.*
import com.jerboa.db.Account
import com.jerboa.newVote
import com.jerboa.serializeToMap
import com.jerboa.toastException
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Response
import java.io.InputStream

suspend fun followCommunityWrapper(
    communityView: CommunityView,
    auth: String,
    ctx: Context?,
): CommunityResponse? {
    var communityRes: CommunityResponse? = null
    val api = API!!

    try {
        // Fetch the site to get more info, such as your
        // name and avatar
        val form = FollowCommunity(
            community_id = communityView.community.id,
            follow = communityView.subscribed == SubscribedType.NotSubscribed,
            auth = auth,
        )
        communityRes = retrofitErrorHandler(api.followCommunity(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return communityRes
}

suspend fun getSiteWrapper(
    auth: String?,
    ctx: Context?,
): GetSiteResponse? {
    var siteRes: GetSiteResponse? = null

    try {
        // Fetch the site to get more info, such as your
        // name and avatar
        val form = GetSite(auth = auth)
        siteRes = retrofitErrorHandler(API!!.getSite(form = form.serializeToMap()))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return siteRes
}

suspend fun getSiteMetadataWrapper(
    url: String,
    ctx: Context?,
): SiteMetadata? {
    var res: SiteMetadata? = null
    val api = API!!

    try {
        // Fetch the site to get more info, such as your
        // name and avatar
        val form = GetSiteMetadata(url = url)
        res = retrofitErrorHandler(api.getSiteMetadata(form = form.serializeToMap())).metadata
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return res
}

suspend fun fetchPostsWrapper(
    account: Account?,
    ctx: Context?,
    communityIdOrName: Either<Int, String>? = null,
    sortType: SortType,
    listingType: ListingType,
    page: Int,

    ): List<PostView> {
    var posts = listOf<PostView>()
    val api = API!!

    val communityId = communityIdOrName?.fold({ it }, { null })
    val communityName = communityIdOrName?.fold({ null }, { it })

    try {
        val form = GetPosts(
            community_id = communityId,
            community_name = communityName,
            sort = sortType,
            type_ = listingType,
            page = page,
            auth = account?.jwt,
            limit = null,
            saved_only = false,
        )
        posts = retrofitErrorHandler(api.getPosts(form = form.serializeToMap())).posts
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }

    return posts
}

suspend fun searchWrapper(
    account: Account?,
    ctx: Context?,
    communityId: Int? = null,
    sortType: SortType,
    listingType: ListingType,
    searchType: SearchType,
    page: Int? = null,
    query: String,
    creatorId: Int? = null,
): SearchResponse? {
    var res: SearchResponse? = null
    val api = API!!

    try {
        val form = Search(
            q = query,
            type_ = searchType,
            creator_id = creatorId,
            community_id = communityId,
            sort = sortType,
            listing_type = listingType,
            page = page,
            auth = account?.jwt,
            community_name = null,
            limit = null,
        )
        res = retrofitErrorHandler(api.search(form = form.serializeToMap()))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }

    return res
}

suspend fun createPostWrapper(
    account: Account,
    ctx: Context?,
    communityId: Int,
    body: String?,
    url: String?,
    name: String,
): PostView? {
    var createdPostView: PostView? = null
    val api = API!!

    try {
        val form = CreatePost(
            name = name,
            community_id = communityId,
            body = body,
            url = url,
            auth = account.jwt,
            honeypot = null,
            language_id = null,
            nsfw = null,
        )
        Log.d(
            "jerboa",
            "Creating post: $form",
        )
        createdPostView = retrofitErrorHandler(api.createPost(form)).postView
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return createdPostView
}

suspend fun editPostWrapper(
    postView: PostView,
    account: Account,
    ctx: Context?,
    body: String?,
    url: String?,
    name: String,
): PostView? {
    var editedPostView: PostView? = null
    val api = API!!

    try {
        val form = EditPost(
            post_id = postView.post.id,
            name = name,
            body = body,
            url = url,
            auth = account.jwt,
            language_id = postView.post.language_id,
            nsfw = postView.post.nsfw,
        )
        editedPostView = retrofitErrorHandler(api.editPost(form)).postView
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return editedPostView
}

suspend fun deletePostWrapper(
    form: DeletePost,
    ctx: Context,
): PostResponse? {
    var deletedPost: PostResponse? = null
    val api = API!!

    try {
        deletedPost = retrofitErrorHandler(api.deletePost(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return deletedPost
}

suspend fun likePostWrapper(
    pv: PostView,
    voteType: VoteType,
    account: Account,
    ctx: Context,
): PostResponse? {
    var updatedPost: PostResponse? = null
    val api = API!!
    try {
        val newVote = newVote(currentVote = pv.my_vote, voteType = voteType)
        val form = CreatePostLike(
            postId = pv.post.id,
            score = newVote,
            auth = account.jwt,
        )
        updatedPost = retrofitErrorHandler(api.likePost(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return updatedPost
}

suspend fun likeCommentWrapper(
    commentId: Int,
    myVote: Int?,
    voteType: VoteType,
    account: Account,
    ctx: Context,
): CommentResponse? {
    var updatedComment: CommentResponse? = null
    val api = API!!
    try {
        val newVote = newVote(currentVote = myVote, voteType = voteType)
        val form = CreateCommentLike(
            comment_id = commentId,
            score = newVote,
            auth = account.jwt,
        )
        updatedComment = retrofitErrorHandler(api.likeComment(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return updatedComment
}

suspend fun savePostWrapper(
    pv: PostView,
    account: Account,
    ctx: Context,
): PostResponse? {
    var updatedPost: PostResponse? = null
    val api = API!!
    try {
        val form = SavePost(
            postId = pv.post.id,
            save = !pv.saved,
            auth = account.jwt,
        )
        updatedPost = retrofitErrorHandler(api.savePost(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return updatedPost
}

suspend fun saveCommentWrapper(
    commentId: Int,
    saved: Boolean,
    account: Account,
    ctx: Context,
): CommentResponse? {
    var updatedComment: CommentResponse? = null
    val api = API!!
    try {
        val form = SaveComment(
            comment_id = commentId,
            save = !saved,
            auth = account.jwt,
        )
        updatedComment = retrofitErrorHandler(api.saveComment(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return updatedComment
}

suspend fun markCommentReplyAsReadWrapper(
    crv: CommentReplyView,
    account: Account,
    ctx: Context,
): CommentReplyResponse? {
    val api = API!!
    try {
        val form = MarkCommentReplyAsRead(
            comment_reply_id = crv.comment_reply.id,
            read = !crv.comment_reply.read,
            auth = account.jwt,
        )
        return retrofitErrorHandler(api.markCommentReplyAsRead(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return null
}

suspend fun markPersonMentionAsReadWrapper(
    personMentionView: PersonMentionView,
    account: Account,
    ctx: Context,
): PersonMentionResponse? {
    var updatedPm: PersonMentionResponse? = null
    val api = API!!
    try {
        val form = MarkPersonMentionAsRead(
            person_mention_id = personMentionView.person_mention.id,
            read = !personMentionView.person_mention.read,
            auth = account
                .jwt,
        )
        updatedPm = retrofitErrorHandler(api.markPersonMentionAsRead(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return updatedPm
}

suspend fun markPrivateMessageAsReadWrapper(
    pm: PrivateMessageView,
    account: Account,
    ctx: Context,
): PrivateMessageResponse? {
    var updatedPm: PrivateMessageResponse? = null
    val api = API!!
    try {
        val form = MarkPrivateMessageAsRead(
            private_message_id = pm.private_message.id,
            read = !pm.private_message.read,
            auth = account
                .jwt,
        )
        updatedPm = retrofitErrorHandler(api.markPrivateMessageAsRead(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return updatedPm
}

suspend fun createCommentWrapper(
    form: CreateComment,
    ctx: Context,
): CommentResponse? {
    var createdComment: CommentResponse? = null
    val api = API!!

    try {
        createdComment = retrofitErrorHandler(api.createComment(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return createdComment
}

suspend fun editCommentWrapper(
    form: EditComment,
    ctx: Context,
): CommentResponse? {
    var editedComment: CommentResponse? = null
    val api = API!!

    try {
        editedComment = retrofitErrorHandler(api.editComment(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return editedComment
}

suspend fun deleteCommentWrapper(
    form: DeleteComment,
    ctx: Context,
): CommentResponse? {
    var deletedComment: CommentResponse? = null
    val api = API!!

    try {
        deletedComment = retrofitErrorHandler(api.deleteComment(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return deletedComment
}

suspend fun createPrivateMessageWrapper(
    form: CreatePrivateMessage,
    ctx: Context,
): PrivateMessageResponse? {
    var createdPrivateMessage: PrivateMessageResponse? = null
    val api = API!!

    try {
        createdPrivateMessage = retrofitErrorHandler(api.createPrivateMessage(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return createdPrivateMessage
}

suspend fun createCommentReportWrapper(
    form: CreateCommentReport,
    ctx: Context,
): CommentReportResponse? {
    var createdReport: CommentReportResponse? = null
    val api = API!!

    try {
        createdReport = retrofitErrorHandler(api.createCommentReport(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return createdReport
}

suspend fun createPostReportWrapper(
    form: CreatePostReport,
    ctx: Context,
): PostReportResponse? {
    var createdReport: PostReportResponse? = null
    val api = API!!

    try {
        createdReport = retrofitErrorHandler(api.createPostReport(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return createdReport
}

suspend fun blockPersonWrapper(
    form: BlockPerson,
    ctx: Context,
): BlockPersonResponse? {
    var blockPersonRes: BlockPersonResponse? = null
    val api = API!!

    try {
        blockPersonRes = retrofitErrorHandler(api.blockPerson(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return blockPersonRes
}

suspend fun blockCommunityWrapper(
    form: BlockCommunity,
    ctx: Context,
): BlockCommunityResponse? {
    var blockCommunityRes: BlockCommunityResponse? = null
    val api = API!!

    try {
        blockCommunityRes = retrofitErrorHandler(api.blockCommunity(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return blockCommunityRes
}

suspend fun saveUserSettingsWrapper(
    form: SaveUserSettings,
    ctx: Context,
): LoginResponse? {
    var saveUserSettingsResponse: LoginResponse? = null
    val api = API!!

    try {
        saveUserSettingsResponse = retrofitErrorHandler(api.saveUserSettings(form))
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return saveUserSettingsResponse
}

suspend fun uploadPictrsImage(account: Account, imageIs: InputStream, ctx: Context): String? {
    var imageUrl: String? = null
    val api = API!!
    try {
        Log.d("jerboa", "Uploading image....")
        val part = MultipartBody.Part.createFormData(
            "images[]",
            "myPic",
            imageIs.readBytes().toRequestBody(),
        )
        val url = "https://${API!!.currentInstance}/pictrs/image"
        val cookie = "jwt=${account.jwt}"
        val images = retrofitErrorHandler(api.uploadImage(url, cookie, part))
        Log.d("jerboa", "Uploading done.")
        imageUrl = "$url/${images.files?.get(0)?.file}"
    } catch (e: Exception) {
        toastException(ctx = ctx, error = e)
    }
    return imageUrl
}

fun <T> retrofitErrorHandler(res: Response<T>): T {
    if (res.isSuccessful) {
        return res.body()!!
    } else {
        val errMsg = res.errorBody()?.string()?.let {
            JSONObject(it).getString("error")
        } ?: run {
            res.code().toString()
        }

        throw Exception(errMsg)
    }
}
