package observatory

import scala.io.Source

case class Location(lat: Double, lon: Double)

case class Color(red: Int, green: Int, blue: Int)

case class StationKey(stn: Option[Int], wban: Option[Int])

case class TempsLine(key: StationKey, month: Int, day: Int, temp: Double)

object Colors {
  val temperatures: List[(Double, Color)] = List(
    (60.0, Color(255, 255, 255)),
    (32.0, Color(255, 0, 0)),
    (12.0, Color(255, 255, 0)),
    (0.0, Color(0, 255, 255)),
    (-15.0, Color(0, 0, 255)),
    (-27.0, Color(255, 0, 255)),
    (-50.0, Color(33, 0, 107)),
    (-60.0, Color(0, 0, 0))
  )

  val anomalies: List[(Double, Color)] = List(
    (7.0, Color(0, 0, 0)),
    (4.0, Color(255, 0, 0)),
    (2.0, Color(255, 255, 0)),
    (0.0, Color(255, 255, 255)),
    (-2.0, Color(0, 255, 255)),
    (-7.0, Color(0, 0, 255))
  )

}

object DataSource {
  type Lookup = ((String) => Source)

  /* Lookup data source from class resources */
  val resourceFileLookup: Lookup = (path: String) => Source.fromInputStream(getClass.getResourceAsStream(path))
}