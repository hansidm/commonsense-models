package io.github.tetherlessworld.commonsense_models.benchmarkquestion.commonsenseQA.dataset.readers

import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkAnswer
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkQuestionId
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.Category
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.commonsenseQA.CommonsenseQAQuestion
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.commonsenseQA.CommonsenseQAAnswer

import play.api.libs.json._

import scala.io.Source

object CommonsenseQADatasetReader {
    def read(path: String) {
        for (line <- Source.fromFile(path).getLines) {
            val json: JsValue = Json.parse(line)
            println(readQuestion(json))
        }
    }

    def readQuestion(json: JsValue): CommonsenseQAQuestion = {
        val answerOptionsObj : Set[BenchmarkAnswer] = 
            (json \ "question" \ "choices").get.as[Set[JsObject]].map(
                choice => CommonsenseQAAnswer(
                    id = choice("label").toString,
                    value = choice("text").toString
                )
            )
        val answerObj : BenchmarkAnswer = {
            var answer : BenchmarkAnswer = null
            answerOptionsObj.foreach(obj =>
                if (obj.id.equals(json("answerKey").toString)) {
                    answer = obj
                }
            )
            answer
        }
        CommonsenseQAQuestion(
            id = BenchmarkQuestionId(json("id").toString),
            questionString = (json \ "question" \ "stem").get.toString,
            categories = Set(Category((json \ "question" \ "question_concept").get.toString)),
            answerOptions = answerOptionsObj,
            answer = answerObj
        )
    }
}