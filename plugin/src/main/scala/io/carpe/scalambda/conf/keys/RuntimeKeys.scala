package io.carpe.scalambda.conf.keys

import io.carpe.scalambda.conf.function.ScalambdaRuntime
import io.carpe.scalambda.conf.function.ScalambdaRuntime.{Java11, Java8}

trait RuntimeKeys {

  @deprecated(message = "Java 8 is really old. It's time to upgrade! Use Java11 instead", since = "5.1.0")
  lazy val Java8: ScalambdaRuntime = ScalambdaRuntime.Java8

  lazy val Java11: ScalambdaRuntime = ScalambdaRuntime.Java11
}
