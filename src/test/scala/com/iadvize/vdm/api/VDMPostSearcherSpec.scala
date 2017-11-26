package com.iadvize.vdm.api

import com.iadvize.vdm.scrapper.VDMPost
import org.joda.time.DateTime
import org.scalatest.{FlatSpec, Matchers}

class VDMPostSearcherSpec extends FlatSpec with Matchers {

  val posts = List(VDMPost(1, "VDM", DateTime.parse("2017-11-25T14:30:00.000Z"), "content"), VDMPost(2, "VDM", DateTime.parse("2017-11-25T15:30:00.000Z"), "content"), VDMPost(1, "USER", DateTime.parse("2017-11-25T14:30:00.000Z"), "content"))


  "A search without parameters" should "return all the posts" in {

    //When
    val filteredPosts = VDMPostSearcher.search(posts, None, None, None)

    //Then
    assert(filteredPosts.length == 3)
  }

  "A search for author VDM" should "only return the posts from this author" in {

    //When
    val filteredPosts = VDMPostSearcher.search(posts, Some("VDM"), None, None)

    //Then
    assert(filteredPosts.length == 2)
  }

  "A search for author USER" should "only return the posts from this author" in {

    //When
    val filteredPosts = VDMPostSearcher.search(posts, Some("USER"), None, None)

    //Then
    assert(filteredPosts.length == 1)
  }

  "A search from 2017-11-25T14:30:00.000Z to 2017-11-25T14:35:00.000Z  " should "return the posts between those two dates" in {

    //When
    val filteredPosts = VDMPostSearcher.search(posts, None, Some(DateTime.parse("2017-11-25T14:30:00.000Z")), Some(DateTime.parse("2017-11-25T14:35:00.000Z")))

    //Then
    assert(filteredPosts.length == 2)
  }

  "A search from 2017-11-25T15:30:00.000Z to 2017-11-25T15:30:00.000Z  " should "return the posts between those two dates" in {

    //When
    val filteredPosts = VDMPostSearcher.search(posts, None, Some(DateTime.parse("2017-11-25T15:30:00.000Z")), Some(DateTime.parse("2017-11-25T15:30:00.000Z")))

    //Then
    assert(filteredPosts.length == 1)
  }

  "A search from 2017-11-25T14:30:00.000Z to 2017-11-25T14:35:00.000Z and author USER " should "return the posts between those two dates from this author" in {

    //When
    val filteredPosts = VDMPostSearcher.search(posts, Some("USER"), Some(DateTime.parse("2017-11-25T14:30:00.000Z")), Some(DateTime.parse("2017-11-25T14:35:00.000Z")))

    //Then
    assert(filteredPosts.length == 1)
  }

}
