package com.qubole.sparklens.helper

import org.apache.hadoop.conf.Configuration
import org.apache.spark.SparkConf

object HDFSConfigHelper {

  def getHadoopConf(sparkConfOptional: Option[SparkConf]): Configuration = {
    sparkConfOptional match {
      case Some(sparkConf) =>
        // Manually create a new Hadoop configuration and set properties from SparkConf
        val hadoopConf = new Configuration()
        sparkConf.getAll.foreach { case (key, value) =>
          hadoopConf.set(key, value)
        }
        hadoopConf
      case None =>
        // Return a default Hadoop configuration if SparkConf is not provided
        new Configuration()
    }
  }
}