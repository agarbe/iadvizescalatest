package com.iadvize.vdm.json

import com.iadvize.vdm.scrapper.VDMPost
import org.joda.time.DateTime
import org.scalatest._


class VDMJSONUtilsSpec extends FlatSpec with Matchers {

  "A VDMPost list of two posts" should "be converted in a json array of two elements" in {

    //Given
    val vDMPosts = List.fill(2)(new VDMPost("author", DateTime.parse("2017-11-25T14:30:00.000Z"), "content"))

    //When
    val jsonPosts = VDMJSONUtils.toJSON(vDMPosts)

    //Then
    assert(jsonPosts == "[{\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"},{\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"}]")
  }
}
