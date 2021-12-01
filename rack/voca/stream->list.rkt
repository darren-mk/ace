#lang racket/base

(require racket/stream)

(stream->list (in-range 3 5))
