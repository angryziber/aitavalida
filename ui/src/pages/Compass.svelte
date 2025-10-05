<script lang="ts">
  import {lang, t} from 'i18n'
  import Parties from 'src/pages/Parties.svelte'
  import api from 'src/api/api'
  import type {CompassAnswers} from 'src/api/types'

  export let slug = 'tallinn2025' as const

  let elections = t.compass[slug]
  let questions = elections.questions

  const options = [-2, -1, 0, 1, 2]
  const optionColors = ['bg-red-200', 'bg-red-100', 'bg-yellow-100', 'bg-green-100', 'bg-green-200']
  const optionSelectedColors = ['bg-red-500', 'bg-red-400', 'bg-yellow-500', 'bg-green-400', 'bg-green-500']
  const parties = t.kov['2025'].parties

  let answers = JSON.parse(localStorage[slug] ?? '{}') as Record<string, number>
  $: if (Object.keys(answers).length) {
    localStorage[slug] = JSON.stringify(answers)
    save()
  }

  async function save() {
    let id = localStorage['compassId']
    id = await api.post('compass/answers', {id, compassSlug: slug, lang, answers} as CompassAnswers)
    localStorage['compassId'] = id
  }

  $: results = Object.keys(parties).map(p => {
    let score = 0
    let count = 0
    for (let i of Object.keys(questions)) {
      if (!(i in answers)) continue
      score += (answers[i] - elections.parties[i][p]) ** 2
      count++
    }
    return {party: p, score: Math.sqrt(score / count)}
  }).sort((a, b) => a.score - b.score)
</script>

<h2 class="m-4">{elections.name} - {t.compass.title}</h2>

<div class="max-w-xl mx-auto mb-96">
  <p class="bg-purple-200 px-6 py-4 my-4">{t.compass.disclaimer}</p>

  <Parties {parties}/>
  <!-- TODO: select party for comparison -->

  {#each elections.topics as topic}
    <section class="mt-4 space-y-4">
      <h3 class="sticky top-0 z-20 bg-purple-500 text-white py-2">{topic.name}</h3>

      {#each topic.questions as i}
        <h4 class="mx-2">{i}. {questions[i]}</h4>
        <div class="flex justify-center pb-8">
          {#each options as option, j}
            {@const checked = answers[i] === option}
            <button class="px-3 py-2 max-sm:text-sm {checked ? optionSelectedColors[j] + ' text-white outline outline-black z-10' : optionColors[j]}" aria-checked={checked} onclick={() => answers[i] = option}>
              {t.compass.options[option.toString()]}
            </button>
          {/each}
        </div>
      {/each}
    </section>
  {/each}

  <h2 class="my-8">{t.compass.results}</h2>
  {#each results as result}
    <div><b>{parties[result.party].name}</b>: {result.score.toFixed(2)}</div>
  {/each}
</div>
