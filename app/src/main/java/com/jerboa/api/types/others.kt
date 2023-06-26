package com.jerboa.api.types

import java.nio.ByteBuffer

val VERSION: String = "v3"

/**
 * All of the websocket operations available.
 */
enum class UserOperation {
    Login,
    Register,
    GetCaptcha,
    CreateCommunity,
    CreatePost,
    ListCommunities,
    GetPost,
    GetCommunity,
    CreateComment,
    EditComment,
    DeleteComment,
    RemoveComment,
    SaveComment,
    CreateCommentLike,
    GetPosts,
    CreatePostLike,
    EditPost,
    DeletePost,
    RemovePost,
    LockPost,
    FeaturePost,
    MarkPostAsRead,
    SavePost,
    EditCommunity,
    DeleteCommunity,
    RemoveCommunity,
    FollowCommunity,
    GetPersonDetails,
    GetReplies,
    GetPersonMentions,
    MarkPersonMentionAsRead,
    MarkCommentReplyAsRead,
    GetModlog,
    BanFromCommunity,
    AddModToCommunity,
    CreateSite,
    EditSite,
    GetSite,
    AddAdmin,
    GetUnreadRegistrationApplicationCount,
    ListRegistrationApplications,
    ApproveRegistrationApplication,
    BanPerson,
    GetBannedPersons,
    Search,
    ResolveObject,
    MarkAllAsRead,
    SaveUserSettings,
    TransferCommunity,
    LeaveAdmin,
    DeleteAccount,
    PasswordReset,
    PasswordChangeAfterReset,
    CreatePrivateMessage,
    EditPrivateMessage,
    DeletePrivateMessage,
    MarkPrivateMessageAsRead,
    CreatePrivateMessageReport,
    ResolvePrivateMessageReport,
    ListPrivateMessageReports,
    GetPrivateMessages,
    UserJoin,
    GetComments,
    GetComment,
    PostJoin,
    CommunityJoin,
    ChangePassword,
    GetSiteMetadata,
    BlockCommunity,
    BlockPerson,
    PurgePerson,
    PurgeCommunity,
    PurgePost,
    PurgeComment,
    CreateCommentReport,
    ResolveCommentReport,
    ListCommentReports,
    CreatePostReport,
    ResolvePostReport,
    ListPostReports,
    GetReportCount,
    GetUnreadCount,
    VerifyEmail,
    CreateCustomEmoji,
    EditCustomEmoji,
    DeleteCustomEmoji,
    GetFederatedInstances,
}

data class UploadImage (
    val image: ByteBuffer,

    /**
     * Optional if cookie with jwt set is already present. Otherwise, auth is required.
     */
    val auth: String?,
 )

data class UploadImageResponse (
    /**
     * Is "ok" if the upload was successful; is something else otherwise.
     */
    val msg: String,
    val files: List<ImageFile>?,
    val url: String?,
    val delete_url: String?,
 )

data class ImageFile (
    val file: String,
    val delete_token: String,
 )
