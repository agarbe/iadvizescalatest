package com.iadvize.vdm.scrapper

import org.joda.time.DateTime
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class VDMPaginatedParserSpec extends FlatSpec with Matchers with MockFactory {


  "A Paginated Parser with an expected count of 200 posts" should "return exactly 200 posts" in {

    //Given
    val mockVDMPosts = List.fill(26)(new VDMPost(1,"author", new DateTime(), "content"))
    val mockVDMPageParser = mock[VDMPageParser]

    (mockVDMPageParser.parsePage _).expects(*).repeat(8).returning(mockVDMPosts)

    val vDMPaginatedParser = new VDMPaginatedParser(mockVDMPageParser)

    //When
    val vDMPosts = vDMPaginatedParser.parse(200)

    //Then
    assert(vDMPosts.length == 200)
  }

}
