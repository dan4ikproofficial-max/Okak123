package com.aimornai.pubgmenu

object Native {
    init { System.loadLibrary("native-lib") }
    external fun setBool(key: String, value: Boolean)
    external fun setInt(key: String, value: Int)
    external fun setFloat(key: String, value: Float)
    external fun setColor(key: String, argb: Int)
    external fun attachToGame(pid: Int): Boolean
    external fun startRender(): Boolean
    external fun stopRender()
}
