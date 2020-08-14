load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")
load("@graknlabs_bazel_distribution//maven/templates:rules.bzl", "deploy_maven", "assemble_maven")

scala_library(
    name = "hackernews",
    srcs = glob(["src/main/scala/rocks/pizzaandcoffee/hackernews/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:org_scalaj_scalaj_http_2_11",
        "@maven//:org_json4s_json4s_core_2_11",
        "@maven//:org_json4s_json4s_native_2_11",
    ],
    tags = ["maven_coordinates=rocks.pizzaandcoffee:hackernews:{pom_version}"],
)

scala_test(
  name = "tests-scala",
  srcs = glob(["src/test/scala/rocks/pizzaandcoffee/hackernews/**/*.scala"]),
  deps = [
    ":hackernews",
  ]
)

java_test(
    name = "tests-java",
    srcs = glob(["src/test/java/rocks/pizzaandcoffee/hackernews/**/*.java"]),
    test_class = "rocks.pizzaandcoffee.hackernews.JavaTest",
    deps = [
        ":hackernews",
        "@maven//:junit_junit",
    ],
)

assemble_maven(
    name = "assemble-maven",
    target = ":hackernews",
    package = "{maven_packages}",
    project_name = "Hackerews Api Wrapper",
    project_description = " Hackernews api wrapper for the JVM",
    project_url = "https://github.com/pizzaandcoffee/hackernews",
    scm_url = "https://github.com/pizzaandcoffee/hackernews.git",
    # version_file = "//central-sync:VERSION",
    license = "mit"
)
