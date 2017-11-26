package com.example.app

import com.iadvize.vdm.api.VDMPostSearcher
import com.iadvize.vdm.json.VDMJSONUtils
import org.joda.time.DateTime
import org.scalatra._

/**
  * Main Servlet class for the api
  */
class PostServlet extends ScalatraServlet {

  private val posts = VDMJSONUtils.fromJSON(scala.io.Source.fromFile("vdm_posts.json").mkString)

  /**
    * returns the posts optionally filtered by date and author
    */
  get("/api/posts") {

    val from = params.get("from").map(DateTime.parse(_))
    val to = params.get("to").map(DateTime.parse(_))
    val author = params.get("author")

    VDMJSONUtils.toJSON(VDMPostSearcher.search(posts, author, from, to))

  }

  get("/api/posts/:id") {

    val post = VDMPostSearcher.findById(posts, params.get("id").get.toInt)

    if (post.isDefined) Ok(VDMJSONUtils.toJSON(post.get)) else NotFound("Not found")

  }

}