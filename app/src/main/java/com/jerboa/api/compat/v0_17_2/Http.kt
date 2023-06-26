package com.jerboa.api.compat.v0_17_2

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap
import com.jerboa.api.compat.v0_17_2.types.*
import retrofit2.http.PUT

interface API {
    @GET("site")
    suspend fun getSite(@QueryMap form: Map<String, String>): Response<GetSiteResponse>

    @POST("site")
    suspend fun createSite(@Body form: CreateSite): Response<SiteResponse>

    @PUT("site")
    suspend fun editSite(@Body form: EditSite): Response<SiteResponse>

    @POST("user/leave_admin")
    suspend fun leaveAdmin(@Body form: LeaveAdmin): Response<GetSiteResponse>

    @GET("modlog")
    suspend fun getModlog(@QueryMap form: Map<String, String>): Response<GetModlogResponse>

    @GET("search")
    suspend fun search(@QueryMap form: Map<String, String>): Response<SearchResponse>

    @GET("resolve_object")
    suspend fun resolveObject(@QueryMap form: Map<String, String>): Response<ResolveObjectResponse>

    @POST("community")
    suspend fun createCommunity(@Body form: CreateCommunity): Response<CommunityResponse>

    @GET("community")
    suspend fun getCommunity(@QueryMap form: Map<String, String>): Response<GetCommunityResponse>

    @PUT("community")
    suspend fun editCommunity(@Body form: EditCommunity): Response<CommunityResponse>

    @GET("community/list")
    suspend fun listCommunities(@QueryMap form: Map<String, String>): Response<ListCommunitiesResponse>

    @POST("community/follow")
    suspend fun followCommunity(@Body form: FollowCommunity): Response<CommunityResponse>

    @POST("community/block")
    suspend fun blockCommunity(@Body form: BlockCommunity): Response<BlockCommunityResponse>

    @POST("community/delete")
    suspend fun deleteCommunity(@Body form: DeleteCommunity): Response<CommunityResponse>

    @POST("community/remove")
    suspend fun removeCommunity(@Body form: RemoveCommunity): Response<CommunityResponse>

    @POST("community/transfer")
    suspend fun transferCommunity(@Body form: TransferCommunity): Response<GetCommunityResponse>

    @POST("community/ban_user")
    suspend fun banFromCommunity(@Body form: BanFromCommunity): Response<BanFromCommunityResponse>

    @POST("community/mod")
    suspend fun addModToCommunity(@Body form: AddModToCommunity): Response<AddModToCommunityResponse>

    @POST("post")
    suspend fun createPost(@Body form: CreatePost): Response<PostResponse>

    @GET("post")
    suspend fun getPost(@QueryMap form: Map<String, String>): Response<GetPostResponse>

    @PUT("post")
    suspend fun editPost(@Body form: EditPost): Response<PostResponse>

    @POST("post/delete")
    suspend fun deletePost(@Body form: DeletePost): Response<PostResponse>

    @POST("post/remove")
    suspend fun removePost(@Body form: RemovePost): Response<PostResponse>

    @POST("post/mark_as_read")
    suspend fun markPostAsRead(@Body form: MarkPostAsRead): Response<PostResponse>

    @POST("post/lock")
    suspend fun lockPost(@Body form: LockPost): Response<PostResponse>

    @POST("post/feature")
    suspend fun featurePost(@Body form: FeaturePost): Response<PostResponse>

    @GET("post/list")
    suspend fun getPosts(@QueryMap form: Map<String, String>): Response<GetPostsResponse>

    @POST("post/like")
    suspend fun likePost(@Body form: CreatePostLike): Response<PostResponse>

    @PUT("post/save")
    suspend fun savePost(@Body form: SavePost): Response<PostResponse>

    @POST("post/report")
    suspend fun createPostReport(@Body form: CreatePostReport): Response<PostReportResponse>

    @PUT("post/report/resolve")
    suspend fun resolvePostReport(@Body form: ResolvePostReport): Response<PostReportResponse>

    @GET("post/report/list")
    suspend fun listPostReports(@QueryMap form: Map<String, String>): Response<ListPostReportsResponse>

    @GET("post/site_metadata")
    suspend fun getSiteMetadata(@QueryMap form: Map<String, String>): Response<GetSiteMetadataResponse>

    @POST("comment")
    suspend fun createComment(@Body form: CreateComment): Response<CommentResponse>

    @PUT("comment")
    suspend fun editComment(@Body form: EditComment): Response<CommentResponse>

    @POST("comment/delete")
    suspend fun deleteComment(@Body form: DeleteComment): Response<CommentResponse>

    @POST("comment/remove")
    suspend fun removeComment(@Body form: RemoveComment): Response<CommentResponse>

    @POST("comment/mark_as_read")
    suspend fun markCommentReplyAsRead(@Body form: MarkCommentReplyAsRead): Response<CommentReplyResponse>

    @POST("comment/like")
    suspend fun likeComment(@Body form: CreateCommentLike): Response<CommentResponse>

    @PUT("comment/save")
    suspend fun saveComment(@Body form: SaveComment): Response<CommentResponse>

    @POST("comment/distinguish")
    suspend fun distinguishComment(@Body form: DistinguishComment): Response<CommentResponse>

    @GET("comment/list")
    suspend fun getComments(@QueryMap form: Map<String, String>): Response<GetCommentsResponse>

    @GET("comment")
    suspend fun getComment(@QueryMap form: Map<String, String>): Response<CommentResponse>

    @POST("comment/report")
    suspend fun createCommentReport(@Body form: CreateCommentReport): Response<CommentReportResponse>

    @PUT("comment/report/resolve")
    suspend fun resolveCommentReport(@Body form: ResolveCommentReport): Response<CommentReportResponse>

