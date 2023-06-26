package com.jerboa.api.compat.v0_17_2

import com.jerboa.api.CompatApi
import com.jerboa.api.convert
import com.jerboa.api.convertResponse
import com.jerboa.api.types.AddAdmin
import com.jerboa.api.types.AddAdminResponse
import com.jerboa.api.types.AddModToCommunity
import com.jerboa.api.types.AddModToCommunityResponse
import com.jerboa.api.types.ApproveRegistrationApplication
import com.jerboa.api.types.BanFromCommunity
import com.jerboa.api.types.BanFromCommunityResponse
import com.jerboa.api.types.BanPerson
import com.jerboa.api.types.BanPersonResponse
import com.jerboa.api.types.BannedPersonsResponse
import com.jerboa.api.types.BlockCommunity
import com.jerboa.api.types.BlockCommunityResponse
import com.jerboa.api.types.BlockPerson
import com.jerboa.api.types.BlockPersonResponse
import com.jerboa.api.types.ChangePassword
import com.jerboa.api.types.CommentReplyResponse
import com.jerboa.api.types.CommentReportResponse
import com.jerboa.api.types.CommentResponse
import com.jerboa.api.types.CommunityResponse
import com.jerboa.api.types.CreateComment
import com.jerboa.api.types.CreateCommentLike
import com.jerboa.api.types.CreateCommentReport
import com.jerboa.api.types.CreateCommunity
import com.jerboa.api.types.CreateCustomEmoji
import com.jerboa.api.types.CreatePost
import com.jerboa.api.types.CreatePostLike
import com.jerboa.api.types.CreatePostReport
import com.jerboa.api.types.CreatePrivateMessage
import com.jerboa.api.types.CreatePrivateMessageReport
import com.jerboa.api.types.CreateSite
import com.jerboa.api.types.CustomEmojiResponse
import com.jerboa.api.types.DeleteAccount
import com.jerboa.api.types.DeleteAccountResponse
import com.jerboa.api.types.DeleteComment
import com.jerboa.api.types.DeleteCommunity
import com.jerboa.api.types.DeleteCustomEmoji
import com.jerboa.api.types.DeleteCustomEmojiResponse
import com.jerboa.api.types.DeletePost
import com.jerboa.api.types.DeletePrivateMessage
import com.jerboa.api.types.DistinguishComment
import com.jerboa.api.types.EditComment
import com.jerboa.api.types.EditCommunity
import com.jerboa.api.types.EditCustomEmoji
import com.jerboa.api.types.EditPost
import com.jerboa.api.types.EditPrivateMessage
import com.jerboa.api.types.EditSite
import com.jerboa.api.types.FeaturePost
import com.jerboa.api.types.FollowCommunity
import com.jerboa.api.types.GetCaptchaResponse
import com.jerboa.api.types.GetCommentsResponse
import com.jerboa.api.types.GetCommunityResponse
import com.jerboa.api.types.GetFederatedInstancesResponse
import com.jerboa.api.types.GetModlogResponse
import com.jerboa.api.types.GetPersonDetailsResponse
import com.jerboa.api.types.GetPersonMentionsResponse
import com.jerboa.api.types.GetPostResponse
import com.jerboa.api.types.GetPostsResponse
import com.jerboa.api.types.GetRepliesResponse
import com.jerboa.api.types.GetReportCountResponse
import com.jerboa.api.types.GetSiteMetadataResponse
import com.jerboa.api.types.GetSiteResponse
import com.jerboa.api.types.GetUnreadCountResponse
import com.jerboa.api.types.GetUnreadRegistrationApplicationCountResponse
import com.jerboa.api.types.LeaveAdmin
import com.jerboa.api.types.ListCommentReportsResponse
import com.jerboa.api.types.ListCommunitiesResponse
import com.jerboa.api.types.ListPostReportsResponse
import com.jerboa.api.types.ListPrivateMessageReportsResponse
import com.jerboa.api.types.ListRegistrationApplicationsResponse
import com.jerboa.api.types.LockPost
import com.jerboa.api.types.Login
import com.jerboa.api.types.LoginResponse
import com.jerboa.api.types.MarkAllAsRead
import com.jerboa.api.types.MarkCommentReplyAsRead
import com.jerboa.api.types.MarkPersonMentionAsRead
import com.jerboa.api.types.MarkPostAsRead
import com.jerboa.api.types.MarkPrivateMessageAsRead
import com.jerboa.api.types.PasswordChangeAfterReset
import com.jerboa.api.types.PasswordReset
import com.jerboa.api.types.PasswordResetResponse
import com.jerboa.api.types.PersonMentionResponse
import com.jerboa.api.types.PostReportResponse
import com.jerboa.api.types.PostResponse
import com.jerboa.api.types.PrivateMessageReportResponse
import com.jerboa.api.types.PrivateMessageResponse
import com.jerboa.api.types.PrivateMessagesResponse
import com.jerboa.api.types.PurgeComment
import com.jerboa.api.types.PurgeCommunity
import com.jerboa.api.types.PurgeItemResponse
import com.jerboa.api.types.PurgePerson
import com.jerboa.api.types.PurgePost
import com.jerboa.api.types.Register
import com.jerboa.api.types.RegistrationApplicationResponse
import com.jerboa.api.types.RemoveComment
import com.jerboa.api.types.RemoveCommunity
import com.jerboa.api.types.RemovePost
import com.jerboa.api.types.ResolveCommentReport
import com.jerboa.api.types.ResolveObjectResponse
import com.jerboa.api.types.ResolvePostReport
import com.jerboa.api.types.ResolvePrivateMessageReport
import com.jerboa.api.types.SaveComment
import com.jerboa.api.types.SavePost
import com.jerboa.api.types.SaveUserSettings
import com.jerboa.api.types.SearchResponse
import com.jerboa.api.types.SiteResponse
import com.jerboa.api.types.TransferCommunity
import com.jerboa.api.types.VerifyEmail
import com.jerboa.api.types.VerifyEmailResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ImplApi_0_17_2(private val instanceDomain: String) : CompatApi {
    private val api: API
    override val currentInstance: String = instanceDomain

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                    .header("User-Agent", "Jerboa")
                val newRequest = requestBuilder.build()
                chain.proceed(newRequest)
            }
            .addInterceptor(interceptor)
            .build()

        api = Retrofit.Builder()
            .baseUrl("https://$instanceDomain/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(API::class.java)
    }

    override suspend fun getSite(form: Map<String, String>): Response<GetSiteResponse> {
        return convertResponse(api.getSite(form))
    }

    override suspend fun createSite(form: CreateSite): Response<SiteResponse> {
        return convertResponse(api.createSite(form.convert()))
    }

    override suspend fun editSite(form: EditSite): Response<SiteResponse> {
        return convertResponse(api.editSite(form.convert()))
    }

    override suspend fun leaveAdmin(form: LeaveAdmin): Response<GetSiteResponse> {
        return convertResponse(api.leaveAdmin(form.convert()))
    }

    override suspend fun getModlog(form: Map<String, String>): Response<GetModlogResponse> {
        return convertResponse(api.getModlog(form))
    }

    override suspend fun search(form: Map<String, String>): Response<SearchResponse> {
        return convertResponse(api.search(form))
    }

    override suspend fun resolveObject(form: Map<String, String>): Response<ResolveObjectResponse> {
        return convertResponse(api.resolveObject(form))
    }

    override suspend fun createCommunity(form: CreateCommunity): Response<CommunityResponse> {
        return convertResponse(api.createCommunity(form.convert()))
    }

    override suspend fun getCommunity(form: Map<String, String>): Response<GetCommunityResponse> {
        return convertResponse(api.getCommunity(form))
    }

    override suspend fun editCommunity(form: EditCommunity): Response<CommunityResponse> {
        return convertResponse(api.editCommunity(form.convert()))
    }

    override suspend fun listCommunities(form: Map<String, String>): Response<ListCommunitiesResponse> {
        return convertResponse(api.listCommunities(form))
    }

    override suspend fun followCommunity(form: FollowCommunity): Response<CommunityResponse> {
        return convertResponse(api.followCommunity(form.convert()))
    }

    override suspend fun blockCommunity(form: BlockCommunity): Response<BlockCommunityResponse> {
        return convertResponse(api.blockCommunity(form.convert()))
    }

    override suspend fun deleteCommunity(form: DeleteCommunity): Response<CommunityResponse> {
        return convertResponse(api.deleteCommunity(form.convert()))
    }

    override suspend fun removeCommunity(form: RemoveCommunity): Response<CommunityResponse> {
        return convertResponse(api.removeCommunity(form.convert()))
    }

    override suspend fun transferCommunity(form: TransferCommunity): Response<GetCommunityResponse> {
        return convertResponse(api.transferCommunity(form.convert()))
    }

    override suspend fun banFromCommunity(form: BanFromCommunity): Response<BanFromCommunityResponse> {
        return convertResponse(api.banFromCommunity(form.convert()))
    }

    override suspend fun addModToCommunity(form: AddModToCommunity): Response<AddModToCommunityResponse> {
        return convertResponse(api.addModToCommunity(form.convert()))
    }

    override suspend fun createPost(form: CreatePost): Response<PostResponse> {
        return convertResponse(api.createPost(form.convert()))
    }

    override suspend fun getPost(form: Map<String, String>): Response<GetPostResponse> {
        return convertResponse(api.getPost(form))
    }

    override suspend fun editPost(form: EditPost): Response<PostResponse> {
        return convertResponse(api.editPost(form.convert()))
    }

    override suspend fun deletePost(form: DeletePost): Response<PostResponse> {
        return convertResponse(api.deletePost(form.convert()))
    }

    override suspend fun removePost(form: RemovePost): Response<PostResponse> {
        return convertResponse(api.removePost(form.convert()))
    }

    override suspend fun markPostAsRead(form: MarkPostAsRead): Response<PostResponse> {
        return convertResponse(api.markPostAsRead(form.convert()))
    }

    override suspend fun lockPost(form: LockPost): Response<PostResponse> {
        return convertResponse(api.lockPost(form.convert()))
    }

    override suspend fun featurePost(form: FeaturePost): Response<PostResponse> {
        return convertResponse(api.featurePost(form.convert()))
    }

    override suspend fun getPosts(form: Map<String, String>): Response<GetPostsResponse> {
        return convertResponse(api.getPosts(form))
    }

    override suspend fun likePost(form: CreatePostLike): Response<PostResponse> {
        return convertResponse(api.likePost(form.convert()))
    }

    override suspend fun savePost(form: SavePost): Response<PostResponse> {
        return convertResponse(api.savePost(form.convert()))
    }

    override suspend fun createPostReport(form: CreatePostReport): Response<PostReportResponse> {
        return convertResponse(api.createPostReport(form.convert()))
    }

    override suspend fun resolvePostReport(form: ResolvePostReport): Response<PostReportResponse> {
        return convertResponse(api.resolvePostReport(form.convert()))
    }

    override suspend fun listPostReports(form: Map<String, String>): Response<ListPostReportsResponse> {
        return convertResponse(api.listPostReports(form))
    }

    override suspend fun getSiteMetadata(form: Map<String, String>): Response<GetSiteMetadataResponse> {
        return convertResponse(api.getSiteMetadata(form))
    }

    override suspend fun createComment(form: CreateComment): Response<CommentResponse> {
        return convertResponse(api.createComment(form.convert()))
    }

    override suspend fun editComment(form: EditComment): Response<CommentResponse> {
        return convertResponse(api.editComment(form.convert()))
    }

    override suspend fun deleteComment(form: DeleteComment): Response<CommentResponse> {
        return convertResponse(api.deleteComment(form.convert()))
    }

    override suspend fun removeComment(form: RemoveComment): Response<CommentResponse> {
        return convertResponse(api.removeComment(form.convert()))
    }

    override suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Response<CommentReplyResponse> {
        return convertResponse(api.markCommentReplyAsRead(form.convert()))
    }

    override suspend fun likeComment(form: CreateCommentLike): Response<CommentResponse> {
        return convertResponse(api.likeComment(form.convert()))
    }

    override suspend fun saveComment(form: SaveComment): Response<CommentResponse> {
        return convertResponse(api.saveComment(form.convert()))
    }

    override suspend fun distinguishComment(form: DistinguishComment): Response<CommentResponse> {
        return convertResponse(api.distinguishComment(form.convert()))
    }

    override suspend fun getComments(form: Map<String, String>): Response<GetCommentsResponse> {
        return convertResponse(api.getComments(form))
    }

    override suspend fun getComment(form: Map<String, String>): Response<CommentResponse> {
        return convertResponse(api.getComment(form))
    }

    override suspend fun createCommentReport(form: CreateCommentReport): Response<CommentReportResponse> {
        return convertResponse(api.createCommentReport(form.convert()))
    }

    override suspend fun resolveCommentReport(form: ResolveCommentReport): Response<CommentReportResponse> {
        return convertResponse(api.resolveCommentReport(form.convert()))
    }

    override suspend fun listCommentReports(form: Map<String, String>): Response<ListCommentReportsResponse> {
        return convertResponse(api.listCommentReports(form))
    }

    override suspend fun getPrivateMessages(form: Map<String, String>): Response<PrivateMessagesResponse> {
        return convertResponse(api.getPrivateMessages(form))
    }

    override suspend fun createPrivateMessage(form: CreatePrivateMessage): Response<PrivateMessageResponse> {
        return convertResponse(api.createPrivateMessage(form.convert()))
    }

    override suspend fun editPrivateMessage(form: EditPrivateMessage): Response<PrivateMessageResponse> {
        return convertResponse(api.editPrivateMessage(form.convert()))
    }

    override suspend fun deletePrivateMessage(form: DeletePrivateMessage): Response<PrivateMessageResponse> {
        return convertResponse(api.deletePrivateMessage(form.convert()))
    }

    override suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Response<PrivateMessageResponse> {
        return convertResponse(api.markPrivateMessageAsRead(form.convert()))
    }

    override suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Response<PrivateMessageReportResponse> {
        return convertResponse(api.createPrivateMessageReport(form.convert()))
    }

    override suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Response<PrivateMessageReportResponse> {
        return convertResponse(api.resolvePrivateMessageReport(form.convert()))
    }

    override suspend fun listPrivateMessageReports(form: Map<String, String>): Response<ListPrivateMessageReportsResponse> {
        return convertResponse(api.listPrivateMessageReports(form))
    }

    override suspend fun register(form: Register): Response<LoginResponse> {
        return convertResponse(api.register(form.convert()))
    }

    override suspend fun login(form: Login): Response<LoginResponse> {
        return convertResponse(api.login(form.convert()))
    }

    override suspend fun getPersonDetails(form: Map<String, String>): Response<GetPersonDetailsResponse> {
        return convertResponse(api.getPersonDetails(form))
    }

    override suspend fun getPersonMentions(form: Map<String, String>): Response<GetPersonMentionsResponse> {
        return convertResponse(api.getPersonMentions(form))
    }

    override suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Response<PersonMentionResponse> {
        return convertResponse(api.markPersonMentionAsRead(form.convert()))
    }

    override suspend fun getReplies(form: Map<String, String>): Response<GetRepliesResponse> {
        return convertResponse(api.getReplies(form))
    }

    override suspend fun banPerson(form: BanPerson): Response<BanPersonResponse> {
        return convertResponse(api.banPerson(form.convert()))
    }

    override suspend fun getBannedPersons(form: Map<String, String>): Response<BannedPersonsResponse> {
        return convertResponse(api.getBannedPersons(form))
    }

    override suspend fun blockPerson(form: BlockPerson): Response<BlockPersonResponse> {
        return convertResponse(api.blockPerson(form.convert()))
    }

    override suspend fun getCaptcha(form: Map<String, String>): Response<GetCaptchaResponse> {
        return convertResponse(api.getCaptcha(form))
    }

    override suspend fun deleteAccount(form: DeleteAccount): Response<DeleteAccountResponse> {
        TODO()
    }

    override suspend fun passwordReset(form: PasswordReset): Response<PasswordResetResponse> {
        TODO()
    }

    override suspend fun passwordChangeAfterReset(form: PasswordChangeAfterReset): Response<LoginResponse> {
        return convertResponse(api.passwordChangeAfterReset(form.convert()))
    }

    override suspend fun markAllAsRead(form: MarkAllAsRead): Response<GetRepliesResponse> {
        return convertResponse(api.markAllAsRead(form.convert()))
    }

    override suspend fun saveUserSettings(form: SaveUserSettings): Response<LoginResponse> {
        return convertResponse(api.saveUserSettings(form.convert()))
    }

    override suspend fun changePassword(form: ChangePassword): Response<LoginResponse> {
        return convertResponse(api.changePassword(form.convert()))
    }

    override suspend fun getReportCount(form: Map<String, String>): Response<GetReportCountResponse> {
        return convertResponse(api.getReportCount(form))
    }

    override suspend fun getUnreadCount(form: Map<String, String>): Response<GetUnreadCountResponse> {
        return convertResponse(api.getUnreadCount(form))
    }

    override suspend fun verifyEmail(form: VerifyEmail): Response<VerifyEmailResponse> {
        TODO()
    }

    override suspend fun addAdmin(form: AddAdmin): Response<AddAdminResponse> {
        return convertResponse(api.addAdmin(form.convert()))
    }

    override suspend fun getUnreadRegistrationApplicationCount(form: Map<String, String>): Response<GetUnreadRegistrationApplicationCountResponse> {
        return convertResponse(api.getUnreadRegistrationApplicationCount(form))
    }

    override suspend fun listRegistrationApplications(form: Map<String, String>): Response<ListRegistrationApplicationsResponse> {
        return convertResponse(api.listRegistrationApplications(form))
    }

    override suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Response<RegistrationApplicationResponse> {
        return convertResponse(api.approveRegistrationApplication(form.convert()))
    }

    override suspend fun purgePerson(form: PurgePerson): Response<PurgeItemResponse> {
        return convertResponse(api.purgePerson(form.convert()))
    }

    override suspend fun purgeCommunity(form: PurgeCommunity): Response<PurgeItemResponse> {
        return convertResponse(api.purgeCommunity(form.convert()))
    }

    override suspend fun purgePost(form: PurgePost): Response<PurgeItemResponse> {
        return convertResponse(api.purgePost(form.convert()))
    }

    override suspend fun purgeComment(form: PurgeComment): Response<PurgeItemResponse> {
        return convertResponse(api.purgeComment(form.convert()))
    }

    override suspend fun createCustomEmoji(form: CreateCustomEmoji): Response<CustomEmojiResponse> {
        return convertResponse(api.createCustomEmoji(form.convert()))
    }

    override suspend fun editCustomEmoji(form: EditCustomEmoji): Response<CustomEmojiResponse> {
        return convertResponse(api.editCustomEmoji(form.convert()))
    }

    override suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Response<DeleteCustomEmojiResponse> {
        return convertResponse(api.deleteCustomEmoji(form.convert()))
    }

    override suspend fun getFederatedInstances(form: Map<String, String>): Response<GetFederatedInstancesResponse> {
        return convertResponse(api.getFederatedInstances(form))
    }
}
