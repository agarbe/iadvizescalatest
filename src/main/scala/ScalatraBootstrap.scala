
import javax.servlet.ServletContext

import com.iadvize.vdm.api.PostServlet
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new PostServlet, "/*")
  }
}
