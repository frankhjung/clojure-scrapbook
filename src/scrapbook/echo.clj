(ns scrapbook.echo)

(defn greet "Function with variable number of arguments"
  [w & who]
  (map #(str w " " % "!") who))

(defn my-echo
  "Function with different processing for arguments passed"
  ([one] (str "argument" one))
  ([one two] (str "arguments" one two)))