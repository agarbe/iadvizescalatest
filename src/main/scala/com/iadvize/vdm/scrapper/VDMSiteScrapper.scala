package com.iadvize.vdm.scrapper

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import com.iadvize.vdm.json.VDMJSONUtils
import com.typesafe.scalalogging.Logger

/**
  * Main class for http://www.viedemerde.fr.
  * Parse as many pages as needed in order to get 200 posts, convert them to a json document and
  * write it to a file
  */
object VDMSiteScrapper extends App {


  private val logger = Logger[VDMPageParser]

  val paginatedParser = new VDMPaginatedParser(new VDMPageParser(new VDMPostParser))

  logger.info("Scrapping started")

  val jsonPosts = VDMJSONUtils.toJSON(paginatedParser.parse(200))

  logger.info("Scrapping ended")

  Files.write(Paths.get("vdm_posts.json"), jsonPosts.getBytes(StandardCharsets.UTF_8))

}




