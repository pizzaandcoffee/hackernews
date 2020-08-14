load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")

scala_library(
    name = "hackernews-lib",
    srcs = glob(["src/main/scala/rocks/pizzaandcoffee/hackernews/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:org_scalaj_scalaj_http_2_11",
        "@maven//:org_json4s_json4s_core_2_11",
        "@maven//:org_json4s_json4s_native_2_11"
    ]
)

scala_test(
  name = "test",
  srcs = glob(["src/test/scala/rocks/pizzaandcoffee/hackernews/**/*.scala"]),
  deps = ["hackernews-lib"]
)
