package com.aimornai.pubgmenu.config

data class EspConfig(
    var enabled: Boolean = false,
    var maxDistance: Float = 300f,
    var visibleCheck: Boolean = false,

    var boxEnabled: Boolean = true,
    var boxStyle: Int = 0,
    var boxThickness: Float = 1.5f,
    var boxColor: Int = 0xFF00FF00.toInt(),

    var skeletonEnabled: Boolean = false,
    var skeletonThickness: Float = 1.5f,
    var skeletonColor: Int = 0xFFFF0000.toInt(),

    var snapLinesEnabled: Boolean = false,
    var topLinesEnabled: Boolean = false,
    var linesColor: Int = 0xFFFFAA00.toInt(),

    var nameEnabled: Boolean = true,
    var distanceEnabled: Boolean = true,
    var healthBarEnabled: Boolean = true,
    var armorBarEnabled: Boolean = false,
    var weaponEnabled: Boolean = false,
    var teamCheck: Boolean = true,
    var infoTextColor: Int = 0xFFFFFFFF.toInt(),

    var selectedBone: Int = 0,
    var fovCircleEnabled: Boolean = false,
    var fovRadius: Float = 150f,
    var fovColor: Int = 0x80FFFFFF.toInt(),

    var itemEspEnabled: Boolean = false,
    var itemMaxDistance: Float = 200f,
    var itemColor: Int = 0xFF00FFFF.toInt(),

    var vehicleEspEnabled: Boolean = false,
    var vehicleDistanceEnabled: Boolean = true,
    var vehicleColor: Int = 0xFFFF00FF.toInt()
)
