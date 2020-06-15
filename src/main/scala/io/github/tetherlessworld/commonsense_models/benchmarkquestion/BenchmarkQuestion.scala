package io.github.tetherlessworld.commonsense_models.benchmarkquestion

trait BenchmarkQuestion {
    val id: BenchmarkQuestionId;
    val questionString: String;
    val categories: Set[Category];
    val answerOptions: Set[BenchmarkAnswer];
    val answer: BenchmarkAnswer;
}