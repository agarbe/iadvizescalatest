package com.iadvize.vdm.json

import com.iadvize.vdm.scrapper.VDMPost
import org.json4s.jackson.Serialization.write

object VDMJSONUtils {

  private implicit val formats = org.json4s.DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all

  def toJSON(posts: List[VDMPost]): String = write(posts)

}
