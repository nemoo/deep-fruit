
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Fruit {
  def main(args: Array[String]) {
    val logFile = "build.sbt" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
        .setMaster("local")  //run locally, on one single cpu
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}