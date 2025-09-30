<script lang="ts">
  import {t} from 'i18n'
</script>

<ul>
  {#each Object.values(t.kov['2025'].parties) as party}
    <li><a href={party.url} target="_blank">{party.name}</a></li>
  {/each}
</ul>
