package blip.chat.sdk.android.models

import org.json.JSONObject

open class BlipChatStyleModel {
    var primary: String? = null
    var sentBubble: String? = null
    var receivedBubble: String? = null
    var background: String? = null
    var showOwnerAvatar: Boolean? = null
    var showUserAvatar: Boolean? = null
    var overrideOwnerColors: Boolean? = null

    fun getJSON(): JSONObject {
        var j = JSONObject()
        j.put("primary", primary)
        j.put("sentBubble", sentBubble)
        j.put("receivedBubble", receivedBubble)
        j.put("background", background)
        j.put("showOwnerAvatar", showOwnerAvatar)
        j.put("showUserAvatar", showUserAvatar)
        j.put("overrideOwnerColors", overrideOwnerColors)
        return j;
    }
}