package blip.chat.sdk.android.models

import org.json.JSONObject

enum class TYPE {
    PLAIN,
    EXTERNAL
}

open class BlipChatModel {
    var key: String? = null
    var type: TYPE? = null
    var token: String? = null
    var issuer: String? = null
    var hostName: String? = null
    var useMtls: Boolean? = null
    var account: BlipChatAccountModel? = null
    var style: BlipChatStyleModel? = null

    override fun toString(): String {
        var j = JSONObject()
        j.put("key", key)
        if (type == TYPE.EXTERNAL) {
            j.put("type", "external")
        } else {
            j.put("type", "plain")
        }
        j.put("token", token)
        j.put("issuer", issuer)
        j.put("hostName", hostName)
        j.put("useMtls", useMtls)
        account?.let {
            j.put("account", it.getJSON())
        }
        style?.let {
            j.put("style", it.getJSON())
        }
        return j.toString();
    }
}