package com.iadvize.vdm.scrapper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.scraper.ContentExtractors._
import net.ruippeixotog.scalascraper.dsl.DSL._
import org.joda.time.DateTime
import org.scalatest._


class VDMPostParserSpec extends FlatSpec with Matchers {

  "A VDMPost" should "be parsed correctly" in {

    //Given
    val vdmPostParser = new VDMPostParser()
    val browser = JsoupBrowser()
    val doc = browser.parseResource("/VDMPost.html")
    val post = doc >> element("article > div.panel > div.panel-body")

    //When
    val vDMPost = vdmPostParser.parse(post)

    //Then
    assert(vDMPost.id == 1)
    assert(vDMPost.author == "Anonyme")
    assert(vDMPost.content == "Aujourd'hui, ma fille de 14 ans se trouve tellement jolie sur son portrait de classe qu'elle m'a dit tout à fait sérieusement : \"Si je me fais enlever, j'espère qu'ils vont montrer cette photo à la télé !\" VDM")
    assert(vDMPost.date == DateTime.parse("2017-11-25T14:30:00.000Z"))
  }
}
