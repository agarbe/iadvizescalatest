package com.iadvize.vdm.json

import com.iadvize.vdm.scrapper.VDMPost
import org.json4s.jackson.Serialization.{write,read}

object VDMJSONUtils {

  private implicit val formats = org.json4s.DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all

  def toJSON(posts: List[VDMPost]): String = write(("posts",posts))

  def toJSON(post: VDMPost): String = write(("post",post))

  def fromJSON(jsonPosts: String): List[VDMPost] = read[Tuple2[String,List[VDMPost]]](jsonPosts)._2


}
