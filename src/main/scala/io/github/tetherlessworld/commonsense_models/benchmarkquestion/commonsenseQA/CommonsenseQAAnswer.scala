package io.github.tetherlessworld.commonsense_models.benchmarkquestion.commonsenseQA

import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkQuestion
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkQuestionId
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.Category
import io.github.tetherlessworld.commonsense_models.benchmarkquestion.BenchmarkAnswer

final case class CommonsenseQAAnswer(
    id: String,
    value: String
) extends BenchmarkAnswer