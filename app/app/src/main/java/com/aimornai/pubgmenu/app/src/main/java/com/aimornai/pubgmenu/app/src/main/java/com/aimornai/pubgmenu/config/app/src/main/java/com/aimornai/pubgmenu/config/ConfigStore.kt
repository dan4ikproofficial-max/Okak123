package com.aimornai.pubgmenu.config

import com.aimornai.pubgmenu.PayloadLoader
import com.aimornai.pubgmenu.RootShell
import org.json.JSONObject

object ConfigStore {
    private fun path() = "${PayloadLoader.WORK}/config.json"

    fun save(c: EspConfig) {
        val j = JSONObject().apply {
            put("enabled", c.enabled)
            put("maxDistance", c.maxDistance.toDouble())
            put("visibleCheck", c.visibleCheck)
            put("boxEnabled", c.boxEnabled)
            put("boxStyle", c.boxStyle)
            put("boxThickness", c.boxThickness.toDouble())
            put("boxColor", c.boxColor)
            put("skeletonEnabled", c.skeletonEnabled)
            put("skeletonThickness", c.skeletonThickness.toDouble())
            put("skeletonColor", c.skeletonColor)
            put("snapLinesEnabled", c.snapLinesEnabled)
            put("topLinesEnabled", c.topLinesEnabled)
            put("linesColor", c.linesColor)
            put("nameEnabled", c.nameEnabled)
            put("distanceEnabled", c.distanceEnabled)
            put("healthBarEnabled", c.healthBarEnabled)
            put("armorBarEnabled", c.armorBarEnabled)
            put("weaponEnabled", c.weaponEnabled)
            put("teamCheck", c.teamCheck)
            put("infoTextColor", c.infoTextColor)
            put("selectedBone", c.selectedBone)
            put("fovCircleEnabled", c.fovCircleEnabled)
            put("fovRadius", c.fovRadius.toDouble())
            put("fovColor", c.fovColor)
            put("itemEspEnabled", c.itemEspEnabled)
            put("itemMaxDistance", c.itemMaxDistance.toDouble())
            put("itemColor", c.itemColor)
            put("vehicleEspEnabled", c.vehicleEspEnabled)
            put("vehicleDistanceEnabled", c.vehicleDistanceEnabled)
            put("vehicleColor", c.vehicleColor)
        }
        val escaped = j.toString().replace("'", "'\\''")
        RootShell.exec("mkdir -p ${PayloadLoader.WORK}")
        RootShell.exec("sh -c \"echo '$escaped' > ${path()}\"")
    }

    fun load(): EspConfig {
        val raw = RootShell.exec("cat ${path()} 2>/dev/null")
        if (raw.isBlank()) return EspConfig()
        return try {
            val j = JSONObject(raw)
            EspConfig(
                enabled = j.optBoolean("enabled", false),
                maxDistance = j.optDouble("maxDistance", 300.0).toFloat(),
                visibleCheck = j.optBoolean("visibleCheck", false),
                boxEnabled = j.optBoolean("boxEnabled", true),
                boxStyle = j.optInt("boxStyle", 0),
                boxThickness = j.optDouble("boxThickness", 1.5).toFloat(),
                boxColor = j.optInt("boxColor", 0xFF00FF00.toInt()),
                skeletonEnabled = j.optBoolean("skeletonEnabled", false),
                skeletonThickness = j.optDouble("skeletonThickness", 1.5).toFloat(),
                skeletonColor = j.optInt("skeletonColor", 0xFFFF0000.toInt()),
                snapLinesEnabled = j.optBoolean("snapLinesEnabled", false),
                topLinesEnabled = j.optBoolean("topLinesEnabled", false),
                linesColor = j.optInt("linesColor", 0xFFFFAA00.toInt()),
                nameEnabled = j.optBoolean("nameEnabled", true),
                distanceEnabled = j.optBoolean("distanceEnabled", true),
                healthBarEnabled = j.optBoolean("healthBarEnabled", true),
                armorBarEnabled = j.optBoolean("armorBarEnabled", false),
                weaponEnabled = j.optBoolean("weaponEnabled", false),
                teamCheck = j.optBoolean("teamCheck", true),
                infoTextColor = j.optInt("infoTextColor", 0xFFFFFFFF.toInt()),
                selectedBone = j.optInt("selectedBone", 0),
                fovCircleEnabled = j.optBoolean("fovCircleEnabled", false),
                fovRadius = j.optDouble("fovRadius", 150.0).toFloat(),
                fovColor = j.optInt("fovColor", 0x80FFFFFF.toInt()),
                itemEspEnabled = j.optBoolean("itemEspEnabled", false),
                itemMaxDistance = j.optDouble("itemMaxDistance", 200.0).toFloat(),
                itemColor = j.optInt("itemColor", 0xFF00FFFF.toInt()),
                vehicleEspEnabled = j.optBoolean("vehicleEspEnabled", false),
                vehicleDistanceEnabled = j.optBoolean("vehicleDistanceEnabled", true),
                vehicleColor = j.optInt("vehicleColor", 0xFFFF00FF.toInt())
            )
        } catch (_: Throwable) { EspConfig() }
    }
}
