# iadvizescalatest

Sample scala application parsing the first 200 posts from http://www.viedemerde.fr and exposing them via a REST API

To launch it simply clone the repository and enter "docker-compose up" in a terminal.
The application will fetch the 200 first posts of http://www.viedemerde.fr, store them on a file on disk as json records
and expose them through a REST API backed by scalatra

The project is built with SBT and comes with a scalatest test suite.
Main entry points are:
- com.iadvize.vdm.scrapper.VDMSiteScrapper for the site scrapper
- com.iadvize.vdm.api.PostServlet for the REST API


Enjoy ;)
