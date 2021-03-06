package com.webtrends.harness.service.test

import ch.qos.logback.classic.Level
import com.typesafe.config.{Config, ConfigFactory}
import com.webtrends.harness.component.Component
import com.webtrends.harness.service.Service
import org.specs2.mutable.SpecificationLike
import org.scalatest.{MustMatchers, WordSpecLike}

trait BaseWookieeTest {
  def config:Config = ConfigFactory.empty()
  def componentMap:Option[Map[String, Class[_<:Component]]] = None
  def servicesMap:Option[Map[String, Class[_<:Service]]] = None
  def logLevel: Level = Level.INFO

  TestHarness(config, servicesMap, componentMap, logLevel)
  Thread.sleep(1000)
  implicit val system = TestHarness.system.get
}

trait BaseWookieeSpecTest extends BaseWookieeTest with SpecificationLike
trait BaseWookieeScalaTest extends BaseWookieeTest with WordSpecLike with MustMatchers
