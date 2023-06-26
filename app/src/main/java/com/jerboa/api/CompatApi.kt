package com.jerboa.api

import retrofit2.Response
import com.jerboa.api.types.*
import okhttp3.MultipartBody

var API: CompatApi? = null
val DEFAULT_INSTANCE = "https://lemmy.ml"

interface CompatApi {
    var currentInstance: String

    suspend fun getSite(form: Map<String, String>): Response<GetSiteResponse>

    suspend fun createSite(form: CreateSite): Response<SiteResponse>

    suspend fun editSite(form: EditSite): Response<SiteResponse>

    suspend fun leaveAdmin(form: LeaveAdmin): Response<GetSiteResponse>

    suspend fun getModlog(form: Map<String, String>): Response<GetModlogResponse>

    suspend fun search(form: Map<String, String>): Response<SearchResponse>

    suspend fun resolveObject(form: Map<String, String>): Response<ResolveObjectResponse>

    suspend fun createCommunity(form: CreateCommunity): Response<CommunityResponse>

    suspend fun getCommunity(form: Map<String, String>): Response<GetCommunityResponse>

    suspend fun editCommunity(form: EditCommunity): Response<CommunityResponse>

    suspend fun listCommunities(form: Map<String, String>): Response<ListCommunitiesResponse>

    suspend fun followCommunity(form: FollowCommunity): Response<CommunityResponse>

    suspend fun blockCommunity(form: BlockCommunity): Response<BlockCommunityResponse>

    suspend fun deleteCommunity(form: DeleteCommunity): Response<CommunityResponse>

    suspend fun removeCommunity(form: RemoveCommunity): Response<CommunityResponse>

    suspend fun transferCommunity(form: TransferCommunity): Response<GetCommunityResponse>

    suspend fun banFromCommunity(form: BanFromCommunity): Response<BanFromCommunityResponse>

    suspend fun addModToCommunity(form: AddModToCommunity): Response<AddModToCommunityResponse>

    suspend fun createPost(form: CreatePost): Response<PostResponse>

    suspend fun getPost(form: Map<String, String>): Response<GetPostResponse>

    suspend fun editPost(form: EditPost): Response<PostResponse>

    suspend fun deletePost(form: DeletePost): Response<PostResponse>

    suspend fun removePost(form: RemovePost): Response<PostResponse>

    suspend fun markPostAsRead(form: MarkPostAsRead): Response<PostResponse>

    suspend fun lockPost(form: LockPost): Response<PostResponse>

    suspend fun featurePost(form: FeaturePost): Response<PostResponse>

    suspend fun getPosts(form: Map<String, String>): Response<GetPostsResponse>

    suspend fun likePost(form: CreatePostLike): Response<PostResponse>

    suspend fun savePost(form: SavePost): Response<PostResponse>

    suspend fun createPostReport(form: CreatePostReport): Response<PostReportResponse>

    suspend fun resolvePostReport(form: ResolvePostReport): Response<PostReportResponse>

    suspend fun listPostReports(form: Map<String, String>): Response<ListPostReportsResponse>

    suspend fun getSiteMetadata(form: Map<String, String>): Response<GetSiteMetadataResponse>

    suspend fun createComment(form: CreateComment): Response<CommentResponse>

    suspend fun editComment(form: EditComment): Response<CommentResponse>

    suspend fun deleteComment(form: DeleteComment): Response<CommentResponse>

    suspend fun removeComment(form: RemoveComment): Response<CommentResponse>

    suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Response<CommentReplyResponse>

    suspend fun likeComment(form: CreateCommentLike): Response<CommentResponse>

    suspend fun saveComment(form: SaveComment): Response<CommentResponse>

    suspend fun distinguishComment(form: DistinguishComment): Response<CommentResponse>

    suspend fun getComments(form: Map<String, String>): Response<GetCommentsResponse>

    suspend fun getComment(form: Map<String, String>): Response<CommentResponse>

