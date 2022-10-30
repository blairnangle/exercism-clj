(ns exercism-clj.protein-translation.protein-translation)

(defn translate-codon
  [codon]
  (get {
        "AUG" "Methionine",
        "UUU" "Phenylalanine", "UUC" "Phenylalanine",
        "UUA" "Leucine", "UUG" "Leucine"
        "UCU" "Serine", "UCC" "Serine", "UCA" "Serine", "UCG" "Serine",
        "UAU" "Tyrosine", "UAC" "Tyrosine",
        "UGU" "Cysteine", "UGC" "Cysteine",
        "UGG" "Tryptophan",
        "UAA" "STOP", "UAG" "STOP", "UGA" "STOP"
        } codon)

  )

(defn translate-rna
  [rna]
  (take-while #(not= % "STOP")
              (map translate-codon
                   (re-seq #".{3}" rna)
                   ))
  )
