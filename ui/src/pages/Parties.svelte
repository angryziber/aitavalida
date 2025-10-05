<script lang="ts">
  import {t} from 'i18n'

  export let parties: Record<string, {name: string, url: string}>
</script>

<p class="mb-4">{t.compass.programs}:</p>
<ul class="grid grid-cols-2 md:grid-cols-3">
  {#each Object.values(parties) as party}
    <li><a href={party.url} target="_blank">{party.name}</a></li>
  {/each}
</ul>
