<script lang="ts">
  import {t} from 'i18n'

  let topics = t.compass.tallinn2025

  const options = [-2, -1, 0, 1, 2]
</script>

<div class="max-w-xl mx-auto mb-10">
  {#each topics as topic}
    <section class="mt-4 space-y-4">
      <h2>{topic.name}</h2>

      {#each Object.entries(topic.questions) as [i, question]}
        <h3>{i}. {question}</h3>
        <div class="flex gap-4 justify-center">
          {#each options as option, i}
            <label class="flex items-center gap-2">
              <input type="radio" name="option">
              {t.compass.options[option.toString()]}
            </label>
          {/each}
        </div>
      {/each}
    </section>
  {/each}
</div>
