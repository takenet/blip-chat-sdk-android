package blip.chat.sdk.android.models

import org.json.JSONObject

open class BlipChatAccountModel {
    var pushToken: String? = null
    var email: String? = null
    var fullName: String? = null
    var photoUri: String? = null
    var encryptMessageContent: Boolean? = null
    fun getJSON(): JSONObject {
        var j = JSONObject()
        j.put("pushToken", pushToken)
        j.put("email", email)
        j.put("fullName", fullName)
        j.put("photoUri", photoUri)
        j.put("encryptMessageContent", encryptMessageContent)
        return j;
    }
}