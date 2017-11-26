package com.iadvize.vdm.json

import com.iadvize.vdm.scrapper.VDMPost
import org.json4s.jackson.Serialization.{read, write}

/**
  * Object class used to convert VDMPost objects to and from JSON format
  */
object VDMJSONUtils {

  private implicit val formats = org.json4s.DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all

  /**
    * Takes a list of [[VDMPost]] and convert them to a json doc
    *
    * @param posts a [[VDMPost]] List
    * @return a json document
    */
  def toJSON(posts: List[VDMPost]): String = write(("posts", posts))

  /**
    * Takes a list of [[VDMPost]] and convert them to a json doc, adding a "count" field
    *
    * @param posts a [[VDMPost]] List
    * @return a json document
    */
  def toJSONWithPostCount(posts: List[VDMPost]): String = write(Map("posts" -> posts, "count" -> posts.size))

  /**
    * Takes a [[VDMPost]] and return a json document
    *
    * @param post a [[VDMPost]]
    * @return a json document
    */
  def toJSON(post: VDMPost): String = write(("post", post))

  /**
    * Takes a json document containing several posts (without the "count" field) and convert them to a List
    * of [[VDMPost]]
    *
    * @param jsonPosts the json document
    * @return a list of [[VDMPost]]
    */
  def fromJSON(jsonPosts: String): List[VDMPost] = read[Tuple2[String, List[VDMPost]]](jsonPosts)._2


}
