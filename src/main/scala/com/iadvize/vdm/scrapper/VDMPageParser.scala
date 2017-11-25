package com.iadvize.vdm.scrapper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.elementList

/**
  * Parser for a http://www.viedemerde.fr page
  */
class VDMPageParser(postParser: VDMPostParser) {

  var browser = JsoupBrowser()

  /**
    * Parse a VDM page looking for posts and return them as a list of [[VDMPost]]
    *
    * @param pageURL the page URL
    * @return a List of [[VDMPost]]
    */
  def parsePage(pageURL: String): List[VDMPost] = {

    val doc = browser.get(pageURL)
    val posts = doc >> elementList("article > div.panel > div.panel-body")


    posts.flatMap(post =>
      try {
        Some(postParser.parse(post))
      } catch {
        case e:
          Exception => println
          None
      }
    )
  }

}
