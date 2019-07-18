package clem.app.mymvvm

import clem.app.mymvvm.model.bean.WanResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.Serializable

/**
 * Created by Lu
 * on 2018/3/15 21:53
 */

suspend fun executeResponse(response: WanResponse<Any>, successBlock: suspend CoroutineScope.() -> Unit,
                            errorBlock: suspend CoroutineScope.() -> Unit) {
    coroutineScope {
        if (response.errorCode == -1) errorBlock()
        else successBlock()
    }
}