    @GET("comment/report/list")
    suspend fun listCommentReports(@QueryMap form: Map<String, String>): Response<ListCommentReportsResponse>

    @GET("/private_message/list")
    suspend fun getPrivateMessages(@QueryMap form: Map<String, String>): Response<PrivateMessagesResponse>

    @POST("private_message")
    suspend fun createPrivateMessage(@Body form: CreatePrivateMessage): Response<PrivateMessageResponse>

    @PUT("private_message")
    suspend fun editPrivateMessage(@Body form: EditPrivateMessage): Response<PrivateMessageResponse>

    @POST("private_message/delete")
    suspend fun deletePrivateMessage(@Body form: DeletePrivateMessage): Response<PrivateMessageResponse>

    @POST("private_message/mark_as_read")
    suspend fun markPrivateMessageAsRead(@Body form: MarkPrivateMessageAsRead): Response<PrivateMessageResponse>

    @POST("private_message/report")
    suspend fun createPrivateMessageReport(@Body form: CreatePrivateMessageReport): Response<PrivateMessageReportResponse>

    @PUT("private_message/report/resolve")
    suspend fun resolvePrivateMessageReport(@Body form: ResolvePrivateMessageReport): Response<PrivateMessageReportResponse>

    @GET("private_message/report/list")
    suspend fun listPrivateMessageReports(@QueryMap form: Map<String, String>): Response<ListPrivateMessageReportsResponse>

    @POST("user/register")
    suspend fun register(@Body form: Register): Response<LoginResponse>

    @POST("user/login")
    suspend fun login(@Body form: Login): Response<LoginResponse>

    @GET("user")
    suspend fun getPersonDetails(@QueryMap form: Map<String, String>): Response<GetPersonDetailsResponse>

    @GET("user/mention")
    suspend fun getPersonMentions(@QueryMap form: Map<String, String>): Response<GetPersonMentionsResponse>

    @POST("user/mention/mark_as_read")
    suspend fun markPersonMentionAsRead(@Body form: MarkPersonMentionAsRead): Response<PersonMentionResponse>

    @GET("user/replies")
    suspend fun getReplies(@QueryMap form: Map<String, String>): Response<GetRepliesResponse>

    @POST("user/ban")
    suspend fun banPerson(@Body form: BanPerson): Response<BanPersonResponse>

    @GET("user/banned")
    suspend fun getBannedPersons(@QueryMap form: Map<String, String>): Response<BannedPersonsResponse>

    @POST("user/block")
    suspend fun blockPerson(@Body form: BlockPerson): Response<BlockPersonResponse>

    @GET("user/get_captcha")
    suspend fun getCaptcha(@QueryMap form: Map<String, String>): Response<GetCaptchaResponse>

    @POST("user/delete_account")
    suspend fun deleteAccount(@Body form: DeleteAccount): Response<DeleteAccountResponse>

    @POST("user/password_reset")
    suspend fun passwordReset(@Body form: PasswordReset): Response<PasswordResetResponse>

    @POST("user/password_change")
    suspend fun passwordChangeAfterReset(@Body form: PasswordChangeAfterReset): Response<LoginResponse>

    @POST("user/mark_all_as_read")
    suspend fun markAllAsRead(@Body form: MarkAllAsRead): Response<GetRepliesResponse>

    @PUT("user/save_user_settings")
    suspend fun saveUserSettings(@Body form: SaveUserSettings): Response<LoginResponse>

    @PUT("user/change_password")
    suspend fun changePassword(@Body form: ChangePassword): Response<LoginResponse>

    @GET("user/report_count")
    suspend fun getReportCount(@QueryMap form: Map<String, String>): Response<GetReportCountResponse>

    @GET("user/unread_count")
    suspend fun getUnreadCount(@QueryMap form: Map<String, String>): Response<GetUnreadCountResponse>

    @POST("user/verify_email")
    suspend fun verifyEmail(@Body form: VerifyEmail): Response<VerifyEmailResponse>

    @POST("admin/add")
    suspend fun addAdmin(@Body form: AddAdmin): Response<AddAdminResponse>

    @GET("admin/registration_application/count")
    suspend fun getUnreadRegistrationApplicationCount(@QueryMap form: Map<String, String>): Response<GetUnreadRegistrationApplicationCountResponse>

    @GET("admin/registration_application/list")
    suspend fun listRegistrationApplications(@QueryMap form: Map<String, String>): Response<ListRegistrationApplicationsResponse>

    @PUT("admin/registration_application/approve")
    suspend fun approveRegistrationApplication(@Body form: ApproveRegistrationApplication): Response<RegistrationApplicationResponse>

    @POST("admin/purge/person")
    suspend fun purgePerson(@Body form: PurgePerson): Response<PurgeItemResponse>

    @POST("admin/purge/community")
    suspend fun purgeCommunity(@Body form: PurgeCommunity): Response<PurgeItemResponse>

    @POST("admin/purge/post")
    suspend fun purgePost(@Body form: PurgePost): Response<PurgeItemResponse>

    @POST("admin/purge/comment")
    suspend fun purgeComment(@Body form: PurgeComment): Response<PurgeItemResponse>

    @POST("custom_emoji")
    suspend fun createCustomEmoji(@Body form: CreateCustomEmoji): Response<CustomEmojiResponse>

    @PUT("custom_emoji")
    suspend fun editCustomEmoji(@Body form: EditCustomEmoji): Response<CustomEmojiResponse>

    @POST("custom_emoji/delete")
    suspend fun deleteCustomEmoji(@Body form: DeleteCustomEmoji): Response<DeleteCustomEmojiResponse>

    @GET("federated_instances")
    suspend fun getFederatedInstances(@QueryMap form: Map<String, String>): Response<GetFederatedInstancesResponse>
}
