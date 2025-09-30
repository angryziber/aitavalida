<script lang="ts">
  import {t} from 'i18n'

  let elections = t.compass.tallinn2025

  const options = [-2, -1, 0, 1, 2]

  let answers = {}
</script>

<div class="max-w-xl mx-auto mb-10">
  {#each elections.topics as topic}
    <section class="mt-4 space-y-4">
      <h2>{topic.name}</h2>

      {#each Object.entries(topic.questions) as [i, question]}
        <h3>{i}. {question}</h3>
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
