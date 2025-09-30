<script lang="ts">
  import {t} from 'i18n'
  import Parties from 'src/pages/Parties.svelte'

  export let name = 'tallinn2025' as const

  let elections = t.compass[name]

  const options = [-2, -1, 0, 1, 2]
  const parties = t.kov['2025'].parties

  let answers = JSON.parse(localStorage[name] ?? '{}')
  $: localStorage[name] = JSON.stringify(answers)

  $: results = Object.keys(parties).map(p => {
    let score = 0
    let count = 0
    for (let topic of elections.topics) {
      for (let [i, question] of Object.entries(topic.questions)) {
        if (!(i in answers)) continue
        score += (answers[i] - question.parties[p]) ** 2
        count++
      }
    }
    return {[p]: Math.sqrt(score / count)}
  }).sort((a, b) => a.score - b.score)
</script>

<h2 class="my-2">{elections.name} - {t.compass.title}</h2>

<Parties/>

<div class="max-w-xl mx-auto mb-96">
  {#each elections.topics as topic}
    <section class="mt-4 space-y-4">
      <h3 class="sticky top-0 bg-yellow-100 py-1">{topic.name}</h3>

      {#each Object.entries(topic.questions) as [i, question]}
        <h4>{i}. {question.q}</h4>
        <div class="flex justify-center pb-8">
          {#each options as option}
            {@const checked = answers[i] === option}
            <button class="px-3 py-2 border" class:bg-gray-100={checked} aria-checked={checked} onclick={() => answers[i] = option}>
              {t.compass.options[option.toString()]}
            </button>
          {/each}
        </div>
      {/each}
    </section>
  {/each}
</div>
{JSON.stringify(results)}
