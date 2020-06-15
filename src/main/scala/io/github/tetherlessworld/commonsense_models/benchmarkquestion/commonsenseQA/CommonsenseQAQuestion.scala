package io.github.tetherlessworld.commonsense_models.benchmarkquestion.commonsenseQA

import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkQuestion
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkQuestionId
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.Category
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkAnswer

final case class CommonsenseQAQuestion(
    id: BenchmarkQuestionId,
    questionString: String,
    categories: Set[Category] = Set(),
    answerOptions: Set[BenchmarkAnswer] = Set(),
    answer: BenchmarkAnswer
) extends BenchmarkQuestion