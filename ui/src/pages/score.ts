export type Answers = Record<string, number>

export function weightedCosineSimilarity(vecA: Answers, vecB: Answers) {
  let dot = 0, magA = 0, magB = 0, rawOverlap = 0

  for (const [q, valA] of Object.entries(vecA)) {
    const valB = vecB[q]
    dot += valA * valB
    magA += valA * valA
    magB += valB * valB
    rawOverlap += Math.min(Math.abs(valA), Math.abs(valB)) / 2
  }

  if (!magA || !magB) return 0
  const cosine = dot / (Math.sqrt(magA) * Math.sqrt(magB))
  const cosineNormalized = (cosine + 1) / 2
  const overlapNormalized = rawOverlap / Object.keys(vecA).length
  return cosineNormalized * 0.8 + overlapNormalized * 0.2
}
