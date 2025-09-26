# bazel-run-reproducer

Simple Bazel/Java repo to demonstrate an issue with the Bazel JetBrains plugin
(v2025.2.1) - running a target within IntelliJ and then pressing "stop"
terminates the process in such a way that any shutdown hooks are not run.

To reproduce - run the target `//src:Demo` in IntelliJ.