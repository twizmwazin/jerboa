package com.jerboa.ui.components.community

import android.content.Context
import android.widget.Toast
import com.jerboa.R
import com.jerboa.api.blockCommunityWrapper
import com.jerboa.api.types.BlockCommunity
import com.jerboa.api.types.Community
import com.jerboa.db.Account
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun blockCommunityRoutine(
    community: Community,
    block: Boolean,
    account: Account,
    ctx: Context,
    scope: CoroutineScope,
) {
    scope.launch {
        val form = BlockCommunity(community.id, block, account.jwt)
        blockCommunityWrapper(form, ctx)
        Toast.makeText(
            ctx,
            ctx.getString(R.string.community_blocked, community.name),
            Toast.LENGTH_SHORT,
        ).show()
    }
}
