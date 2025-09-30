<script lang="ts">
  export let parties: Record<string, {name: string, url: string}>
</script>

<ul>
  {#each Object.values(parties) as party}
    <li><a href={party.url} target="_blank">{party.name}</a></li>
  {/each}
</ul>
