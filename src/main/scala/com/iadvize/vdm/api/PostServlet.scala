package com.example.app
import com.iadvize.vdm.json.VDMJSONUtils
import org.scalatra._

/**
  * Main Servlet class for the api
  */
class PostServlet extends ScalatraServlet {

  private val jsonPosts =scala.io.Source.fromFile("vdm_posts.json").mkString
  private val posts = VDMJSONUtils.fromJSON(jsonPosts)

  get("/api/posts") {
    jsonPosts
  }
}