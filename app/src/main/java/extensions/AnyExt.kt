package com.andrewkingmarshall.beachbuddy.extensions

import android.content.Context
import android.widget.Toast

const val SHARED_PREFS_NAME = "StarWarsPocketGuideSharedPrefs"

fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(context, this.toString(), duration).apply { show() }
}

fun Any.saveToSharedPrefs(context: Context, key: String) {

    val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    val editor = sharedPrefs.edit()

    when (this::class) {
        Boolean::class -> editor.putBoolean(key, this as Boolean)
        Float::class -> editor.putFloat(key, this as Float)
        Int::class -> editor.putInt(key, this as Int)
        Long::class -> editor.putLong(key, this as Long)
        String::class -> editor.putString(key, this as String)
        else -> {
            // Todo: serialize and save as String...
        }
    }

    editor.apply()
}

inline fun <reified T> getFromSharedPrefs(context: Context, key: String, defaultValue: T): T {
    val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    when (T::class) {
        Boolean::class -> return sharedPrefs.getBoolean(key, defaultValue as Boolean) as T
        Float::class -> return sharedPrefs.getFloat(key, defaultValue as Float) as T
        Int::class -> return sharedPrefs.getInt(key, defaultValue as Int) as T
        Long::class -> return sharedPrefs.getLong(key, defaultValue as Long) as T
        String::class -> return sharedPrefs.getString(key, defaultValue as String) as T
        else -> {
            // Todo: Deserialize from String
        }
    }

    return defaultValue
}