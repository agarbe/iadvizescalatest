package com.iadvize.vdm.api

import com.iadvize.vdm.scrapper.VDMPost
import org.joda.time.DateTime

/**
  * Utility class for searching through a list of [[VDMPost]]
  */
object VDMPostSearcher {

  /**
    * Search by author , from and to date.
    * None parameters will be egnored
    *
    * @param posts  the post collection to search through
    * @param author the author to search for (or None)
    * @param from   the date to search from (or None)
    * @param to     the date to search to (or None)
    * @return a filtered list of [[VDMPost]]
    */
  def search(posts: List[VDMPost], author: Option[String], from: Option[DateTime], to: Option[DateTime]): List[VDMPost] = {

    posts
      .filter(author == None || _.author == author.get)
      .filter(post => from == None || post.date == from.get || post.date.isAfter(from.get))
      .filter(post => to == None || post.date == to.get || post.date.isBefore(to.get))
  }
}
