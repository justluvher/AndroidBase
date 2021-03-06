package tech.thdev.base.util

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by tae-hwan on 8/17/16.
 */

/**
 * Content v4.fragment replace.
 */
fun AppCompatActivity.replaceContentFragment(@IdRes frameId: Int, fragment: android.support.v4.app.Fragment) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment)?.commit()
}

/**
 * Content app.fragment replace.
 */
fun Activity.replaceContentFragment(@IdRes frameId: Int, fragment: android.app.Fragment) {
    fragmentManager.beginTransaction().replace(frameId, fragment).commit()
}

/**
 * find fragment by IdRes.
 */
fun AppCompatActivity.getContentFragment(@IdRes frameId: Int)
        = supportFragmentManager.findFragmentById(frameId)


fun <E> Context?.startServiceClass(cls: Class<E>?) {
    this?.let {
        val intent = Intent(it, cls)
        it.startService(intent)
    }
}

fun <E> Context?.stopServiceClass(cls: Class<E>?) {
    this?.let {
        val intent = Intent(it, cls)
        it.stopService(intent)
    }
}

fun Context?.registerReceiverAction(broadcastReceiver: BroadcastReceiver, actionList: List<String>? = null) {
    this?.let {
        val intentFilter = IntentFilter()
        actionList?.filterNotNull()?.forEach { intentFilter.addAction(it) }
        it.registerReceiver(broadcastReceiver, intentFilter)
    }
}
