package kittoku.osc.preference.accessor

import android.content.SharedPreferences
import kittoku.osc.preference.OscPreference


internal fun getStringPrefValue(key: OscPreference, prefs: SharedPreferences): String {
    val defaultValue = when (key) {
        OscPreference.HOME_PROFILE -> "My SSTP"
        OscPreference.HOME_HOSTNAME,
        OscPreference.HOME_USERNAME,
        OscPreference.HOME_PASSWORD,
        OscPreference.HOME_STATUS,
        OscPreference.DNS_CUSTOM_ADDRESS,
        OscPreference.ROUTE_CUSTOM_ROUTES -> ""
        OscPreference.SSL_VERSION -> "DEFAULT"
        else -> throw NotImplementedError()
    }

    return prefs.getString(key.name, defaultValue)!!
}

internal fun setStringPrefValue(value: String, key: OscPreference, prefs: SharedPreferences) {
    prefs.edit().also {
        it.putString(key.name, value)
        it.apply()
    }
}
