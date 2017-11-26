package com.iadvize.vdm.scrapper


import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.text
import org.joda.time.format.DateTimeFormat
import org.joda.time.{DateTime, DateTimeZone}

/**
  * Parser for a http://www.viedemerde.fr post.
  */
class VDMPostParser {

  private val postAuthorAndDatePattern = "^Par (.*) -.*/ (.*) /.*$".r

  private val postDateFormat = DateTimeFormat.forPattern("EEE dd MMMM yyyy HH:mm").withLocale(java.util.Locale.FRENCH)

  /**
    * Takes an article element wrapping a VDM post and return a [[VDMPost]]
    *
    * @param post A scalascraper Element corresponding to the article tag wrapping a VDM post
    * @return a [[VDMPost]]
    */
  def parse(post: Element): VDMPost = {

    def parseContent(post: Element): String = post >> text("div.panel-content > p > a")

    def parseAuthorAndDate(post: Element): (String, DateTime) = {

      (post >> text("div.text-center")) match {

        case postAuthorAndDatePattern(author, date) => (author, postDateFormat.parseDateTime(date).withZone(DateTimeZone.UTC))

      }
    }

    val (author, date) = parseAuthorAndDate(post)
    val content = parseContent(post);

    VDMPost(VDMPostIdGenerator.nextId, author, date, content)


  }


}
