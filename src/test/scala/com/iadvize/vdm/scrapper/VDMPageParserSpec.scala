package com.iadvize.vdm.scrapper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.browser.JsoupBrowser.JsoupDocument
import org.joda.time.DateTime
import org.scalamock.scalatest.MockFactory
import org.scalatest._


class VDMPageParserSpec extends FlatSpec with Matchers with MockFactory {

  "A VDM Page" should "be parsed correctly" in {

    //Given
    val mockVDMPostParser = mock[VDMPostParser]
    val vDMPageParser = new VDMPageParser(mockVDMPostParser)
    (mockVDMPostParser.parse _).expects(*).anyNumberOfTimes().returning(new VDMPost(1,"author", new DateTime(), "content"))

    val mockBrowser = mock[JsoupBrowser]
    vDMPageParser.browser = mockBrowser
    val browser = new JsoupBrowser()
    val doc: JsoupDocument = browser.parseResource("/VDMPage.html")
    (mockBrowser.get _).expects("http://www.viedemerde.fr/?page=1").once().returning(doc)

    //When
    val vDMPosts = vDMPageParser.parsePage("http://www.viedemerde.fr/?page=1")

    //Then
    assert(vDMPosts.length == 44)
  }

}