    suspend fun createCommentReport(form: CreateCommentReport): Response<CommentReportResponse>

    suspend fun resolveCommentReport(form: ResolveCommentReport): Response<CommentReportResponse>

    suspend fun listCommentReports(form: Map<String, String>): Response<ListCommentReportsResponse>

    suspend fun getPrivateMessages(form: Map<String, String>): Response<PrivateMessagesResponse>

    suspend fun createPrivateMessage(form: CreatePrivateMessage): Response<PrivateMessageResponse>

    suspend fun editPrivateMessage(form: EditPrivateMessage): Response<PrivateMessageResponse>

    suspend fun deletePrivateMessage(form: DeletePrivateMessage): Response<PrivateMessageResponse>

    suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Response<PrivateMessageResponse>

    suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Response<PrivateMessageReportResponse>

    suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Response<PrivateMessageReportResponse>

    suspend fun listPrivateMessageReports(form: Map<String, String>): Response<ListPrivateMessageReportsResponse>

    suspend fun register(form: Register): Response<LoginResponse>

    suspend fun login(form: Login): Response<LoginResponse>

    suspend fun getPersonDetails(form: Map<String, String>): Response<GetPersonDetailsResponse>

    suspend fun getPersonMentions(form: Map<String, String>): Response<GetPersonMentionsResponse>

    suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Response<PersonMentionResponse>

    suspend fun getReplies(form: Map<String, String>): Response<GetRepliesResponse>

    suspend fun banPerson(form: BanPerson): Response<BanPersonResponse>

    suspend fun getBannedPersons(form: Map<String, String>): Response<BannedPersonsResponse>

    suspend fun blockPerson(form: BlockPerson): Response<BlockPersonResponse>

    suspend fun getCaptcha(form: Map<String, String>): Response<GetCaptchaResponse>

    suspend fun deleteAccount(form: DeleteAccount): Response<DeleteAccountResponse>

    suspend fun passwordReset(form: PasswordReset): Response<PasswordResetResponse>

    suspend fun passwordChangeAfterReset(form: PasswordChangeAfterReset): Response<LoginResponse>

    suspend fun markAllAsRead(form: MarkAllAsRead): Response<GetRepliesResponse>

    suspend fun saveUserSettings(form: SaveUserSettings): Response<LoginResponse>

    suspend fun changePassword(form: ChangePassword): Response<LoginResponse>

    suspend fun getReportCount(form: Map<String, String>): Response<GetReportCountResponse>

    suspend fun getUnreadCount(form: Map<String, String>): Response<GetUnreadCountResponse>

    suspend fun verifyEmail(form: VerifyEmail): Response<VerifyEmailResponse>

    suspend fun addAdmin(form: AddAdmin): Response<AddAdminResponse>

    suspend fun getUnreadRegistrationApplicationCount(form: Map<String, String>): Response<GetUnreadRegistrationApplicationCountResponse>

    suspend fun listRegistrationApplications(form: Map<String, String>): Response<ListRegistrationApplicationsResponse>

    suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Response<RegistrationApplicationResponse>

    suspend fun purgePerson(form: PurgePerson): Response<PurgeItemResponse>

    suspend fun purgeCommunity(form: PurgeCommunity): Response<PurgeItemResponse>

    suspend fun purgePost(form: PurgePost): Response<PurgeItemResponse>

    suspend fun purgeComment(form: PurgeComment): Response<PurgeItemResponse>

    suspend fun createCustomEmoji(form: CreateCustomEmoji): Response<CustomEmojiResponse>

    suspend fun editCustomEmoji(form: EditCustomEmoji): Response<CustomEmojiResponse>

    suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Response<DeleteCustomEmojiResponse>

    suspend fun getFederatedInstances(form: Map<String, String>): Response<GetFederatedInstancesResponse>

    // TODO: Is this the right way to do this?
    suspend fun uploadImage(url: String, token: String, filePart: MultipartBody.Part,): Response<UploadImageResponse>
}
