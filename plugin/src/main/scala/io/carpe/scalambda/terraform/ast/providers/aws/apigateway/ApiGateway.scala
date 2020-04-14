package io.carpe.scalambda.terraform.ast.providers.aws.apigateway

import io.carpe.scalambda.conf.utils.StringUtils
import io.carpe.scalambda.terraform.ast.Definition.Resource
import io.carpe.scalambda.terraform.ast.props.TValue
import io.carpe.scalambda.terraform.ast.props.TValue.{TDataRef, TString}
import io.carpe.scalambda.terraform.ast.providers.terraform.data.TemplateFile

case class ApiGateway(apiName: TValue, description: Option[String], swaggerFile: TemplateFile) extends Resource {
  /**
   * Examples: "aws_lambda_function" "aws_iam_role"
   */
  override lazy val resourceType: String = "aws_api_gateway_rest_api"

  /**
   * Examples: "my_lambda_function" "my_iam_role"
   *
   * @return
   */
  override def name: String = StringUtils.toSnakeCase("api")

  /**
   * Properties of the definition
   */
  override def body: Map[String, TValue] = Map(
    "name" -> apiName,
    "description" -> TString(description.getOrElse("Generated by Scalambda")),
    "body" -> TDataRef(swaggerFile, "rendered")
  )
}
