package com.iadvize.vdm.scrapper

import org.joda.time.DateTime


/**
  * Case Class describing a http://www.viedemerde.fr post
  */
case class VDMPost(id: Int,author: String, date: DateTime, content: String)
