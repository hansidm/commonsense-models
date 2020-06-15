package io.github.tetherlessworld.commonsense_models.benchmarkquestion.commonsenseQA.dataset.readers

import io.github.tetherlessworld.commonsense_models.UnitSpec

class CommonsenseQADatasetReaderTest extends UnitSpec {
    CommonsenseQADatasetReader.read("./data/CommonsenseQA/train_rand_split.jsonl")
}