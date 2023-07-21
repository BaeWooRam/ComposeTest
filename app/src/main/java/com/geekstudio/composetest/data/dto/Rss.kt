package com.geekstudio.composetest.data.dto

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class Rss(
    @param:Attribute(name = "version")
    @field:Attribute(name = "version")
    var version:String = "",

    @param:Element(name = "channel")
    @field:Element(name = "channel")
    var channel:Channel? = null
)