package com.iadvize.vdm.json

import com.iadvize.vdm.scrapper.VDMPost
import org.joda.time.DateTime
import org.scalatest._


class VDMJSONUtilsSpec extends FlatSpec with Matchers {

  "A VDMPost list of two posts" should "be converted in a json array of two elements" in {

    //Given
    val vDMPosts = List.fill(2)(new VDMPost(1,"author", DateTime.parse("2017-11-25T14:30:00.000Z"), "content"))

    //When
    val jsonPosts = VDMJSONUtils.toJSON(vDMPosts)

    //Then
    assert(jsonPosts == "{\"posts\":[{\"id\":1,\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"},{\"id\":1,\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"}]}")
  }

  "A json array containing 2 posts" should "be converted in a VDMPost list of 2 elements" in {

    //Given
    val jsonPosts = "{\"posts\":[{\"id\":1,\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"},{\"id\":2,\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"}]}"

    //When
    val posts = VDMJSONUtils.fromJSON(jsonPosts)

    //Then
    assert (posts.length == 2)
  }

  "A VDMPost list of two posts" should "be converted in a json array of two elements with a count of 2" in {

    //Given
    val vDMPosts = List.fill(2)(new VDMPost(1,"author", DateTime.parse("2017-11-25T14:30:00.000Z"), "content"))

    //When
    val jsonPosts = VDMJSONUtils.toJSONWithPostCount(vDMPosts)

    //Then
    assert(jsonPosts == "{\"posts\":[{\"id\":1,\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"},{\"id\":1,\"author\":\"author\",\"date\":\"2017-11-25T14:30:00Z\",\"content\":\"content\"}],\"count\":2}")
  }



}
