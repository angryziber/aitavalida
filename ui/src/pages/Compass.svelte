<script lang="ts">
  import {t} from 'i18n'

  let topics = t.compass.tallinn2025
  let topicIndex = 0
  let questionIndex = 1

  $: topic = topics[topicIndex]
  $: question = topic.questions[questionIndex]

  const options = [-2, -1, 0, 1, 2]
</script>

<section class="mt-4 space-y-4">
  <h2>{topic.name}</h2>

  <h3>{questionIndex}. {question}</h3>

  <div class="flex gap-4 justify-center">
    {#each options as option, i}
      <label class="flex items-center gap-2">
        <input type="radio" name="option">
        {t.compass.options[option.toString()]}
      </label>
    {/each}
  </div>
</section>
