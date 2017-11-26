package com.iadvize.vdm.scrapper

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import com.iadvize.vdm.json.VDMJSONUtils

/**
  * Main class for http://www.viedemerde.fr.
  * Parse as many pages as needed in order to get 200 posts, convert them to a json document and
  * write it to a file
  */
object VDMSiteScrapper extends App {


  val paginatedParser = new VDMPaginatedParser(new VDMPageParser(new VDMPostParser))

  val jsonPosts = VDMJSONUtils.toJSON(paginatedParser.parse(200))

  Files.write(Paths.get("vdm_posts.json"), jsonPosts.getBytes(StandardCharsets.UTF_8))

}




