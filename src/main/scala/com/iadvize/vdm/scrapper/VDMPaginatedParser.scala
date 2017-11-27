package com.iadvize.vdm.scrapper

import com.typesafe.scalalogging.Logger

/**
  * Retreive a fixed number of http://www.viedemerde.fr posts by parsing as many pages as necessary
  */
class VDMPaginatedParser(pageParser: VDMPageParser) {

  private val logger = Logger[VDMPaginatedParser]

  /**
    * Parse as many VDM pages as necessary in order to reach the expected post count
    *
    * @param expectedPostCount the number of posts to fetch
    */
  def parse(expectedPostCount: Int): List[VDMPost] = {

    var posts = List[VDMPost]()

    var currentPage = 1

    while (posts.length < expectedPostCount) {
      logger.debug("Parsing page " + currentPage)
      posts ++= pageParser.parsePage("http://www.viedemerde.fr/?page=" + currentPage)
      currentPage += 1
    }

    posts.take(expectedPostCount)
  }

}
