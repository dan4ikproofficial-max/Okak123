package com.aimornai.pubgmenu

import android.content.Context
import java.io.File

object PayloadLoader {
    const val WORK = "/data/local/tmp/.aimornai"
    fun load(ctx: Context) {
        RootShell.exec("mkdir -p $WORK")
        ctx.assets.list("")?.forEach { name ->
            if (name.endsWith(".so") || name.endsWith(".ko")) {
                val dst = File(ctx.cacheDir, name)
                ctx.assets.open(name).use { i -> dst.outputStream().use { i.copyTo(it) } }
                RootShell.exec("cp ${dst.absolutePath} $WORK/$name")
                RootShell.exec("chmod 755 $WORK/$name")
                if (name.endsWith(".ko")) RootShell.exec("insmod $WORK/$name 2>/dev/null")
            }
        }
    }
}
