# Scala Code Garden

## Introduction

This repository is intended to be an introductory Scala project. The ideas
are based on the concepts express in the slides of the Code Garden talk.
You can find the slides in the /doc folder; to open them, use your
favourite browser.

## Idea behind the code

The goal of the project is to show the fundamentals of the Scala
programming language:

- in the /model folder, you can find small example of case classes,
  case objects and sealed trait
- in the /service folder, you can find the RepoDownloader and RepoBuilder
  services, arranged in a way to show the cake pattern
- in the /magnet folder, you can find a class with a very simple
  implementation of the magnet pattern

The code executes a maven build under a local environment and under
a docker environment.
Some parts of the code only work on my machine, mainly because the repo
lives on my computer.
  
## Contribute
If you want to ask questions or to add a feature, feel free to contribute.
